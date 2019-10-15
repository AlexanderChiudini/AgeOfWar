package src.game.view.gameBoard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

@SuppressWarnings("serial")
public class CardPanel extends JPanel{
    
    private String clanName;
//    private int number;
    private GameControllerInterface gameController;
    private ImageIcon cardImg;
    private JButton castleCard;
    
    public CardPanel(ImageIcon imagePath,String clanName,GameControllerInterface gameController) {
        this.cardImg = imagePath;
        this.gameController = gameController;
        this.clanName = clanName;
//        this.number = number;
        init();
    }

    private void init() {
        initComponents();
        addComponents();
    }

    private void initComponents() {
        castleCard = new JButton();
        castleCard.setIcon(cardImg);
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