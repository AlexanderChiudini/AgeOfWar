package src.utils;

import javax.swing.JOptionPane;

public class Alerts{
    
    public static void getInformationAlert(String mensage, String title){
        JOptionPane.showMessageDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE);
    }
}