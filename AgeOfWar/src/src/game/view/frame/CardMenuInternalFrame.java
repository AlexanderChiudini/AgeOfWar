package src.game.view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.game.view.cardMenu.CardMenuPanel;

public class CardMenuInternalFrame extends JInternalFrame{
    
    private JPanel cardMenuPanel;
    
    public CardMenuInternalFrame(GameControllerInterface gameController){
        cardMenuPanel = new CardMenuPanel(gameController);
        setContentPane(cardMenuPanel);
    }
}