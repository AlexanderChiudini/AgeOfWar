package src.game.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private GameFrame gameFrame;
    
    public CardCastleFrame(GameControllerInterface gameController,GameFrame gameFrame){
        this.gameController = gameController;
        this.gameFrame = gameFrame;
        
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        JDesktopPane desktopPane = new JDesktopPane();
        cardMenu = new CardMenuInternalFrame(this.gameController,this,gameFrame);
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gameFrame.setEnabled(true);
            }
        });
    }
    
    @Override
    public void setVisible(boolean b) {
        cardMenu.setVisible(b);
        super.setVisible(b);
    }
}