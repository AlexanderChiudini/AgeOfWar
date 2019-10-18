package src.game.view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.game.view.CardCastleFrame;
import src.game.view.GameFrame;
import src.game.view.cardMenu.CardMenuPanel;

public class CardMenuInternalFrame extends JInternalFrame{
    
    private JPanel cardMenuPanel;
    
    public CardMenuInternalFrame(GameControllerInterface gameController, CardCastleFrame cardFrame, GameFrame gameFrame){
        cardMenuPanel = new CardMenuPanel(gameController,cardFrame,gameFrame);
        setContentPane(cardMenuPanel);
    }
}