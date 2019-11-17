
package core.strategy;

import javax.swing.JOptionPane;

public class WarningAlert implements Strategy {

    private String mensage;
    private String title;
    
    public WarningAlert(String mensage, String title) {
        this.mensage = mensage;
        this.title = title;
    }
    
    @Override
    public void alerta() {
        JOptionPane.showMessageDialog(null, this.mensage, this.title, JOptionPane.ERROR_MESSAGE);
    }
    
}
