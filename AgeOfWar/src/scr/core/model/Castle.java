package scr.core.model;

import java.util.List;

public abstract class Castle {

    private int castlePoints; // pontos do castelo
    private String castleName; // nome do castelo
    private List<String> battleLine; // array contendo os elementos da linha de batalha (infantaria, cavalaria, ...)
    private String daimyoBattleLine; // linha de batalha Daimyo
    private List<String> castleFigures; // array contendo as imagens do castelo
    
    /**
     * 
     * Cria um castelo com seus parâmetros
     * 
     * @param points            Define o número de pontos para o castelo
     * @param name              Define o nome do castelo
     * @param normalBattleLine  Define a linha de batalha do castelo
     * @param daimyoBattleLine  Define a linha de batalha Daimyo
     * @param castleFigures     Define as imagens do castelo
     */
    public Castle(int points, String name, List<String> normalBattleLine, String daimyoBattleLine,List<String> castleFigures) {
        this.castleName = name;
        this.castlePoints = points;
        this.battleLine = normalBattleLine;
        this.daimyoBattleLine = daimyoBattleLine;
        this.castleFigures = castleFigures;
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
    
    public String getCastleFigureById(int i){
        return castleFigures.get(i);
    }
    
    public List<String> getCastleFigure(){
        return castleFigures;
    }
}
