package core.view.frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import core.controller.MainController;
import core.controller.MainControllerInterface;
import core.view.playerSelection.PlayerPanelAction;
import utils.BackgroundPanel;

@SuppressWarnings("serial")
public class PlayerSelectionInternalFrame extends JInternalFrame{
    
    private JPanel playerSelectionPanel;
    private static String imagePath = "image/samurai_de_costas.jpg";
    private PlayerPanelAction player1Panel;
    private PlayerPanelAction player2Panel;
    
    private JButton confirmButton;
    private JButton cancelButton;
    
    MainControllerInterface mainController;
    
    public PlayerSelectionInternalFrame(){
        mainController = MainController.getInstance();
        init();
    }

    private void init() {
        initComponents();
        addComponents();
    }

    private void initComponents() {
        playerSelectionPanel = new BackgroundPanel(imagePath);
        
        player1Panel = new PlayerPanelAction(1,"Jogador 1:");
        player1Panel.setOpaque(false);
        
        player2Panel = new PlayerPanelAction(2,"Jogador 2:");
        player2Panel.setOpaque(false);
        
        cancelButton = new JButton();
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.goToMainMenu();
            }
        });
        
        confirmButton = new JButton();
        confirmButton.setText("Jogar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.playersInformation();
            }
        });
    }

    private void addComponents() {
        setContentPane(playerSelectionPanel);
        playerSelectionPanel.setLayout(new BorderLayout());
        
        JPanel playersPanel = new JPanel();
        playersPanel.setOpaque(false);
        playersPanel.setLayout(new GridLayout(1, 2));
        playersPanel.add(player1Panel);
        playersPanel.add(player2Panel);
        playerSelectionPanel.add(playersPanel,BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(cancelButton);
        buttonPanel.add(confirmButton);
        playerSelectionPanel.add(buttonPanel,BorderLayout.SOUTH);
    }
    
    public String getPlayer1Name(){
        return player1Panel.getNameField().getText();
    }
    
    public String getPlayer2Name(){
        return player2Panel.getNameField().getText();
    }
}