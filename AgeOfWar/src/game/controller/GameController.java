package game.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import core.builder.BuilderClanChosokabe;
import core.builder.BuilderClanMori;
import core.builder.BuilderClanOda;
import core.builder.BuilderClanShimazu;
import core.builder.BuilderClanTokugawa;
import core.builder.BuilderClanUesugi;
import core.builder.Director;
import core.factory.ClassicClan;
import core.model.Castle;
import core.model.Clan;
import core.model.Dice;
import core.model.Player;
import core.controller.NarutoController;
import core.factory.AbstractFactoryClan;
import core.visitor.PlayerVisitor;
import utils.adapter.AcmeForObject;
import utils.adapter.Adapter;
import utils.adapter.TecFileForObject;

public class GameController implements GameControllerInterface {

    private List<GameControllerObservers> observers;
    private List<Dice> diceList;
    private List<Clan> clanGlobalList = new ArrayList<>();
    private Random draft;
    private int diceChanges = 7;

    private Clan chosokabeClan;
    private Clan moriClan;
    private Clan shimazuClan;
    private Clan tokugawaClan;
    private Clan uesugiClan;
    private Clan odaClan;
    private AbstractFactoryClan classicClan;

    private Player player1;
    private Player player2;
    private NarutoController naruto;

    private Castle cardCastle;

    private Adapter acme;
    private Adapter tecFile;
    
    private PlayerVisitor visitor;
    
    private static GameController instance;

