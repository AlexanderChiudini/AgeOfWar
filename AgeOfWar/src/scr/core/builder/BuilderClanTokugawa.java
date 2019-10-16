package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanTokugawa extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles = new ArrayList<>();
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Tokugawa");
        clan.setIsConquered(false);
        clan.setPoints(8);
        ImageIcon icon = null; //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().createCastle();
        List<ImageIcon> imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_inuyama.png"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_cla.png"));
        
        castle.setCastleName("Inuyama");
        castle.setCastlePoints(1);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "archery");
        castle.addList(1, "archery");
        castle.setCastleFigures(imageList);
        
        this.castles.add(castle);
        
        if (!imageList.isEmpty()) {
            imageList.clear();
        }
        
        castle = new ClassicCastle().createCastle();
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_kiyosu"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_castelo"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_cla"));
        
        castle.setCastleName("Kiyosu");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "archery");
        castle.addList(2, "cavalry");
        for (int i=0; i<=2; i++) {
            castle.addList(3, "sword");
        }
        castle.setCastleFigures(imageList);
        
        this.castles.add(castle);
        
        if (!imageList.isEmpty()) {
            imageList.clear();
        }
        
        castle = new ClassicCastle().createCastle();
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_edo"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_castelo"));
        imageList.add(new ImageIcon("image/cartas/cla_tokugawa/carta_tokugawa_cla"));
        
        castle.setCastleName("Edo");
        castle.setCastlePoints(3);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "archery");
        castle.addList(0, "cavalry");
        castle.addList(1, "archery");
        castle.addList(1, "cavalry");
        for (int i=0; i<=2; i++) {
            castle.addList(2, "sword");
        }
        castle.setCastleFigures(imageList);
        
        this.castles.add(castle);
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
