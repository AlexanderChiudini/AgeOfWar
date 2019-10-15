package src.core.controller;

import java.util.ArrayList;
import java.util.List;
import scr.core.builder.BuilderClanChosokabe;
import scr.core.builder.Director;
import scr.core.factory.ClassicClan;
import scr.core.model.Castle;
import scr.core.model.Clan;
import scr.core.model.Dice;

public class NarutoController {
    
    private List<Dice> dice = new ArrayList<>();
    
    private static NarutoController instance;

    public static synchronized NarutoController getInstance() {
        if (instance == null) {
            instance = new NarutoController();
        }
        return instance;
    }
    
    public void escolherJogada() {
        List<String> side = new ArrayList<>(); // lista com todas as faces sorteadas dos dados
        for (Dice dados : dice) {
            side.add(dados.getRaffledSide());
        }
        List<Clan> clan = new ArrayList<>();
        BuilderClanChosokabe cl = new BuilderClanChosokabe();
        Director dir = new Director(cl);
        dir.construir();
        
        clan.add(dir.getClan());
        
        for(Clan c: clan) {
            if(!c.isIsConquered()) {
                for(Castle ct : c.getCastles()) {
                    System.out.println(ct.getCastleName());
                }
            }
        }
    }

    public void removeDice(int position) {
        this.dice.remove(position);
    }
    
    public List<Dice> getDados() {
        return dice;
    }

    public void setDados(List<Dice> dados) {
        this.dice = dados;
    }
    
}
