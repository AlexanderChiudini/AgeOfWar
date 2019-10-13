package scr.core.model;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Castle {

    private int castlePoints; // pontos do castelo
    private String castleName; // nome do castelo
    private List<List<String>> battleLine = new ArrayList<>(); // array contendo os elementos da linha de batalha (infantaria, cavalaria, ...)
    private String daimyoBattleLine; // linha de batalha Daimyo
    private List<ImageIcon> castleFigures; // array contendo as imagens do castelo

    private List<String> line = new ArrayList<>();

    private static Castle instance;
    
    public static synchronized Castle getInstance() {
        if(instance == null) {
            instance = new Castle();
        }
        return instance;
    }
    
    public int getCastlePoints() {
        return castlePoints;
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
    
    public void addDaimyo(int posicao, List<String> daimyo) {
        this.battleLine.set(posicao, daimyo);
    }
    
    public void addCavalry(int posicao, List<String> cavalry) {
        this.battleLine.set(posicao, cavalry);
    }
    
    public void addSword(int posicao, List<String> sword) {
        this.battleLine.set(posicao, sword);
    }
    
    public void addArchery(int posicao, List<String> archery) {
        this.battleLine.set(posicao, archery);
    }

    public ImageIcon getCastleFigureById(int i) {
        return castleFigures.get(i);
    }
    
    public List<ImageIcon> getCastleFigure(){
        return castleFigures;
    }
}
