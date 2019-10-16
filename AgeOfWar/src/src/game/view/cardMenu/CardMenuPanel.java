package src.game.view.cardMenu;

import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class CardMenuPanel extends JPanel{
    
    private GameControllerInterface gameController;
    public static final int LINE = 1;
    public static final int COLS = 2;
    
    public CardMenuPanel(GameControllerInterface gameController){
        this.gameController = gameController;
    }
}