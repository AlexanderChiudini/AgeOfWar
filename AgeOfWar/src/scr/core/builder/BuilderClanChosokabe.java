package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanChosokabe extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles;
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Chosokabe");
        clan.setPoints(4);
        ImageIcon icon = null; //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().getInstance().createCastle();
        
        List<String> cavalry = new ArrayList<>();
        cavalry.add("cavalry");

        List<String> daimyo = new ArrayList<>();
        daimyo.add("daimyo");

        List<String> sword = new ArrayList<>();
        sword.add("infantry");

        castle.setCastleName("Marugame");
        castle.setCastlePoints(1);
        castle.addDaimyo(0, daimyo);
        castle.addDaimyo(0, daimyo);
        castle.addCavalry(1, cavalry);
        
        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Matsuyama");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addDaimyo(2, daimyo);
        for (int i=0; i<=3; i++) {
            castle.addSword(1, sword);
        }
        for (int i=0; i<=3; i++) {
            castle.addSword(2, sword);
        }
    }

    @Override
    public Clan getClan() {
        return this.clan;
    }
    
    @Override
    public Castle getCastle(int posicao) {
        return this.castles.get(posicao);
    }
}
