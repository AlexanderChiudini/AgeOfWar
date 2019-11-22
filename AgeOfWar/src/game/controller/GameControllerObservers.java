/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import java.util.List;
import javax.swing.ImageIcon;
/**
 *
 * @author lucas
 */
public interface GameControllerObservers {
    
    void nextBoard();

    void prevBoard();
    
    void currentBoard();

    void claLabel(String claName);

    void diceListImg(List<ImageIcon> diceImg);

    void openCardFrame();
    
    void getPlayerName(String name);

    void playersCreated();

    void playersPoint(int points);

    void clearDiceList();

    void warningAlert(String message, String title);
    
    void informationAlert(String message, String title);

    void updateCardMenu();

    void playerChangeModify(String playerName,int point);

    void theEndOfTheGame(String message, String title);

    void closeWindow();

    void clanConquered(String clan, ImageIcon img);

    void cardConquered(String clan, int castleNmuber, ImageIcon img);
}
