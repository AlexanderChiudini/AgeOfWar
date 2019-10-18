package src.game.view.cardMenu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import src.game.controller.GameControllerInterface;

public class CardBattleLinePanel extends JPanel{
    
    private GameControllerInterface gameController;
    private ButtonGroup buttonGroup;
    private List<JRadioButton> radioButtonList;
    private JRadioButton battleButton;
    
    private List<String> battleLine;
    
    public CardBattleLinePanel(GameControllerInterface gameController){
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void initComponents() {
        battleLine = new ArrayList<>();
        battleLine = gameController.getCastleBL();
        
        buttonGroup = new ButtonGroup();
        radioButtonList = new ArrayList<>();
        
        
    }

    private void addComponents() {
        for(String str : battleLine){
            battleButton = new JRadioButton();
            battleButton.setText(str);
            buttonGroup.add(battleButton);
            add(battleButton);
        }
    }
}