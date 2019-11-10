package game.view.gameBoard;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerBoardPanel extends JPanel{
    
    private JLabel playerLabel;
    private JLabel pointLabel;
    
    public PlayerBoardPanel(){
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new GridLayout(1,2));
        setPreferredSize(new Dimension(getX(), 80));
    }

    private void initComponents() {
        playerLabel = new JLabel("Teste");
        pointLabel = new JLabel("Ponto(s) : 0");
    }

    private void addComponents() {
        add(playerLabel);
        add(pointLabel);
    }
    
    public void setPlayerName(String name){
        playerLabel.setText(name);
    }

    void setPlayerPoint(int points) {
        pointLabel.setText("Ponto(s) : "+points+"");
    }
}