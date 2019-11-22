package game.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import core.view.MainFrame;

import game.controller.GameControllerInterface;
import game.view.frame.GameInternalFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    public static final int WIDTH = 1360;
    public static final int HEIGHT = 720;
    private JInternalFrame gameMenu;

    private GameControllerInterface gameController;

    public GameFrame(GameControllerInterface gameController) {
        this.gameController = gameController;
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Age Of War");
        JDesktopPane desktopPane = new JDesktopPane();
        gameMenu = new GameInternalFrame(this.gameController, this);
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
                closeWindow();
            }
        });
    }

    @Override
    public void setVisible(boolean b) {
        gameMenu.setVisible(b);
        super.setVisible(b);
    }

    private void closeWindow() {
        setVisible(false);
        MainFrame main = MainFrame.getInstance();
        main.setVisible(true);
    }

}
