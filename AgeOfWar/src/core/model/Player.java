package core.model;

import core.state.EstadoJogo;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Clan> playerClan = new ArrayList<>();
    private List<Castle> conqueredCastle = new ArrayList<>();
    private List<Dice> dice = new ArrayList<>(7);
    private List<Dice> chooseDice = new ArrayList<>(7);
    private String[][] battleLine = new String[14][38];
    private int points;
    private EstadoJogo state;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
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
    
    public Castle getCastle(String name){
        Castle castle = null;
        for(Castle c : conqueredCastle){
            if(name.equals(c.getCastleName())){
                castle = c;
            }
        }
        
        return castle;
    }
    
    public void addConqueredCastle(Castle c){
        this.conqueredCastle.add(c);
    }
    
    public void removeConqueredCastle(Castle c){
        this.conqueredCastle.remove(c);
    }

    public List<Dice> getDice() {
        return dice;
    }

    public void setDice(List<Dice> dice) {
        this.dice = dice;
    }

    public void pushDice(Dice dice) {
        this.dice.add(dice);
    }

    public String[][] getBattleLine() {
        return battleLine;
    }

    public void setBattleLine(String[][] teste) {
        this.battleLine = teste;
    }

    public void addChooseDice(Dice dice) {
        this.chooseDice.add(dice);
    }

    public void removeChooseDice(Dice dice) {
        this.chooseDice.remove(dice);
    }

    public void clearChooseDice() {
        this.chooseDice.clear();
    }
    
    public List<Dice> getChooseDice(){
        return this.chooseDice;
    }

    public EstadoJogo getState() {
        return state;
    }

    public void setState(EstadoJogo state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String diceName = "";
        for (Dice dados : dice) {
            diceName += dados.getBattleLine().toString();
        }
        return diceName;
    }

    public void removeDiceForChoose() {
        for(Dice d : chooseDice){
           dice.remove(d);
        }
        chooseDice.clear();
    }

    public List<Clan> getPlayerClan() {
        return this.playerClan;
    }

    public void setPlayerClan(List<Clan> playerClan) {
        this.playerClan = playerClan;
    }

    public Clan getClanWithCastle(Castle cardCastle) {
        Clan clan = null;
        for(Clan sub : playerClan){
            for(Castle castle : sub.getCastles()){
                if(cardCastle.getCastleName().equals(castle.getCastleName())){
                    clan = sub;
                }
            }
        }
        return clan;
    }
    
    public Clan getClanWithName(String name){
        Clan clan = null;
        for(Clan sub : playerClan){
            if(sub.getClanName().equals(name)){
                clan = sub;
            }
        }
        return clan;
    }
    
}
