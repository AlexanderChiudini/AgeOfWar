package src.game.view.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.game.view.GameFrame;
import src.game.view.gameBoard.GameBoardPanel;

@SuppressWarnings("serial")
public class GameInternalFrame extends JInternalFrame{
    
    private JPanel gameBoardPanel;
    
    public GameInternalFrame(GameControllerInterface gameController,GameFrame gameFrame){
        gameBoardPanel = new GameBoardPanel(gameController,gameFrame);
        setContentPane(gameBoardPanel);
    }
    
}