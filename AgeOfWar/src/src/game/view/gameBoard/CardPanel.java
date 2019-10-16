package src.game.view.gameBoard;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class CardPanel extends JPanel {

    private String clanName;
//    private int number;
    private GameControllerInterface gameController;
    private ImageIcon cardImg;
    private JButton castleCard;

//    public CardPanel() {
//        castleCard = new JButton();
//        add(castleCard);
//    }

    public CardPanel(ImageIcon imagePath, String clanName, GameControllerInterface gameController) {
        this.cardImg = imagePath;
        this.gameController = gameController;
        this.clanName = clanName;
//        this.number = number;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
    }

    private void initComponents() {
        castleCard = new JButton();
        castleCard.setIcon(cardImg);
//        castleCard.setPreferredSize(new Dimension(266, 266));
    }

    public ImageIcon getCardImg() {
        return cardImg;
    }

    public void setCardImg(ImageIcon cardImg) {
        this.cardImg = cardImg;
        castleCard.setIcon(cardImg);
    }

    private void addComponents() {
        add(castleCard);
    }

}
