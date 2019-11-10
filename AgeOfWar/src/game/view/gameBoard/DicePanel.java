package game.view.gameBoard;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel{
    
    private JLabel diceLabel;
    private ImageIcon diceIcon;
    
    public DicePanel(){
        init();
    }
    
    public void init(){
        initComponents();
        addComponents();
    }

    private void initComponents() {
        diceLabel = new JLabel("Jogar");
        diceLabel.setBackground(Color.LIGHT_GRAY);
        diceLabel.setPreferredSize(new Dimension(75,75));
    }

    private void addComponents() {
        add(diceLabel);
    }
    
    public void updateIcon(ImageIcon dc) {
        setDiceIcon(dc);
        diceLabel.setIcon(diceIcon);
    }
    
    private void setDiceIcon(ImageIcon dc){
        this.diceIcon = dc;
    }
}