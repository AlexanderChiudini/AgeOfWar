package src.core.view.mainmenu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import src.core.controller.MainController;
import src.core.controller.MainControllerInterface;

@SuppressWarnings("serial")
public class MenuActionPanel extends JPanel {

    private static final int B_WIDTH = 130;
    private static final int B_HEIGHT = 30;
    private List<JButton> buttonList;
    
    private MainControllerInterface mainController;

    public MenuActionPanel() {
        buttonList = new ArrayList<>();
        mainController = MainController.getInstance();
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
        buttonList.add(createButton("Novo Jogo", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Novo Jogo");
            }
        }));
        buttonList.add(createButton("Quem Somos", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.developers();
            }
        }));
        buttonList.add(createButton("Sobre o Jogo", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.gameInfo();
            }
        }));
        buttonList.add(createButton("Sair", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.closeWindow();
            }
        }));
    }

    private void addComponents() {
        int y = 0;
        for (JButton button : buttonList) {
            add(button, createButtonConstraints(y++));
        }
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
        cons.anchor = GridBagConstraints.CENTER;
        cons.fill = GridBagConstraints.VERTICAL;
        cons.insets = new Insets(5, 0, 5, 0);
        return cons;
    }

}
