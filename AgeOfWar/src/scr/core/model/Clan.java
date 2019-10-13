package scr.core.model;

import java.util.List;
import javax.swing.ImageIcon;

public class Clan {
    
    private String clanName;
    private ImageIcon clanIcon;
    private int clanPoints;
    private List<Castle> castles;
    private boolean isConquered;

    public String getName() {
        return clanName;
    }

    public void setName(String name) {
        this.clanName = name;
    }

    public ImageIcon getIcon() {
        return clanIcon;
    }

    public void setIcon(ImageIcon icon) {
        this.clanIcon = icon;
    }

    public int getPoints() {
        return clanPoints;
    }

    public void setPoints(int points) {
        this.clanPoints = points;
    }

    public List<Castle> getCastles() {
        return castles;
    }

    public void setCastles(List<Castle> castles) {
        this.castles = castles;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public ImageIcon getClanIcon() {
        return clanIcon;
    }

    public void setClanIcon(ImageIcon clanIcon) {
        this.clanIcon = clanIcon;
    }

    public int getClanPoints() {
        return clanPoints;
    }

    public void setClanPoints(int clanPoints) {
        this.clanPoints = clanPoints;
    }

    public boolean isIsConquered() {
        return isConquered;
    }

    public void setIsConquered(boolean isConquered) {
        this.isConquered = isConquered;
    }
}
