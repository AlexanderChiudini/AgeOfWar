package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleKitanosho extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleKitanosho(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
        super(points, name, normalBattleLine, daimyoBattleLine,castleFigures);
    }
    
    @Override
    public List<String> getBattleLine() {
        return battleLine;
    }
    
    @Override
    public List<String> getCastleFigure(){
        return castleFigures;
    }

    public void setBattleLine() {
        battleLine.add("daimyo");
        battleLine.add("cavalry");
        battleLine.add("archery");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_kitanosho.png");
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_castelo.png");
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_cla.png");
    }
}
