package src.core.controller;

import java.util.ArrayList;
import java.util.List;
import src.game.controller.GameController;
import src.game.controller.GameControllerInterface;

public class MainController implements MainControllerInterface {

    private static MainController instance;
    private List<MainControllerObserver> observers;
    private String player1;
    private String player2;

    public static MainControllerInterface getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    private MainController() {
        observers = new ArrayList<>();
    }
    
    public void setPlayer1(String name){
        if(name == "" || name.isEmpty()){
            name = "Jogador 1";
        }
        
        this.player1 = name;
    }
    
    public void setPlayer2(String name){
        if(name == "" || name.isEmpty()){
            name = "Jogador 2";
        }
        
        this.player2 = name;
    }

    @Override
    public void attach(MainControllerObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(MainControllerObserver observer) {
        this.observers.remove(observer);
    }
    
    @Override
    public void closeWindow(){
        notifyCloseWindow();
        System.exit(0);
    }

    @Override
    public void gameInfo() {
        notifyGameInfo();
    }
    
    @Override
    public void goToMainMenu() {
        notifyReturnMainMenu();
    }
    
    @Override
    public void developers() {
        notifyDeveloperInfo();
    }
    
    @Override
    public void changePlayers() {
        notifyPlayerSelection();
    }
    
    @Override
    public void playersInformation() {
        notifyNeedPlayersInfo();
    }
    
    @Override
    public void gameStart() {
        GameControllerInterface gameController = new GameController();
        gameController.gameStart(player1, player2);
        notifyLoadingGame(gameController);
    }
    
    private void notifyCloseWindow() {
        for(MainControllerObserver obs : this.observers){
            obs.systemWillBeClosed();
        }
    }

    private void notifyGameInfo() {
        for(MainControllerObserver obs : this.observers){
            obs.showGameInfo();
        }
    }


    private void notifyDeveloperInfo(){
        for(MainControllerObserver obs : this.observers){
            obs.developerInfo();
        }
    }
    
    private void notifyReturnMainMenu(){
        for(MainControllerObserver obs : this.observers){
            obs.returnToMainMenu();
        }
    }
    
    private void notifyPlayerSelection(){
        for(MainControllerObserver obs : this.observers){
            obs.playerSelection();
        }
    }

    private void notifyNeedPlayersInfo() {
        for(MainControllerObserver obs : this.observers){
            obs.playerInfo();
        }
    }

    private void notifyLoadingGame(GameControllerInterface gameController) {
        for(MainControllerObserver obs : this.observers){
            obs.loadingGame(gameController);
        }
    }

}
