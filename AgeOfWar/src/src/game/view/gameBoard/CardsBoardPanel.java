package src.game.view.gameBoard;

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
    private JPanel cardsBoardArea;
    private GameControllerInterface gameController;
    List<ImageIcon> cardPanelList = new ArrayList<>();

    public CardsBoardPanel(String imagePath, String name, GameControllerInterface gameController) {
        super(imagePath);
        this.claName = name;
        this.gameController = gameController;
        init();
    }

    private void init() {
        initComponents();
        addComponents();
    }

    public String getClaName() {
        return claName;
    }

    private void initComponents() {
        cardPanelList = gameController.imageClanCastles(claName, 0);

        cardsBoardArea = new JPanel();
        cardsBoardArea.setLayout(new GridLayout(LINE, COLS));
    }

    private void addComponents() {
        for(int i = 0; i < cardPanelList.size();i++){
            cardsBoardArea.add(new CardPanel(cardPanelList.get(i),claName,i,gameController));
        }
        add(cardsBoardArea);
    }
}
