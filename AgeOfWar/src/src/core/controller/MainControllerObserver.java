package src.core.controller;

public interface MainControllerObserver {
    
    void systemWillBeClosed();
    void showGameInfo();
    void developerInfo();
    void returnToMainMenu();
}
