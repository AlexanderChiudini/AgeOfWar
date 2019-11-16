package game.view.gameBoard;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import game.controller.GameControllerInterface;
import game.controller.GameControllerObservers;
import game.view.CardCastleFrame;
import game.view.GameFrame;
import utils.Alerts;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel implements GameControllerObservers{

    GameFrame gameFrame;
    private GameControllerInterface gameController;
    CardCastleFrame castleFrame;
    private SlipBoardPanel slipBoard;
    private JPanel cardsBoard;
    private CardsBoardPanel chosokabeBoard;
    private CardsBoardPanel moriBoard;
    private CardsBoardPanel tokugawaBoard;
    private CardsBoardPanel uesugiBoard;
    private CardsBoardPanel odaBoard;
    private CardsBoardPanel shimazuBoard;
    private DiceBoardPanel diceBoard;
    private PlayerBoardPanel playerBoard;
    
    public GameBoardPanel(GameControllerInterface gameController, GameFrame gameFrame){
        this.gameController = gameController;
        this.gameFrame = gameFrame;
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
        shimazuBoard = new CardsBoardPanel("image/guerra_japonesa.jpg", "shimazu", gameController);
        
        diceBoard = new DiceBoardPanel(gameController);
        playerBoard = new PlayerBoardPanel();
    }

    private void addComponents() {
        add(slipBoard);
        cardsBoard.add(chosokabeBoard);
        cardsBoard.add(moriBoard);
        cardsBoard.add(tokugawaBoard);
        cardsBoard.add(shimazuBoard);
        cardsBoard.add(uesugiBoard);
        cardsBoard.add(odaBoard);
        add(cardsBoard);
        add(diceBoard);
        add(playerBoard);
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

    @Override
    public void diceListImg(List<ImageIcon> diceImg) {
        diceBoard.drawDiceResult(diceImg);
    }

    @Override
    public void openCardFrame() {
        castleFrame = new CardCastleFrame(this.gameController,gameFrame);
        gameFrame.setEnabled(false);
        castleFrame.setVisible(true);
    }

    @Override
    public void getPlayerName(String name) {
        playerBoard.setPlayerName(name);
    }

    @Override
    public void playersCreated() {
        gameController.playerName();
        gameController.playerPoint();
    }

    @Override
    public void playersPoint(int points) {
        playerBoard.setPlayerPoint(points);
    }

    @Override
    public void clearDiceList() {
        diceBoard.clearDicerResult(7);
    }

    @Override
    public void warningAlert(String message, String title) {
        Alerts.getWarningAlert(message, title);
    }

    @Override
    public void updateCardMenu() {
        castleFrame.updateFrame();
    }
    
}