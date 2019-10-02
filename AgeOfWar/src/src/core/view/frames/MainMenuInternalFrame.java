package src.core.view.frames;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import src.core.view.mainmenu.MainMenuPanel;

@SuppressWarnings("serial")
public class MainMenuInternalFrame extends JInternalFrame{

    private JPanel mainMenuPanel;
    
    public MainMenuInternalFrame() {
        init();
    }
    
    private void init(){
        initComponents();
        addComponents();
    }
    
    private void initComponents(){
        mainMenuPanel = new MainMenuPanel();
    }
    
    private void addComponents(){
        setContentPane(mainMenuPanel);
    }
    
}