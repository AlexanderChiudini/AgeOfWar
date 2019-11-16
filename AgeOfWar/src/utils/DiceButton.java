package utils;

import game.controller.GameControllerInterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DiceButton extends JButton{

    private GameControllerInterface gameController;
    private boolean condition;
    private int indice;
    
    public DiceButton(GameControllerInterface gc, boolean cond,int i){
        this.gameController = gc;
        this.condition = cond;
        this.indice = i;
        setBackground(Color.CYAN);
        addAction();
    }

    private void addAction() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.addPlayerChooseDice(indice);
                condition = !condition;
                shiftBackground(condition);
            }
        });
    }
    
    private void shiftBackground(boolean c){
        if(c == true){
            setBackground(Color.CYAN);
        }else{
            setBackground(Color.BLUE);
        }
    }
}