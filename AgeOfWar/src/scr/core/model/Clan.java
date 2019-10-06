package scr.core.model;

import java.util.List;
import javax.swing.ImageIcon;

public interface Clan {
    
    String getClanDescription(); // nome do clã
    
    ImageIcon getClanIcons(); // icone doclã
    
    int getNumberCards(); // número de cartões do clã
    
    int getClanPoints(); // pontos para o clã
    
    List<Castle> getCastle();
}
