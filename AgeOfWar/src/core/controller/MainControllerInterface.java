package core.controller;

import core.model.Player;

public interface MainControllerInterface {

    void attach(MainControllerObserver observer);

    void detach(MainControllerObserver observer);
    
    void closeWindow();
    
    void gameInfo();
    
    void developers();

    void goToMainMenu();
    
    void changePlayers();

    void playersInformation();
    
    void setPlayer1(String name);
    
    void setPlayer2(String name);

    void gameStart();

    Player getPlayer1();
    
    Player getPlayer2();
}
