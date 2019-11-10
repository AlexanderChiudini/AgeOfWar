package core.view.gameInformation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import core.controller.MainController;
import core.controller.MainControllerInterface;
import utils.BackgroundPanel;

@SuppressWarnings("serial")
public class GameInformationPanel extends BackgroundPanel{
    
    private static final String IMAGEPATH = "image/age-of-war-info.jpg";
    private static final int B_WIDTH = 130;
    private static final int B_HEIGHT = 30;
    private JButton backButton;
    
    private MainControllerInterface mainController;
    
    public GameInformationPanel() {
        super(IMAGEPATH);
        mainController = MainController.getInstance();
        init();
    }

    private void init() {
        setBackground(Color.BLACK);
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        // nothing
    }

    private void initComponents() {
        backButton = createButton("Menu Principal", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.goToMainMenu();
            }
        });
    }

    private void addComponents() {
        int y = 0;
        add(backButton);
    }
    
    private JButton createButton(String name, ActionListener actionListener) {
        JButton button = new JButton();
        button.setText(name);
        button.setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        button.addActionListener(actionListener);
        return button;
    }
    
}