package scr.core.model;

import java.util.ArrayList;
import java.util.List;

public class CastleGassantoda extends Castle {
    
    private List<String> battleLine = new ArrayList<>();
    
    public CastleGassantoda(int points, String name, List<String> normalBattleLine, String daimyoBattleLine) {
        super(points, name, normalBattleLine, daimyoBattleLine);
    }
    
    @Override
    public List<String> getBattleLine() {
        return battleLine;
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
}
