
package core.strategy;

import javax.swing.JOptionPane;

public class InformationAlert implements Strategy {

    private String mensage;
    private String title;
    
    public InformationAlert(String mensage, String title) {
        this.mensage = mensage;
        this.title = title;
    }
    
    @Override
    public void alerta() {
        JOptionPane.showMessageDialog(null, this.mensage, this.title, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
