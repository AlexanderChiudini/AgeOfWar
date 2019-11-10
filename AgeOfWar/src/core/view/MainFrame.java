package core.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import core.controller.MainController;
import core.controller.MainControllerInterface;
import core.controller.MainControllerObserver;
import core.view.frames.PlayerSelectionInternalFrame;
import core.view.frames.GameInformationInternalFrame;
import core.view.frames.MainMenuInternalFrame;
import game.controller.GameControllerInterface;
import game.view.GameFrame;
import utils.Alerts;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements MainControllerObserver {

    private static MainFrame instance;
    public static final int WIDTH = 1176;
    public static final int HEIGHT = 606;
    private JDesktopPane desktop;
    private JInternalFrame mainMenu;
    private GameInformationInternalFrame gameInformation;
    private PlayerSelectionInternalFrame playerSelection;

    private MainControllerInterface mainController;

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainController = MainController.getInstance();
        mainController.attach(this);
        init();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    private void initComponents() {
        desktop = new JDesktopPane();
        mainMenu = new MainMenuInternalFrame();
        gameInformation = new GameInformationInternalFrame();
        playerSelection = new PlayerSelectionInternalFrame();
    }

    private void addComponents() {
        setContentPane(desktop);
        desktop.add(mainMenu);
        desktop.add(gameInformation);
        desktop.add(playerSelection);
    }

    private void openInternalFrame(JInternalFrame frame) {
        frame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ((BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
        try {
            frame.setSelected(true);
            frame.setMaximum(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        frame.setVisible(true);
    }

    @Override
    public void setVisible(boolean b) {
        if (mainMenu != null) {
            openInternalFrame(mainMenu);
        }
        super.setVisible(b);
    }

    @Override
    public void systemWillBeClosed() {
        Alerts.getInformationAlert("Obrigado, volte sempre!!! ;D", "Obrigado");
    }

    @Override
    public void showGameInfo() {
        openInternalFrame(gameInformation);
    }

    @Override
    public void developerInfo() {
        Alerts.getInformationAlert("Este sistema foi desenvolvido para a disciplina de Padrões de Projeto (PPR55) pela supervisão do Professor Adilson Vahldick\n"
                + "\n\n"
                + "Desenvolvedor : Alexander Felipe Chiudini Ristow\n"
                + "Desenvolvedor : Lucas Eduardo Nogueira\n"
                + "\n"
                + "Somos acadêmicos do curso de Engenharia de Software (ESO)\n"
                + "controlado pelo Departamento de Engenharia de Software (DESO)\n"
                + "no Centro de Educação Superior do Alto Vale do Itajaí\n"
                + "\n\n"
                + "                                                                                                                                                                                                                       21/11/2019"
                , "Desenvolvedores");
    }

    @Override
    public void returnToMainMenu() {
        openInternalFrame(mainMenu);
    }
    
    @Override
    public void playerSelection() {
        openInternalFrame(playerSelection);
    }

    @Override
    public void playerInfo() {
        mainController.setPlayer1(playerSelection.getPlayer1Name());
        mainController.setPlayer2(playerSelection.getPlayer2Name());

        mainController.gameStart();
    }

    @Override
    public void loadingGame(GameControllerInterface gameController) {
        GameFrame gameFrame = new GameFrame(gameController);
        gameFrame.setVisible(true);
        setVisible(false);
    }
}
