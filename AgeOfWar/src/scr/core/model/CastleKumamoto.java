package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleKumamoto extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();

    public CastleKumamoto(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
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
        battleLine.add("daimyo");
        battleLine.add("daimyo");
        battleLine.add("archery");
        battleLine.add("cavalry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_shimazu/carta_shimazu_kumamoto.png");
        castleFigures.add("image/cartas/cla_shimazu/carta_shimazu_cla.png");
    }
}
