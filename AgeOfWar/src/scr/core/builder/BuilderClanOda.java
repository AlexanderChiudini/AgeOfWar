package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanOda extends AbstractBuilderClan{

    private Clan clan;
    private List<Castle> castles;

    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Oda");
        clan.setPoints(10);
        ImageIcon icon = new ImageIcon("image/cartas/cla_oda/carta_oda_cla.png"); //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }

    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Azuchi");
        castle.setCastlePoints(3);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "archery");
        castle.addList(1, "cavalry");
        castle.addList(1, "cavalry");
        for (int i=0; i<=4; i++) {
            castle.addList(2, "sword");
        }
        
        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Gifu");
        castle.setCastlePoints(1);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "cavalry");
        castle.addList(2, "cavalry");
        
        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Matsumoto");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "archery");
        castle.addList(1, "archery");
        for (int i=0; i<=6; i++) {
            castle.addList(2, "sword");
        }
        
        castle = new ClassicCastle().getInstance().createCastle();
        
        castle.setCastleName("Odani");
        castle.setCastlePoints(1);
        castle.setDaimyoBattleLine("especialDaimyo");
        for (int i=0; i<=9; i++) {
            castle.addList(0, "sword");
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