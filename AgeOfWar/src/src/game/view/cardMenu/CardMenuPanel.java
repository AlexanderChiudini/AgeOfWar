package src.game.view.cardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.game.controller.GameControllerObservers;
import src.utils.BackgroundPanel;

@SuppressWarnings("serial")
public class CardMenuPanel extends JPanel{
    
    private GameControllerInterface gameController;
    public static final int LINE = 1;
    public static final int COLS = 2;
    private JPanel imagePanel;
    private PlayCardPanel playCardPanel;
    private JLabel cardImg;
    
    public CardMenuPanel(GameControllerInterface gameController){
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new GridLayout(LINE,COLS));
        setBackground(Color.CYAN);
    }

    private void initComponents() {
//        imagePanel = new BackgroundPanel(gameController.getImageCastle(0));
//        imagePanel.setPreferredSize(new Dimension(261, 261));
        imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        
        playCardPanel = new PlayCardPanel(this.gameController);
        playCardPanel.setOpaque(false);
        
        cardImg = new JLabel();
        cardImg.setIcon(gameController.getImageCastle(0));
        cardImg.setPreferredSize(new Dimension(261, 261));
    }

    private void addComponents() {
        imagePanel.add(cardImg);
                
        add(imagePanel);
        add(playCardPanel);
    }
    
//    public void diceListImg(List<ImageIcon> diceImg) {
//        playCardPanel.drawDiceResult(diceImg);
//    }
}