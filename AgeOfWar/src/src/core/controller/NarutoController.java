package src.core.controller;

import scr.core.model.Dice;

public class NarutoController {
    
    private static NarutoController instance;

    public static synchronized NarutoController getInstance() {
        if (instance == null) {
            instance = new NarutoController();
        }
        return instance;
    }
    
    public void escolherJogada(Dice... dados) {
        
    }
    
}
