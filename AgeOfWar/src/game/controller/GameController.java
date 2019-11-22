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

import core.visitor.ClanVisitor;
import utils.adapter.AcmeForObject;
import utils.adapter.Adapter;
import utils.adapter.TecFileForObject;

import core.state.Aguardando;
import core.state.Derrota;
import core.state.Jogando;
import core.state.Vitoria;

public class GameController implements GameControllerInterface {

    private List<GameControllerObservers> observers;
    private List<Dice> diceList;
    private List<Clan> clanGlobalList = new ArrayList<>();
    private List<Castle> castleGlobalList = new ArrayList<>();
    private Random draft;
    private int diceChanges = 7;
    private boolean subtract = false;

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

    public GameController(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        init();
    }

    private void init() {
        observers = new ArrayList<>();
        diceList = new ArrayList<>();
        draft = new Random();
        classicClan = new ClassicClan();

        naruto = new NarutoController(this);
    }

    @Override
    public void gameStart() {
        createPlayers();
        createDiceList();
        initComponents();

        acme = new AcmeForObject("");
        tecFile = new TecFileForObject();

        try {
            if (getProp().equals("1")) {
                acme.savePlayer(playerText(), playerPoints(), playerCastles(), "acme.xml");
            } else {
                tecFile.savePlayer(playerText(), playerPoints(), playerCastles(), "tecFile.txt");
            }
        } catch (IOException ex) {
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
        if (this.subtract) {
            notifyClearDices();
            diceChanges--;
        }
        if (diceChanges == 0) {
            Player player = (player1.getState().toString() == "Aguardando") ? player1 : player2;
            playerChange();
            notifyPlayerChange(player.getName(), player.getPoints());
            this.diceChanges = 7;
            this.subtract = false;
        } else {

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

            this.subtract = true;
            notifyRollingDice(diceImg);
        }
    }

    @Override
    public void openCard(String clanName, int position) {
        Player player = ("Jogando".equals(player1.getState().toString())) ? player1 : player2;

        switch (clanName) {
            case "chosokabe":
                cardCastle = player.getPlayerClan().get(0).getCastle(position);
                notifyOpenCard();
                break;
            case "mori":
                cardCastle = player.getPlayerClan().get(1).getCastle(position);
                notifyOpenCard();
                break;
            case "shimazu":
                cardCastle = player.getPlayerClan().get(2).getCastle(position);
                notifyOpenCard();
                break;
            case "tokugawa":
                cardCastle = player.getPlayerClan().get(3).getCastle(position);
                notifyOpenCard();
                break;
            case "uesugi":
                cardCastle = player.getPlayerClan().get(4).getCastle(position);
                notifyOpenCard();
                break;
            case "oda":
                cardCastle = player.getPlayerClan().get(5).getCastle(position);
                notifyOpenCard();
                break;
        }
    }

    @Override
    public ImageIcon getImageCastle(int position) {
        return cardCastle.getCastleFigureById(position);
    }

    @Override
    public void createPlayers() {
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

    private void notifyUpdateCardMenu() {
        for (GameControllerObservers obs : observers) {
            obs.updateCardMenu();
        }
    }

    private void notifyClearDices() {
        for (GameControllerObservers obs : observers) {
            obs.clearDiceList();
        }
    }

    private void notifyWarningAlert(String message, String title) {
        for (GameControllerObservers obs : observers) {
            obs.warningAlert(message, title);
        }
    }

    private void notifyPlayerChange(String playerName, int point) {
        for (GameControllerObservers obs : observers) {
            obs.playerChangeModify(playerName, point);
        }
    }

    private void notifyTheEndOfTheGame(String message, String title) {
        for (GameControllerObservers obs : observers) {
            obs.warningAlert(message, title);
        }
    }

    private void notifyCloseWindow() {
        for (GameControllerObservers obs : observers) {
            obs.closeWindow();
        }
    }

    private void notifyInformationAlert(String message, String title) {
        for (GameControllerObservers obs : observers) {
            obs.informationAlert(message, title);
        }
    }

    private void notifyCardImg(String clan, int castleNmuber, ImageIcon img) {
        for (GameControllerObservers obs : observers) {
            obs.cardConquered(clan, castleNmuber, img);
        }
    }

    private void notifyCardsListImg(String clan, ImageIcon img) {
        for (GameControllerObservers obs : observers) {
            obs.clanConquered(clan, img);
        }
    }

    private void notifyPlayersScore(String message, String title) {
        for (GameControllerObservers obs : observers) {
            obs.informationAlert(message, title);
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
        player1.setPlayerClan(initClanList());
        player2.setPlayerClan(initClanList());
    }

    private List<Clan> initClanList() {
        List<Clan> list = new ArrayList<>();

        try {
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

            list.add(chosokabeClan);
            list.add(moriClan);
            list.add(shimazuClan);
            list.add(tokugawaClan);
            list.add(uesugiClan);
            list.add(odaClan);
        } catch (Exception ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

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
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;
        for (Dice dice : player.getDice()) {
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
        if (cardCastle.getBattleLine().isEmpty()) {
            bl = null;
        } else {
            for (int i = 0; i < cardCastle.getBattleLine().size(); i++) {
                for (int j = 0; j < cardCastle.getBattleLine().get(i).size(); j++) {
                    test += cardCastle.getBattleLine().get(i).get(j) + ",";
                }
                test += "]";
                bl.add(test);
                test = "[";
            }
        }
        return bl;
    }

    @Override
    public void addPlayerChooseDice(int indice, boolean btnCondition) {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;

        Dice aux = player.getDice().get(indice);
        if (btnCondition) {
            player.addChooseDice(aux);
        } else {
            player.removeChooseDice(aux);
        }
    }

    @Override
    public void checkMatch(List<String> str, List<Integer> indices) {
        Player player = (player1.getState().toString() == "Jogando") ? player1 : player2;

        int daimyo = 0;
        int archery = 0;
        int sword = 0;
        int cavalry = 0;
        for (String s : str) {
            String[] array = s.split(",");
            for (String st : array) {
                if (st.contains("daimyo")) {
                    daimyo++;
                }
                if (st.contains("archery")) {
                    archery++;
                }
                if (st.contains("sword")) {
                    sword++;
                }
                if (st.contains("cavalry")) {
                    cavalry++;
                }
            }
        }

        int daimyo2 = 0;
        int archery2 = 0;
        int sword2 = 0;
        int cavalry2 = 0;
        for (Dice d : player.getChooseDice()) {
            System.out.println(d.getBattleLine().toString());
            for (String s : d.getBattleLine()) {
                if (s.contains("daimyo")) {
                    daimyo2++;
                }
                if (s.contains("archery")) {
                    archery2++;
                }
                if (s.contains("sword")) {
                    sword2++;
                }
                if (s.contains("cavalry")) {
                    cavalry2++;
                }
            }
        }

        System.out.println(
                "daimyo: " + daimyo + "\n"
                + "archery: " + archery + "\n"
                + "sword: " + sword + "\n"
                + "cavalry: " + cavalry + "\n"
        );

        System.out.println(
                "daimyo2: " + daimyo2 + "\n"
                + "archery2: " + archery2 + "\n"
                + "sword2: " + sword2 + "\n"
                + "cavalry2: " + cavalry2 + "\n"
        );

        if (daimyo <= daimyo2 && archery <= archery2 && sword <= sword2 && cavalry <= cavalry2) {
            makeItHappen(player, indices);
            this.subtract = false;
        } else {
            notifyWarningAlert("N\u00E3o foi possivel dominar as linhas de batalhas com os dados selecionados", "Falha em conquistar linhas de batalhas");
        }
    }

    public static String getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src\\game\\controller\\Adapter.properties");
        props.load(file);
        return props.getProperty("tipo");
    }

    private void makeItHappen(Player player, List<Integer> indices) {
        for (int i : indices) {
            cardCastle.addConqueredLines(i);
        }

        if (!player.getConqueredCastle().contains(cardCastle)) {
            player.getConqueredCastle().add(cardCastle);
        } else {
            for (int i = 0; i < player.getConqueredCastle().size(); i++) {
                if (player.getConqueredCastle().get(i).getCastleName().equals(cardCastle.getCastleName())) {
                    player.getConqueredCastle().set(i, cardCastle);
                }
            }
        }

        for (Castle c : player.getConqueredCastle()) {
            System.out.print(c.getCastleName() + " ");
        }

        try {
            player.jogar();
        } catch (Exception ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Clan ourClan = player.getClanWithCastle(cardCastle);

        if (cardCastle.isConquered()) {
            if (castleGlobalList.isEmpty()) {
                castleGlobalList.add(cardCastle);
                notifyCardImg(ourClan.getClanName(), ourClan.getCastleNumber(cardCastle.getCastleName()), cardCastle.getCastleFigures().get(1));
            } else {
                boolean b = false;
                for (Castle castle : castleGlobalList) {
                    if (castle.getCastleName().equals(cardCastle.getCastleName())) {
                        b = true;
                    }
                }
                if (b == false) {
                    castleGlobalList.add(cardCastle);
                    notifyCardImg(ourClan.getClanName(), ourClan.getCastleNumber(cardCastle.getCastleName()), cardCastle.getCastleFigures().get(1));
                }
            }
        }

        ClanVisitor visitor = new ClanVisitor();
        try {
            ourClan.accept(visitor);
        } catch (Exception ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ourClan.setIsConquered(visitor.isClanConquistado());
        if (ourClan.isIsConquered()) {
            conqueredClan(ourClan);
        } else {
            if (cardCastle.isConquered()) {
                playerPointsDivision();
            }
        }

        if (!theEnd()) {
            List<ImageIcon> diceImg = new ArrayList<>();

            for (int i = 0; i < player.getDice().size(); i++) {
                diceImg.add(player.getDice().get(i).getDado());
            }

//        this.subtract = false;
            this.diceChanges = player.getDice().size();
            notifyClearDices();
            notifyRollingDice(diceImg);
            notifyPlayerPoint(player.getPoints());
            if (ourClan.isIsConquered()) {
                if (ourClan.getClanName() != "Shimazu") {
                    notifyCardsListImg(ourClan.getClanName(), cardCastle.getCastleFigures().get(2));
                } else {
                    notifyCardsListImg(ourClan.getClanName(), cardCastle.getCastleFigures().get(1));
                }
            }
            notifyUpdateCardMenu();
        } else {
            thisIsTheEndOfTheGame();
        }
    }

    @Override
    public void playerChange() {
        if (player1.getState().toString() == "Jogando") {
            player1.setState(new Aguardando(player1));
        } else {
            player1.setState(new Jogando(player1));
        }

        if (player2.getState().toString() == "Jogando") {
            player2.setState(new Aguardando(player2));
        } else {
            player2.setState(new Jogando(player2));
        }
    }

    @Override
    public void playerPointsDivision() {
//        verifica quem dominou o castelo por ultimo
//        entrega o castelo para o jogador que dominou por ultimo
//        entrega os pontos para o jogador que dominou por ultimo
        Player player = (player1.getState().toString() == "Aguardando") ? player1 : player2;
        Castle castle = player.getCastle(cardCastle.getCastleName());
        if (castle != null) {
            if (castle.isConquered()) {
                player.setPoints(player.getPoints() - castle.getPoints());
                player.getCastle(castle.getCastleName()).setIsConquered(false);
                player.getCastle(castle.getCastleName()).remakeBattleLines();
            }
                player.removeConqueredCastle(castle);
        }
    }

    @Override
    public void thisIsTheEndOfTheGame() {
//        verifica em clanGlobalList se todos os castelos estao dominados
//        caso todos os castelos (14 castelos) estajam dominados, o jogo termina
//        nao importa quem esteja com o(s) castelos
        notifyTheEndOfTheGame("O jogo acabou!!!\nTodos os castelos foram dominados.", "Acabou o jogo");
        victory();
        playersScore();
        notifyCloseWindow();

    }

    @Override
    public void victory() {
        if (player1.getPoints() > player2.getPoints()) {
            player1.setState(new Vitoria(player1));
            player2.setState(new Derrota(player1));
            notifyInformationAlert("Parab\u00E9ns " + player1.getName() + " voc\u00EA ganhou!!!", player1.getName() + " venceu!!!");
        }
        if (player1.getPoints() < player2.getPoints()) {
            player2.setState(new Vitoria(player1));
            player1.setState(new Derrota(player1));
            notifyInformationAlert("Parab\u00E9ns " + player2.getName() + " voc\u00EA ganhou!!!", player2.getName() + " venceu!!!");
        }
        if (player1.getPoints() == player2.getPoints()) {
            notifyInformationAlert("Houve um empate", "Empate");
        }
    }

    @Override
    public boolean theEnd() {
        if (castleGlobalList.size() == 14) {
            return true;
        } else {
            return false;
        }
    }

    private void conqueredClan(Clan winnerClan) {
        Player winner = (player1.getState().toString() == "Jogando") ? player1 : player2;
        Player loser = (player1.getState().toString() == "Aguardando") ? player1 : player2;

        int points = winner.getPoints() - winnerClan.getPoints() + winnerClan.getPointsIsConquered();
        winner.setPoints(points);

        Clan loserClan = loser.getClanWithName(winnerClan.getClanName());
        for (Castle castle : loserClan.getCastles()) {
            if (loser.getConqueredCastle().contains(castle)) {
                loser.getConqueredCastle().remove(castle);
            }
        }
        loser.setPoints(loser.getPoints() - loserClan.getPoints());
    }

    private void playersScore() {
        int castleConquist = 0;
        for (Castle castle : player1.getConqueredCastle()) {
            if (castle.isConquered()) {
                castleConquist++;
            }
        }
        int clanConquist = 0;
        for (Clan clan : player1.getPlayerClan()) {
            if (clan.isIsConquered()) {
                clanConquist++;
            }
        }

        String message = "Dados de cada jogador:\n\n"
                + "Jogador : " + player1.getName() + "\n"
                + "Castelos dominados : " + castleConquist + "\n"
                + "Castelo                          Pontos\n";
        if (castleConquist > 0) {
            for (Castle castle : player1.getConqueredCastle()) {
                if (castle.isConquered()) {
                    message += castle.getCastleName() + " :          " + castle.getPoints() + "\n";
                }
            }
        }
        message += "\nClans dominados : " + clanConquist + "\n";
        if (castleConquist > 0) {
            for (Clan clan : player1.getPlayerClan()) {
                if (clan.isIsConquered()) {
                    message += clan.getClanName() + " :              " + clan.getClanPoints() + "\n";
                }
            }
        }
        message += "\nTotal de Pontos :               " + player1.getPoints() + "\n";
        message += "\n------------------------------------------------------------------------------------------------\n\n";

        castleConquist = 0;
        for (Castle castle : player2.getConqueredCastle()) {
            if (castle.isConquered()) {
                castleConquist++;
            }
        }
        clanConquist = 0;
        for (Clan clan : player2.getPlayerClan()) {
            if (clan.isIsConquered()) {
                clanConquist++;
            }
        }

        message += "Jogador : " + player2.getName() + "\n"
                + "Castelos dominados : " + castleConquist + "\n"
                + "Castelo                          Pontos\n";
        if (castleConquist > 0) {
            for (Castle castle : player2.getConqueredCastle()) {
                if (castle.isConquered()) {
                    message += castle.getCastleName() + " :          " + castle.getPoints() + "\n";
                }
            }
        }
        message += "\nClans dominados : " + clanConquist + "\n";
        if (castleConquist > 0) {
            for (Clan clan : player2.getPlayerClan()) {
                if (clan.isIsConquered()) {
                    message += clan.getClanName() + " :              " + clan.getClanPoints() + "\n";
                }
            }
        }
        message += "\nTotal de Pontos :               " + player2.getPoints() + "\n";

        notifyPlayersScore(message, "Score da Partida:");
    }

}
