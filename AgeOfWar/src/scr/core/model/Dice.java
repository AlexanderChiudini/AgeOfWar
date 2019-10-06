package scr.core.model;

import javax.swing.ImageIcon;

public abstract class Dice implements Cloneable {

    private ImageIcon dado;
    
    public Dice(ImageIcon dado) {
        this.dado = dado;
    }
    
    @Override
    public Dice clone() throws CloneNotSupportedException {
        return (Dice) super.clone();
    }
}
