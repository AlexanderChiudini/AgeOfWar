package core.model;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Castle extends Composite {

    private int castlePoints; // pontos do castelo
    private String castleName; // nome do castelo
    private List<List<String>> battleLine = new ArrayList<>(); // array contendo os elementos da linha de batalha (infantaria, cavalaria, ...)
    private List<List<String>> conqueredLines = new ArrayList<>();
    private String daimyoBattleLine; // linha de batalha Daimyo
    private boolean conquered;
    private List<ImageIcon> castleFigures; // array contendo as imagens do castelo

    private List<String> line = new ArrayList<>();

    private static Castle instance;
    
    @Override
    public int getPoints() {
        return castlePoints;
    }

    public List<ImageIcon> getCastleFigures() {
        return castleFigures;
    }

    public void setCastleFigures(List<ImageIcon> castleFigures) {
        this.castleFigures = castleFigures;
    }

    public String getCastleName() {
        return castleName;
    }

    public List<List<String>> getBattleLine() {
        return battleLine;
    }

    public String getDaimyoBattleLine() {
        return daimyoBattleLine;
    }

    public void setCastlePoints(int castlePoints) {
        this.castlePoints = castlePoints;
    }

    public void setCastleName(String castleName) {
        this.castleName = castleName;
    }

    public void setBattleLine(List<List<String>> battleLine) {
        this.battleLine = battleLine;
    }

    public void setDaimyoBattleLine(String daimyoBattleLine) {
        this.daimyoBattleLine = daimyoBattleLine;
    }
    
    public void addList(int posicao, String batleLine) {
        if(this.battleLine.size()== posicao){
            this.battleLine.add(new ArrayList<>());
        }
        
        this.battleLine.get(posicao).add(batleLine);
    }

    public ImageIcon getCastleFigureById(int i) {
        return castleFigures.get(i);
    }
    
    public List<ImageIcon> getCastleFigure(){
        return this.castleFigures;
    }

    public boolean isConquered() {
        return this.conquered;
    }

    public void setIsConquered(boolean isConquered) {
        this.conquered = isConquered;
    }
    
    public void addConqueredLines(int i){
        List<String> sub = new ArrayList<>();
        sub.add("Conquistado");
        conqueredLines.add(battleLine.get(i));
        battleLine.set(i, sub);
    }

    public List<List<String>> getConqueredLines() {
        return conqueredLines;
    }
    
    public void remakeBattleLines(){
        for(int i = 0; i < battleLine.size(); i++){
            if("Conquistado".equals(battleLine.get(i).get(0))){
                battleLine.set(i,conqueredLines.get(i));
            }
        }
        conqueredLines.clear();
    }

    @Override
    public int getPointsIsConquered() {
        return this.castlePoints;
    }
}
