package src.game.view.gameBoard;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;
import src.game.controller.GameControllerObservers;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel implements GameControllerObservers{

    private GameControllerInterface gameController;
    private SlipBoardPanel slipBoard;
    private JPanel cardsBoard;
    private CardsBoardPanel chosokabeBoard;
    private CardsBoardPanel moriBoard;
    private CardsBoardPanel tokugawaBoard;
    private CardsBoardPanel uesugiBoard;
    private CardsBoardPanel odaBoard;
    private DiceBoardPanel diceBoard;
    
    public GameBoardPanel(GameControllerInterface gameController){
        this.gameController = gameController;
        gameController.attach(this);
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
        currentBoard();
    }

    private void defineProperties() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    private void initComponents() {
        slipBoard = new SlipBoardPanel(gameController);
        
        cardsBoard = new JPanel();
        cardsBoard.setLayout(new CardLayout());
        cardsBoard.setPreferredSize(new Dimension(getX(), 400));
        
        chosokabeBoard = new CardsBoardPanel("image/arquitetura_japonesa.jpg","chosokabe",gameController);
        moriBoard      = new CardsBoardPanel("image/horizonte_japones.jpg","mori",gameController);
        tokugawaBoard  = new CardsBoardPanel("image/kabuki_japones.jpg","tokugawa",gameController);
        uesugiBoard    = new CardsBoardPanel("image/montanha_japonesa.jpg","uesugi",gameController);
        odaBoard    = new CardsBoardPanel("image/mar_japones.jpg","oda",gameController);
        
        diceBoard = new DiceBoardPanel(gameController);
    }

    private void addComponents() {
        add(slipBoard);
        cardsBoard.add(chosokabeBoard);
        cardsBoard.add(moriBoard);
        cardsBoard.add(tokugawaBoard);
        cardsBoard.add(uesugiBoard);
        cardsBoard.add(odaBoard);
        add(cardsBoard);
        add(diceBoard);
    }

    @Override
    public void nextBoard() {
        ((CardLayout)cardsBoard.getLayout()).next(cardsBoard);
        currentBoard();
    }

    @Override
    public void prevBoard() {
        ((CardLayout)cardsBoard.getLayout()).previous(cardsBoard);
        currentBoard();
    }

    @Override
    public void claLabel(String claName) {
        slipBoard.setClaLabel(claName);
    }

    @Override
    public void currentBoard() {
        for(Component comp : cardsBoard.getComponents()){
            if(comp.isVisible()){
                gameController.setClaLabel(((CardsBoardPanel)comp).getClaName());
            }
        }
    }
    
}