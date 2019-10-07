package src.core.controller;

import src.game.controller.GameControllerInterface;

public interface MainControllerObserver {
    
    void systemWillBeClosed();
    void showGameInfo();
    void developerInfo();
    void returnToMainMenu();
    void playerSelection();
    void playerInfo();
    void loadingGame(GameControllerInterface gameController);
}
