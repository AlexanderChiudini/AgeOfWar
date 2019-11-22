package core.controller;

import java.util.ArrayList;
import java.util.List;
import core.model.Player;
import core.state.Aguardando;
import core.state.Jogando;
import game.controller.GameController;
import game.controller.GameControllerInterface;

public class MainController implements MainControllerInterface {

    private static MainController instance;
    private List<MainControllerObserver> observers;
    private Player player1;
    private Player player2;
    
    private GameControllerInterface gameController;

    public static MainControllerInterface getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    private MainController() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void setPlayer1(String name){
        player1 = new Player("Jogador 1", 0);
        player1.setState(new Jogando(player1));
        
        if(name != "" || !name.isEmpty()){
            this.player1.setName(name);
        }
    }
    
    @Override
    public void setPlayer2(String name){
        player2 = new Player("Jogador 2", 0);
        player2.setState(new Aguardando(player2));
        
        if(name != "" || !name.isEmpty()){
            this.player2.setName(name);
        }
        
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
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
        gameController = new GameController(player1, player2);
        gameController.gameStart();
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
