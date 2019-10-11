package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleMatsuyama extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();
    
    public CastleMatsuyama(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
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
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
        battleLine.add("infantry");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_matsuyama.png");
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_castelo.png");
        castleFigures.add("image/cartas/cla_chosokabe/carta_chosokabe_cla.png");
    }
}
