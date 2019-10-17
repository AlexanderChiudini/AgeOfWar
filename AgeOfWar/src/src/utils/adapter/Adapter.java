/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utils.adapter;

import java.util.List;
import scr.core.model.Castle;
import scr.core.model.Dice;

/**
 *
 * @author lucas
 */
public interface Adapter {
    
    void savePlayer(String file, String player, int points, List<String> castleConquered);
}
