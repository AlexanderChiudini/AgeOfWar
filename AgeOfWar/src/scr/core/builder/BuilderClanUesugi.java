package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanUesugi extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles;
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Uesugi");
        clan.setPoints(8);
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

        List<String> archery = new ArrayList<>();
        archery.add("archery");

        castle.setCastleName("Kitanosho");
        castle.setCastlePoints(3);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addDaimyo(0, daimyo);
        castle.addArchery(1, archery);
        castle.addCavalry(1, cavalry);
        for (int i=0; i<=5; i++) {
            castle.addSword(2, sword);
        }

        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Kasukayama");
        castle.setCastlePoints(4);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addArchery(0, archery);
        castle.addArchery(0, archery);
        castle.addCavalry(1, cavalry);
        castle.addCavalry(1, cavalry);
    }

    @Override
    public Clan getClan() {
        return this.clan;
    }
}
