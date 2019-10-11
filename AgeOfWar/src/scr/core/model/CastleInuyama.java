package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleInuyama extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    private List<String> castleFigures = new ArrayList<>();

    public CastleInuyama(int points, String name, List<String> normalBattleLine, String daimyoBattleLine, List<String> castleFigures) {
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
        battleLine.add("archery");
        battleLine.add("archery");
    }
    
    public void setCastleFigures(){
        castleFigures.add("image/cartas/cla_tokugawa/carta_tokugawa_inuyama.png");
        castleFigures.add("image/cartas/cla_tokugawa/carta_tokugawa_castelo.png");
        castleFigures.add("image/cartas/cla_tokugawa/carta_tokugawa_cla.png");
    }
}
