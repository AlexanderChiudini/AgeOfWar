package core.view.mainmenu;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

import utils.BackgroundPanel;

@SuppressWarnings("serial")
public class MainMenuPanel extends BackgroundPanel{
    
    private static final String IMAGEPATH = "image/age-of-war.jpg";
    private static final int LAYOUT_ROWS = 1;
    private static final int LAYOUT_COLS = 2;
    private JPanel leftPanel;
    private JPanel menuActionPanel;
    
    public MainMenuPanel(){
        super(IMAGEPATH);
        init();
    }
    
    private void init(){
        setBackground(Color.RED);
        defineProperties();
        initComponents();
        addComponents();
    }
    
    private void defineProperties(){
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS));
    }
    
    private void initComponents(){
        leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        
        menuActionPanel = new MenuActionPanel();
        menuActionPanel.setOpaque(false);
    }
    
    private void addComponents(){
        add(leftPanel);
        add(menuActionPanel);
    }
    
}