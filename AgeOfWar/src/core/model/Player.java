package core.model;

import core.state.EstadoJogo;
import core.visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private String name;
    private List<Castle> conqueredCastle = new ArrayList<>();
    private List<Dice> dice = new ArrayList<>(7);
    private String[][] battleLine = new String[14][38];
    private int points;
    private EstadoJogo state;

    public Player(String name, int points, EstadoJogo state) {
        this.name = name;
        this.points = points;
        this.state = state;
    }
    
    public void jogar() throws Exception {
        this.state.jogar();
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Castle> getConqueredCastle() {
        return conqueredCastle;
    }

    public void setConqueredCastle(List<Castle> conqueredCastle) {
        this.conqueredCastle = conqueredCastle;
    }

    public List<Dice> getDice() {
        return dice;
    }

    public void setDice(List<Dice> dice) {
        this.dice = dice;
    }
    
    public void pushDice(Dice dice){
        this.dice.add(dice);
    }

    public String[][] getBattleLine() {
        return battleLine;
    }

    public void setBattleLine(String[][] teste) {
        this.battleLine = teste;
    }

    public EstadoJogo getState() {
        return state;
    }

    public void setEstado(EstadoJogo state) {
        this.state = state;
    }
    
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        String diceName = "";
        for(Dice dados : dice) {
            diceName += dados.getBattleLine().toString();
        }
        return diceName;
    }
}
