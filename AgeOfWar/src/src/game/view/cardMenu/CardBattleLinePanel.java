package src.game.view.cardMenu;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
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
//        setLayout(new GridLayout(1,2));
    }

    private void initComponents() {
        battleLine = new ArrayList<>();
        battleLine = gameController.getCastleBL();
        
        buttonGroup = new ButtonGroup();
        radioButtonList = new ArrayList<>();
        
        battleButton = new JRadioButton();
    }

    private void addComponents() {
        
    }
    
}