package game.view.gameBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class DiceBoardPanel extends JPanel {

    private GameControllerInterface gameController;
    private JPanel playDicePanel;
    private JPanel resultDicePanel;
    private JPanel labelPanel;
    private JButton playButton;
    private JLabel labelDice;

    public DiceBoardPanel(GameControllerInterface gameController) {
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
        createDicePanel();
    }

    private void defineProperties() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    private void initComponents() {
        playDicePanel = new JPanel();

        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(1235, 30));
        labelDice = new JLabel("Dados");

        playButton = new JButton();
        playButton.setText("Rolar Dados");
        playButton.setBackground(Color.red);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.rollingDice();
            }
        });

        resultDicePanel = new JPanel();
        resultDicePanel.setLayout(new GridLayout(1, 7));
        resultDicePanel.setPreferredSize(new Dimension(getX(), 85));
    }

    private void addComponents() {
        labelPanel.add(labelDice);
        playDicePanel.add(labelPanel);
        playDicePanel.add(playButton);
        add(playDicePanel);
        add(resultDicePanel);
    }

    private void createDicePanel() {
        for(int i = 0; i < ((GridLayout)resultDicePanel.getLayout()).getColumns(); i++){
            resultDicePanel.add(new DicePanel());
        }
        
    }

    public void drawDiceResult(List<ImageIcon> diceImg) {
        for(int i = 0; i < diceImg.size(); i++){
            ((DicePanel)resultDicePanel.getComponent(i)).updateIcon(diceImg.get(i));
        }
    }
}
