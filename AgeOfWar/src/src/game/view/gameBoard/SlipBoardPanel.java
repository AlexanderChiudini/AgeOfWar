package src.game.view.gameBoard;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class SlipBoardPanel extends JPanel{
    
    private GameControllerInterface gameController;
    private final int P_HEIGHT = 60;
    private final int L_WIDTH = 1135;
    private final int B_WIDTH = 100;
    private final float L_SIZE = 25.0f;
    private JPanel labelPanel;
    private JLabel centerLabel;
    private String labelTxt = "Clã Exemplo";
    private JButton leftButton;
    private JButton rightButton;
    
    public SlipBoardPanel(GameControllerInterface gameController){
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(getX(), P_HEIGHT));
    }

    private void initComponents() {
        leftButton = new JButton();
        leftButton.setText("<");
        leftButton.setPreferredSize(new Dimension(B_WIDTH, P_HEIGHT -10));
        leftButton.setFont(leftButton.getFont().deriveFont(L_SIZE));
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.prevCardsBoard();
            }
        });
        
        rightButton = new JButton();
        rightButton.setText(">");
        rightButton.setPreferredSize(new Dimension(B_WIDTH, P_HEIGHT - 10));
        rightButton.setFont(rightButton.getFont().deriveFont(L_SIZE));
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.nextCardsBoard();
            }
        });
        
        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(L_WIDTH, P_HEIGHT - 10));
        centerLabel = new JLabel(labelTxt);
        centerLabel.setFont(centerLabel.getFont().deriveFont(L_SIZE));
    }

    private void addComponents() {
        add(leftButton);
        labelPanel.add(centerLabel);
        add(labelPanel);
        add(rightButton);
    }
    
    public void setClaLabel(String str){
        this.labelTxt = str;
        centerLabel.setText(labelTxt);
    }
}