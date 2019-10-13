/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.controller;

/**
 *
 * @author lucas
 */
public interface GameControllerInterface {
    
    void attach(GameControllerObservers obs);
    
    void gameStart(String player1,String player2);
    
    void nextCardsBoard();

    void prevCardsBoard();

    void setClaLabel(String claName);

    void rollingDice();
    
}
