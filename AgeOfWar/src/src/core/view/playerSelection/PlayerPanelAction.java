package src.core.view.playerselection;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerPanelAction extends JPanel {

    private static final int I_WIDTH = 200;
    private static final int I_HEIGHT = 25;
    private JLabel label;
    private JTextField nameField;
    private int playerNumber;
    private String labelTxt;

    public PlayerPanelAction(int playerNumber, String labelTxt) {
        this.playerNumber = playerNumber;
        this.labelTxt = labelTxt;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents() {
        label = new JLabel();
        label.setText(labelTxt);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(I_WIDTH, I_HEIGHT));
    }

    private void addComponents() {
        GridBagConstraints cons;

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(0, 0, 5, 0);
        add(label, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        add(nameField, cons);
    }

    public JTextField getNameField() {
        return nameField;
    }

}
