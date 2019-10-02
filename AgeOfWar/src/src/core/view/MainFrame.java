package src.core.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import src.core.controller.MainController;
import src.core.controller.MainControllerInterface;
import src.core.controller.MainControllerObserver;
import src.core.view.frames.GameInformationInternalFrame;

import src.core.view.frames.MainMenuInternalFrame;
import src.utils.Alerts;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements MainControllerObserver {

    private static MainFrame instance;
    public static final int WIDTH = 1176;
    public static final int HEIGHT = 606;
    private JDesktopPane desktop;
    private JInternalFrame mainMenu;
    private GameInformationInternalFrame gameInformation;

    private MainControllerInterface mainController;

    private MainFrame() {
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
        gameInformation = new GameInformationInternalFrame();
        mainMenu = new MainMenuInternalFrame();
    }

    private void addComponents() {
        setContentPane(desktop);
        desktop.add(mainMenu);
        desktop.add(gameInformation);
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
                + "Desenvolvedor : Alexander Ristow Childini\n"
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
}
