package src.game.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import src.core.view.MainFrame;

import src.game.controller.GameControllerInterface;
import src.game.view.frame.GameInternalFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    public static final int WIDTH = 1360;
    public static final int HEIGHT = 720;
//    private JDesktopPane desktop;
    private JInternalFrame gameMenu;

    private GameControllerInterface gameController;

//    public GameFrame(GameControllerInterface gameController) {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.gameController = gameController;
//        init();
//    }
    public GameFrame(GameControllerInterface gameController) {
        this.gameController = gameController;
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Age Of War");
        JDesktopPane desktopPane = new JDesktopPane();
        gameMenu = new GameInternalFrame(gameController);
        gameMenu.setBorder(null);
        ((BasicInternalFrameUI) gameMenu.getUI()).setNorthPane(null);
        desktopPane.add(gameMenu);
        setContentPane(desktopPane);
        try {
            gameMenu.setSelected(true);
            gameMenu.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                MainFrame.getInstance().setVisible(true);
            }
        });
    }

//    private void init() {
//        defineProperties();
//        initComponents();
//        addComponents();
//    }
//    
//    private void defineProperties() {
//        setResizable(false);
//        setSize(WIDTH, HEIGHT);
//        setLocationRelativeTo(null);
//        setUndecorated(true);
//    }
//
//    private void initComponents() {
//        desktop = new JDesktopPane();
//        gameMenu = new GameInternalFrame();
//    }
//
//    private void addComponents() {
//        setContentPane(desktop);
//        desktop.add(gameMenu);
//    }
//
    @Override
    public void setVisible(boolean b) {
        gameMenu.setVisible(b);
        super.setVisible(b);
    }

}
