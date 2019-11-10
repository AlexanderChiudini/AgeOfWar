package game.view.cardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;
import game.view.CardCastleFrame;
import game.view.GameFrame;

@SuppressWarnings("serial")
public class CardMenuPanel extends JPanel{
    
    private GameControllerInterface gameController;
    private CardCastleFrame cardFrame;
    private GameFrame gameFrame;
    public static final int LINE = 1;
    public static final int COLS = 2;
    private JPanel imagePanel;
    private PlayCardPanel playCardPanel;
    private JLabel cardImg;
    
    public CardMenuPanel(GameControllerInterface gameController,CardCastleFrame cardFrame,GameFrame gameFrame){
        this.gameController = gameController;
        this.cardFrame = cardFrame;
        this.gameFrame = gameFrame;
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
        imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        
        playCardPanel = new PlayCardPanel(this.gameController,cardFrame,gameFrame);
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
    
}