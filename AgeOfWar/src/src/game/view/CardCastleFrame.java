package src.game.view;

import java.awt.Color;
import java.beans.PropertyVetoException;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import src.game.controller.GameControllerInterface;
import src.game.view.frame.CardMenuInternalFrame;

@SuppressWarnings("serial")
public class CardCastleFrame extends JFrame{
    
    private GameControllerInterface gameController;
    public static final int WIDTH = 1176;
    public static final int HEIGHT = 606;
    private CardMenuInternalFrame cardMenu;
    
    public CardCastleFrame(GameControllerInterface gameController, String castleName){
        this.gameController = gameController;
        
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle(castleName);
        setUndecorated(true);
        JDesktopPane desktopPane = new JDesktopPane();
        cardMenu = new CardMenuInternalFrame(this.gameController);
        cardMenu.setBorder(null);
        cardMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ((BasicInternalFrameUI) cardMenu.getUI()).setNorthPane(null);
        desktopPane.add(cardMenu);
        setContentPane(desktopPane);
        try {
            cardMenu.setSelected(true);
            cardMenu.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void setVisible(boolean b) {
        cardMenu.setVisible(b);
        super.setVisible(b);
    }
}