package game.view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;
import game.view.GameFrame;
import game.view.gameBoard.GameBoardPanel;

@SuppressWarnings("serial")
public class GameInternalFrame extends JInternalFrame{
    
    private JPanel gameBoardPanel;
    
    public GameInternalFrame(GameControllerInterface gameController,GameFrame gameFrame){
        gameBoardPanel = new GameBoardPanel(gameController,gameFrame);
        setContentPane(gameBoardPanel);
    }
    
}