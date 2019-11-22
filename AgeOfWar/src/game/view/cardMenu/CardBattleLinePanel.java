package game.view.cardMenu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class CardBattleLinePanel extends JPanel {

    private GameControllerInterface gameController;
    private List<JCheckBox> buttonList;
    private JCheckBox battleButton;

    private List<String> battleLine;

    public CardBattleLinePanel(GameControllerInterface gameController) {
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

        buttonList = new ArrayList<>();

    }

    private void addComponents() {
        if (battleLine != null) {
            for (String str : battleLine) {
                battleButton = new JCheckBox();
                battleButton.setText(str);
                if("[Conquistado,]".equals(str)){
                    battleButton.setEnabled(false);
                }
                buttonList.add(battleButton);
                add(battleButton);
            }
        } else {
            add(new JLabel("Castelo Conquistado"));
        }
    }

    public List<String> battleLineCheck() {
        List<String> str = new ArrayList<>();

        for (JCheckBox b : buttonList) {
            if (b.isSelected()) {
                str.add(b.getText());
            }
        }
        return str;
    }

    List<Integer> blCheckIndices() {
        List<Integer> indices = new ArrayList<>();
        
        for(int i =0; i < buttonList.size(); i++){
            if(buttonList.get(i).isSelected()){
                indices.add(i);
            }
        }
        
        return indices;
    }
}
