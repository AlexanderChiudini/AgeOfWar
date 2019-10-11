package src.game.view.gameBoard;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.utils.BackgroundPanel;

@SuppressWarnings("serial")
public class CardsBoardPanel extends BackgroundPanel {

    private String claName;
    private final int LINE = 2;
    private final int COLS = 2;
    private GameControllerInterface gameController;
    
    
    public CardsBoardPanel(String imagePath, String name, GameControllerInterface gameController) {
        super(imagePath);
        this.claName = name;
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
    }

    private void defineProperties() {
        setLayout(new GridLayout(LINE, COLS));
    }
    
    public String getClaName(){
        System.out.println(claName);
        return claName;
    }
}
