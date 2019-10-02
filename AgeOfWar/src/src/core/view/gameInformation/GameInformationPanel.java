package src.core.view.gameInformation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import src.utils.BackgroundPanel;

@SuppressWarnings("serial")
public class GameInformationPanel extends BackgroundPanel{
    
    private static final String IMAGEPATH = "image/age-of-war-info.jpg";
    private static final int B_WIDTH = 130;
    private static final int B_HEIGHT = 30;
    private JButton backButton;
    
    public GameInformationPanel() {
        super(IMAGEPATH);
        init();
    }

    private void init() {
        setBackground(Color.BLACK);
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
//        setLayout(new GridLayout(1,16));
    }

    private void initComponents() {
        backButton = createButton("Menu Principal", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Menu Principal");
            }
        });
System.out.println("teste");
    }

    private void addComponents() {
        int y = 0;
        add(backButton,createButtonConstraints(y++));
System.out.println("teste add");
    }
    
    private JButton createButton(String name, ActionListener actionListener) {
        JButton button = new JButton();
        button.setText(name);
        button.setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        button.addActionListener(actionListener);
        return button;
    }
    
    private GridBagConstraints createButtonConstraints(int y) {
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridy = y;
        cons.anchor = GridBagConstraints.EAST;
        cons.fill = GridBagConstraints.VERTICAL;
        cons.insets = new Insets(5, 0, 5, 0);
        return cons;
    }
    
}