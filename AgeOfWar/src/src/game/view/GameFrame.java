package src.game.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import src.game.controller.GameControllerInterface;
import src.game.view.frame.GameInternalFrame;

public class GameFrame extends JFrame{
    
    public static final int WIDTH = 1376;
    public static final int HEIGHT = 806;
    private JDesktopPane desktop;
    private JInternalFrame gameMenu;

    private GameControllerInterface gameController;

    public GameFrame(GameControllerInterface gameController) {
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void initComponents() {
        desktop = new JDesktopPane();
        gameMenu = new GameInternalFrame();
    }

    private void defineProperties() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    private void addComponents() {
        setContentPane(desktop);
        desktop.add(gameMenu);
    }

    @Override
    public void setVisible(boolean b) {
        gameMenu.setVisible(b);
        super.setVisible(b);
    }
    
}