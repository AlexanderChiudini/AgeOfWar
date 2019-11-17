package game.view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;
import game.view.CardCastleFrame;
import game.view.GameFrame;
import game.view.cardMenu.CardMenuPanel;

public class CardMenuInternalFrame extends JInternalFrame{
    
    private JPanel cardMenuPanel;
    
    public CardMenuInternalFrame(GameControllerInterface gameController, CardCastleFrame cardFrame, GameFrame gameFrame){
        cardMenuPanel = new CardMenuPanel(gameController,cardFrame,gameFrame);
        setContentPane(cardMenuPanel);
    }

    public void updateMenu() {
        cardMenuPanel.updateUI();
    }
}