package src.game.controller;

import java.util.ArrayList;
import java.util.List;

public class GameController implements GameControllerInterface{

    private List<GameControllerObservers> observers;
    
    public GameController(){
        init();
    }
    
    private void init() {
        observers = new ArrayList<>();
    }

    @Override
    public void gameStart(String player1, String player2) {
        
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


    private void notifyNextCardsBoard() {
        for(GameControllerObservers obs : observers){
            obs.nextBoard();
        }
    }

    private void notifyPrevCardsBoard() {
        for(GameControllerObservers obs : observers){
            obs.prevBoard();
        }
    }

    private void notifyClaLabel(String claName) {
        for(GameControllerObservers obs : observers){
            obs.claLabel(claName);
        }
    }
}