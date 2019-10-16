package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Dice {

    private ImageIcon dado; //imagem do dado
    private List<String> battleLine = new ArrayList();
    
    public Dice(String imagePath) {
        this.dado = new ImageIcon(imagePath);
    }
    
    public void addBattleLine(String crowd){
        battleLine.add(crowd);
    }
    
    public List<String> getBattleLine(){
        return battleLine;
    }
    
    public ImageIcon getDado(){
        return dado;
    }

    private ImageIcon createdImageIcon(String imagePath) {
        return new ImageIcon(imagePath);
    }
}
