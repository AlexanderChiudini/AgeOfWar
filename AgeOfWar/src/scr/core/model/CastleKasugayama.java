package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleKasugayama extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleKasugayama(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
        super(points, name, normalBattleLine, daimyoBattleLine, castleFigures);
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
        battleLine.add("cavalry");
        battleLine.add("cavalry");
        battleLine.add("archery");
        battleLine.add("archery");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_kasugayama.png");
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_castelo.png");
        castleFigures.add("image/cartas/cla_uesugi/carta_uesugi_cla.png");
    }
}
