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
        clan.setIsConquered(false);
        clan.setPoints(8);
        ImageIcon icon = null; //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().getInstance().createCastle();

        castle.setCastleName("Kitanosho");
        castle.setCastlePoints(3);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "archery");
        castle.addList(1, "cavalry");
        for (int i=0; i<=5; i++) {
            castle.addList(2, "sword");
        }

        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Kasukayama");
        castle.setCastlePoints(4);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "archery");
        castle.addList(0, "archery");
        castle.addList(1, "cavalry");
        castle.addList(1, "cavalry");
    }

    @Override
    public Clan getClan() {
        return this.clan;
    }
    
    @Override
    public Castle getCastle(int position) {
        return this.castles.get(position);
    }
    
    @Override
    public Castle getCastle() {
        return (Castle) this.castles;
    }
}
