package src.game.view.cardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.game.controller.GameControllerInterface;

public class PlayCardPanel extends JPanel {

    private GameControllerInterface gameController;
    private JPanel playerPanel;
    private JPanel dicePanel;
    private JPanel possiblePanel;
    private JPanel conquerorsPanel;
    private JPanel doPanel;

    private JLabel playerLabel;
    private JButton playButton;
    private JButton cancelButton;

    private JLabel diceLabel;
    private List<ImageIcon> diceImg;

    public PlayCardPanel(GameControllerInterface gameController) {
        this.gameController = gameController;
        init();
    }

    private void init() {
        defineProperties();
        initComponents();
        addComponents();
    }

    private void defineProperties() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    private void initComponents() {
        diceImg = new ArrayList<>();
        diceImg = gameController.playerDiceImg();

        playerLabel = new JLabel(gameController.playerText());

        playButton = new JButton("Jogar");
        playButton.setBackground(Color.RED);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBackground(Color.GREEN);

        playerPanel = new JPanel();

        dicePanel = new JPanel();
        dicePanel.setLayout(new GridLayout(1, 7));
        
        possiblePanel = new CardBattleLinePanel(gameController);

        doPanel = new JPanel();
    }

    private void addComponents() {
        playerPanel.add(playerLabel);
        
        drawDiceResult();
        
        doPanel.add(cancelButton);
        doPanel.add(playButton);

        add(playerPanel);
        add(new JLabel("Dados"));
        add(dicePanel);
        add(new JLabel("Linhas de Batalha do Castelo"));
        add(doPanel);
    }

    public void drawDiceResult() {
        for (int i = 0; i < this.diceImg.size(); i++) {
            diceLabel = new JLabel();
            diceLabel.setPreferredSize(new Dimension(10, 10));
            diceLabel.setIcon(diceImg.get(i));
            dicePanel.add(diceLabel);
        }
    }
}
