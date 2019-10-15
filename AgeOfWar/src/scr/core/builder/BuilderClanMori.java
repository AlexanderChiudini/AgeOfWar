package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanMori extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles;
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Mori");
        clan.setIsConquered(false);
        clan.setPoints(5);
        ImageIcon icon = null; //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().getInstance().createCastle();

        castle.setCastleName("Takahashi");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "cavalry");
        castle.addList(0, "cavalry");
        for (int i=0; i<=4; i++) {
            castle.addList(1, "sword");
        }
        castle.addList(2, "sword");
        castle.addList(2, "sword");
        
        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Gassantoda");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        for (int i=0; i<=7; i++) {
            castle.addList(1, "sword");
        }
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
