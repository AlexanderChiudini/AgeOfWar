package core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Clan extends Composite {
    
    private String clanName;
    private ImageIcon clanIcon;
    private int clanPoints;
    private List<Castle> castles = new ArrayList<>();
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

    public void setPoints(int points) {
        this.clanPoints = points;
    }

    public List<Castle> getCastles() {
        return castles;
    }
    
    public Castle getCastle(int position){
        return castles.get(position);
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

    @Override
    public int getPoints() {
        int pontos = 0;
        for(Castle c : castles) {
            if(c.isConquered()) {
                pontos += c.getPoints();
            }
        }
        return pontos;
    }
}
