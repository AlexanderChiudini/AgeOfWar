package src.game.view.gameBoard;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.utils.BackgroundPanel;

@SuppressWarnings("serial")
public class CardsBoardPanel extends BackgroundPanel {

    private String claName;
    private final int LINE = 1;
    private final int COLS = 4;
    private GameControllerInterface gameController;
    List<ImageIcon> cardPanelList;
//    private CardPanel castleCard;
    
    
    public CardsBoardPanel(String imagePath, String name, GameControllerInterface gameController) {
        super(imagePath);
        this.claName = name;
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new GridLayout(LINE, COLS));
    }

    public String getClaName(){
        return claName;
    }

    private void initComponents() {
        cardPanelList = gameController.imageClanCastles(claName, 0);
    }

    private void addComponents() {
        for(ImageIcon img : cardPanelList){
            add(new CardPanel(img, claName, gameController));
        }
    }
}
