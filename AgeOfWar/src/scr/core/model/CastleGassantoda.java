package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleGassantoda extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleGassantoda(int points, String name, List<String> normalBattleLine, String daimyoBattleLine,List<String> castleFigures) {
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
        battleLine.add("cavalry");
        battleLine.add("cavalry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_mori/carta_mori_gassantoda.png");
        castleFigures.add("image/cartas/cla_mori/carta_mori_castelo.png");
        castleFigures.add("image/cartas/cla_mori/carta_mori_cla.png");
    }
}
