package scr.core.model;

import java.util.List;

public abstract class Castle {

    private int castlePoints; // pontos do castelo
    private String castleName; // nome do castelo
    private List<String> battleLine; // array contendo os elementos da linha de batalha (infantaria, cavalaria, ...)
    private String daimyoBattleLine; // linha de batalha Daimyo
    
    /**
     * 
     * Cria um castelo com seus parâmetros
     * 
     * @param points            Define o número de pontos para o castelo
     * @param name              Define o nome do castelo
     * @param normalBattleLine  Define a linha de batalha do castelo
     * @param daimyoBattleLine  Define o linha de batalha Daimyo
     */
    public Castle(int points, String name, List<String> normalBattleLine, String daimyoBattleLine) {
        this.castleName = name;
        this.castlePoints = points;
        this.battleLine = normalBattleLine;
        this.daimyoBattleLine = daimyoBattleLine;
    }

    public int getCastlePoints() {
        return castlePoints;
    }

    public String getCastleName() {
        return castleName;
    }

    public List<String> getBattleLine() {
        return battleLine;
    }

    public String getDaimyoBattleLine() {
        return daimyoBattleLine;
    }
}
