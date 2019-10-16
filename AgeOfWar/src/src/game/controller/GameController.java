package src.game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import scr.core.model.Clan;
import scr.core.model.Dice;
import src.core.controller.NarutoController;

public class GameController implements GameControllerInterface {

    private List<GameControllerObservers> observers;
    private List<Dice> diceList;
    private List<Dice> rollingDiceList;
    private Random draft;
    private int diceChanges = 7;
    private List<Clan> clanGlobalList = new ArrayList<>();
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
        naruto = new NarutoController(instance);
    }

    @Override
    public void gameStart(String player1, String player2) {
        createDiceList();
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

    public List<Clan> getClanGlobalList() {
        return clanGlobalList;
    }
}
