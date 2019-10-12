package src.game.view.gameBoard;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class DiceBoardPanel extends JPanel{
    
    private JPanel playDicePanel;
    private JPanel resultDicePanel;
    private JPanel labelPanel;
    private JButton playButton;
    private JLabel labelDice;
    
    public DiceBoardPanel(GameControllerInterface gameController){
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }

    private void initComponents() {
        playDicePanel = new JPanel();
        
        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(1235, 30));
        labelDice = new JLabel("Dados");
        
        playButton = new JButton();
        playButton.setText("Rolar Dados");
        playButton.setBackground(Color.red);
        
//        resultDicePanel = new JPanel();
//        resultDicePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void addComponents() {
        labelPanel.add(labelDice);
        playDicePanel.add(labelPanel);
        playDicePanel.add(playButton);
        add(playDicePanel);
    }
}