    public static synchronized GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        init();
    }

    private void init() {
        observers = new ArrayList<>();
        diceList = new ArrayList<>();
        draft = new Random();
        classicClan = new ClassicClan();
        visitor = new PlayerVisitor();

        naruto = new NarutoController(this);
    } 

    @Override
    public void gameStart(Player player1, Player player2) {
        createPlayers(player1, player2);
        createDiceList();
        initComponents();

        acme = new AcmeForObject("");
        tecFile = new TecFileForObject();
        
        try {
            if(getProp().equals("1")) {
                acme.savePlayer( playerText(), playerPoints(), playerCastles(), "acme.xml");
            }
            else {
                tecFile.savePlayer(playerText(), playerPoints(), playerCastles(), "tecFile.txt");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void attach(GameControllerObservers obs) {
        this.observers.add(obs);
    }

    @Override
    public void nextCardsBoard() {
        notifyNextCardsBoard();
    }

    @Override
    public void prevCardsBoard() {
        notifyPrevCardsBoard();
    }

    @Override
    public void setClaLabel(String claName) {
        notifyClaLabel(claName);
    }

    @Override
    public void rollingDice() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        List<ImageIcon> diceImg = new ArrayList<>();

        if (!player.getDice().isEmpty()) {
            player.getDice().clear();
        }
        for (int i = 0; i < diceChanges; i++) {
            Dice diceBasic = diceList.get(draft.nextInt(diceList.size()));
            player.pushDice(diceBasic);
            diceImg.add(player.getDice().get(i).getDado());
        }
        try {
            player.accept(visitor);
        } catch (Exception ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notifyRollingDice(diceImg);
    }

    @Override
    public void openCard(String clanName, int position) {

        switch (clanName) {
            case "chosokabe":
                cardCastle = chosokabeClan.getCastle(position);
                notifyOpenCard();
                break;
            case "mori":
                cardCastle = moriClan.getCastle(position);
                notifyOpenCard();
                break;
            case "shimazu":
                cardCastle = shimazuClan.getCastle(position);
                notifyOpenCard();
                break;
            case "tokugawa":
                cardCastle = tokugawaClan.getCastle(position);
                notifyOpenCard();
                break;
            case "uesugi":
                cardCastle = uesugiClan.getCastle(position);
                notifyOpenCard();
                break;
            case "oda":
                cardCastle = odaClan.getCastle(position);
                notifyOpenCard();
                break;
        }
    }

    @Override
    public ImageIcon getImageCastle(int position) {
        return cardCastle.getCastleFigureById(position);
    }

    @Override
    public void createPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        notifyPlayersCreated();
    }

    @Override
    public void playerName() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        String name = player.getName();
        notifyPlayerName(name);
    }

    @Override
    public void goGameFrame() {

    }

    @Override
    public void playerPoint() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        notifyPlayerPoint(player.getPoints());
    }

    private void notifyNextCardsBoard() {
        for (GameControllerObservers obs : observers) {
            obs.nextBoard();
        }
    }

    private void notifyPrevCardsBoard() {
        for (GameControllerObservers obs : observers) {
            obs.prevBoard();
        }
    }

    private void notifyClaLabel(String claName) {
        for (GameControllerObservers obs : observers) {
            obs.claLabel(claName);
        }
    }

    private void notifyRollingDice(List<ImageIcon> diceImg) {
        for (GameControllerObservers obs : observers) {
            obs.diceListImg(diceImg);
        }
    }

    private void notifyOpenCard() {
        for (GameControllerObservers obs : observers) {
            obs.openCardFrame();
        }
    }

    private void notifyPlayerName(String name) {
        for (GameControllerObservers obs : observers) {
            obs.getPlayerName(name);
        }
    }

    private void notifyPlayersCreated() {
        for (GameControllerObservers obs : observers) {
            obs.playersCreated();
        }
    }

    private void notifyPlayerPoint(int points) {
        for (GameControllerObservers obs : observers) {
            obs.playersPoint(points);
        }
    }

    private void createDiceList() {
        Dice dice = new Dice("image/dados/dado_artilharia.png");
        dice.addBattleLine("archery");
        diceList.add(dice);

        dice = new Dice("image/dados/dado_cavalaria.png");
        dice.addBattleLine("cavalry");
        diceList.add(dice);

        dice = new Dice("image/dados/dado_daimyo.png");
        dice.addBattleLine("daimyo");
        diceList.add(dice);

        dice = new Dice("image/dados/dado_infantaria_1.png");
        dice.addBattleLine("sword");
        diceList.add(dice);

        dice = new Dice("image/dados/dado_infantaria_2.png");
        dice.addBattleLine("sword");
        dice.addBattleLine("sword");
        diceList.add(dice);

        dice = new Dice("image/dados/dado_infantaria_3.png");
        dice.addBattleLine("sword");
        dice.addBattleLine("sword");
        dice.addBattleLine("sword");
        diceList.add(dice);
    }

    private void initComponents() {
        chosokabeClan = classicClan.createClan();
        BuilderClanChosokabe builderChosokabe = new BuilderClanChosokabe();
        Director director = new Director(builderChosokabe);
        director.construir();
        chosokabeClan = builderChosokabe.getClan();

        moriClan = classicClan.createClan();
        BuilderClanMori builderMori = new BuilderClanMori();
        director = new Director(builderMori);
        director.construir();
        moriClan = builderMori.getClan();

        shimazuClan = classicClan.createClan();
        BuilderClanShimazu builderShimazu = new BuilderClanShimazu();
        director = new Director(builderShimazu);
        director.construir();
        shimazuClan = builderShimazu.getClan();

        tokugawaClan = classicClan.createClan();
        BuilderClanTokugawa builderTokugawa = new BuilderClanTokugawa();
        director = new Director(builderTokugawa);
        director.construir();
        tokugawaClan = builderTokugawa.getClan();

        uesugiClan = classicClan.createClan();
        BuilderClanUesugi builderUesugi = new BuilderClanUesugi();
        director = new Director(builderUesugi);
        director.construir();
        uesugiClan = builderUesugi.getClan();

        odaClan = classicClan.createClan();
        BuilderClanOda builderOda = new BuilderClanOda();
        director = new Director(builderOda);
        director.construir();
        odaClan = builderOda.getClan();

        clanGlobalList.add(chosokabeClan);
        clanGlobalList.add(moriClan);
        clanGlobalList.add(shimazuClan);
        clanGlobalList.add(tokugawaClan);
        clanGlobalList.add(uesugiClan);
        clanGlobalList.add(odaClan);
    }

    @Override
    public List<ImageIcon> imageClanCastles(String clanName, int status) {
        List<ImageIcon> imageList = new ArrayList<>();
        switch (clanName) {
            case "chosokabe":
                for (Castle castle : chosokabeClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "mori":
                for (Castle castle : moriClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "shimazu":
                for (Castle castle : shimazuClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "tokugawa":
                for (Castle castle : tokugawaClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "uesugi":
                for (Castle castle : uesugiClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "oda":
                for (Castle castle : odaClan.getCastles()) {
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
        }

        return imageList;
    }

    public List<Clan> getClanGlobalList() {
        return clanGlobalList;
    }

    @Override
    public List<ImageIcon> playerDiceImg() {
        List<ImageIcon> imgList = new ArrayList<>();

        for (Dice dice : visitor.getDice()) {
            imgList.add(dice.getDado());
        }

        return imgList;
    }

    @Override
    public String playerText() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        return player.getName();
    }
    
    public int playerPoints() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        return player.getPoints();
    }
    
    public List<Castle> playerCastles() {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        return player.getConqueredCastle();
    }

    @Override
    public List<String> getCastleBL() {
        List<String> bl = new ArrayList<>();
        String test = "[";
        for(int i = 0; i < cardCastle.getBattleLine().size(); i++){
            for(int j = 0; j < cardCastle.getBattleLine().get(i).size();j++){
                test += cardCastle.getBattleLine().get(i).get(j)+",";
            }
            test += "]";
           bl.add(test);
           test = "[";
        }
        return bl;
    }
    
    public static String getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src\\game\\controller\\Adapter.properties");
        props.load(file);
        return props.getProperty("tipo");
    }
    
}