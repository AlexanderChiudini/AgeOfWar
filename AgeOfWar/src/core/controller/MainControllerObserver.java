package core.controller;

import game.controller.GameControllerInterface;

public interface MainControllerObserver {
    
    void systemWillBeClosed();
    void showGameInfo();
    void developerInfo();
    void returnToMainMenu();
    void playerSelection();
    void playerInfo();
    void loadingGame(GameControllerInterface gameController);
}
