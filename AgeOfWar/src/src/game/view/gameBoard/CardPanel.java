package src.game.view.gameBoard;

import javax.swing.JButton;
import javax.swing.JLabel;
import src.utils.BackgroundPanel;

public class CardPanel extends BackgroundPanel{
    
    public JButton label = new JButton();
    
    public CardPanel(String imagePath) {
        super(imagePath);
        init();
    }

    private void init() {
        initComponents();
    }

    private void initComponents() {
        
    }
    
}