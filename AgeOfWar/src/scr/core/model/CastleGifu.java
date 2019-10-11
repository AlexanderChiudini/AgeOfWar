package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleGifu extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleGifu(int points, String name, List<String> normalBattleLine, String daimyoBattleLine,List<String> castleFigures) {
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
        battleLine.add("archery");
        battleLine.add("archery");
        battleLine.add("cavalry");
        battleLine.add("cavalry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_oda/carta_oda_gifu.png");
        castleFigures.add("image/cartas/cla_oda/carta_oda_castelo.png");
        castleFigures.add("image/cartas/cla_oda/carta_oda_cla.png");
    }
}
