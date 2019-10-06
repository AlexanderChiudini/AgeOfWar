package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleKasugayama extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    
    public CastleKasugayama(int points, String name, List<String> normalBattleLine, String daimyoBattleLine) {
        super(points, name, normalBattleLine, daimyoBattleLine);
    }
    
    @Override
    public List<String> getBattleLine() {
        return battleLine;
    }

    public void setBattleLine() {
        battleLine.add("cavalry");
        battleLine.add("cavalry");
        battleLine.add("archery");
        battleLine.add("archery");
    }
}
