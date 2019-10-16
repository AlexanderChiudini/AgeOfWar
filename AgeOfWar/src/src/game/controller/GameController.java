package src.game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import scr.core.builder.BuilderClanChosokabe;
import scr.core.builder.BuilderClanMori;
import scr.core.builder.BuilderClanOda;
import scr.core.builder.BuilderClanShimazu;
import scr.core.builder.BuilderClanTokugawa;
import scr.core.builder.BuilderClanUesugi;
import scr.core.builder.Director;
import scr.core.factory.ClassicClan;
import scr.core.model.Castle;
import scr.core.model.Clan;
import scr.core.model.Dice;
import src.core.controller.NarutoController;

public class GameController implements GameControllerInterface {

    private List<GameControllerObservers> observers;
    private List<Dice> diceList;
    private List<Dice> rollingDiceList;
    private List<Clan> clanGlobalList = new ArrayList<>();
    private Random draft;
    private int diceChanges = 7;

    private Clan chosokabeClan;
    private Clan moriClan;
    private Clan shimazuClan;
    private Clan tokugawaClan;
    private Clan uesugiClan;
    private Clan odaClan;
    private ClassicClan classicClan;

    private NarutoController naruto;

    private static GameController instance;
    
    public static synchronized GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    
    public GameController() {
        init();
    }

    private void init() {
        observers = new ArrayList<>();
        diceList = new ArrayList<>();
        rollingDiceList = new ArrayList<>();
        draft = new Random();

        classicClan = ClassicClan.getInstance();

        naruto = new NarutoController(instance);

    }

    @Override
    public void gameStart(String player1, String player2) {
        createDiceList();
        initComponents();
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
        List<ImageIcon> diceImg = new ArrayList<>();
        if (!rollingDiceList.isEmpty()) {
            rollingDiceList.clear();
        }

        for (int i = 0; i < diceChanges; i++) {
            Dice diceBasic = diceList.get(draft.nextInt(diceList.size()));
            rollingDiceList.add(diceBasic);
            diceImg.add(rollingDiceList.get(i).getDado());
        }
        notifyRollingDice(diceImg);
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
    public List<ImageIcon> imageClanCastles(String clanName,int status){
        List<ImageIcon> imageList = new ArrayList<>();
        switch(clanName){
            case "chosokabe":
                for(Castle castle : chosokabeClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "mori":
                for(Castle castle : moriClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "shimazu":
                for(Castle castle : shimazuClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "tokugawa":
                for(Castle castle : tokugawaClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "uesugi":
                for(Castle castle : uesugiClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
            case "oda":
                for(Castle castle : odaClan.getCastles()){
                    imageList.add(castle.getCastleFigureById(status));
                }
                break;
        }
        
        return imageList;
    }

    public List<Clan> getClanGlobalList() {
        return clanGlobalList;
    }
}
