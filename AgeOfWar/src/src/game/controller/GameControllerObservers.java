/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.controller;

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
}
