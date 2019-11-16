/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import java.util.List;
import javax.swing.ImageIcon;
import core.model.Player;

/**
 *
 * @author lucas
 */
public interface GameControllerInterface {
    
    void attach(GameControllerObservers obs);
    
    void gameStart(Player player1,Player player2);
    
    void nextCardsBoard();

    void prevCardsBoard();

    void setClaLabel(String claName);

    void rollingDice();
    
    List<ImageIcon> imageClanCastles(String name, int status);

    void openCard(String clanName, int position);

    ImageIcon getImageCastle(int i);
    
    void createPlayers(Player player1, Player player2);

    void playerName();

    List<ImageIcon> playerDiceImg();

    String playerText();

    void playerPoint();

    List<String> getCastleBL();

    void goGameFrame();

    void addPlayerChooseDice(int indice);

    void checkMatch(List<String> str, List<Integer> indices);
}
