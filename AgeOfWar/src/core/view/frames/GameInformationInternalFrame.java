package core.view.frames;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import core.view.gameInformation.GameInformationPanel;

@SuppressWarnings("serial")
public class GameInformationInternalFrame extends JInternalFrame{
    
    private JPanel gameInformationPanel;
    
    public GameInformationInternalFrame(){
        init();
    }

    private void init() {
        initComponents();
        addComponents();
    }

    private void initComponents() {
        gameInformationPanel = new GameInformationPanel();
    }

    private void addComponents() {
        setContentPane(gameInformationPanel);
    }
    
}