package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanShimazu extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles;
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Shimazu");
        clan.setPoints(3);
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

        castle.setCastleName("Kumamoto");
        castle.setCastlePoints(3);
        castle.addDaimyo(0, daimyo);
        castle.addDaimyo(0, daimyo);
        castle.addCavalry(1, archery);
        castle.addCavalry(2, cavalry);
        for (int i=0; i<=3; i++) {
            castle.addSword(3, sword);
        }
    }

    @Override
    public Clan getClan() {
        return this.clan;
    }
}
