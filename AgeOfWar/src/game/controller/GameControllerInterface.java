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
public interface GameControllerInterface {
    
    void attach(GameControllerObservers obs);
    
    void gameStart();
    
    void nextCardsBoard();

    void prevCardsBoard();

    void setClaLabel(String claName);

    void rollingDice();
    
    List<ImageIcon> imageClanCastles(String name, int status);

    void openCard(String clanName, int position);

    ImageIcon getImageCastle(int i);
    
    void createPlayers();

    void playerName();

    List<ImageIcon> playerDiceImg();

    String playerText();

    void playerPoint();

    List<String> getCastleBL();

    void goGameFrame();

    void addPlayerChooseDice(int indice,boolean condition);

    void checkMatch(List<String> str, List<Integer> indices);
    
    void playerChange();

    int playerPoints();
    
    void playerPointsDivision();
    
    boolean theEnd();
    
    void thisIsTheEndOfTheGame();
    
    void victory();
}
