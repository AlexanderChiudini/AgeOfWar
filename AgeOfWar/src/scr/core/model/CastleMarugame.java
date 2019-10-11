package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleMarugame extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleMarugame(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
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
        battleLine.add("cavalry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_marugame.png");
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_castelo.png");
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_cla.png");
    }
}
