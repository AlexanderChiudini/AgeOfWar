package core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import core.factory.ClassicCastle;
import core.model.Castle;
import core.model.Clan;
import core.visitor.Visitor;

public class BuilderClanUesugi extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles = new ArrayList<>();
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Uesugi");
        clan.setIsConquered(false);
        clan.setPoints(8);
        ImageIcon icon = null; //definir a imagem do cla
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().createCastle();
        List<ImageIcon> imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_kitanosho.png"));
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_cla.png"));

        castle.setCastleName("Kitanosho");
        castle.setCastlePoints(3);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "archery");
        castle.addList(1, "cavalry");
        for (int i=0; i<=5; i++) {
            castle.addList(2, "sword");
        }
        castle.setCastleFigures(imageList);
        
        this.castles.add(castle);
        this.clan.getCastles().add(castle);
        
        castle = new ClassicCastle().createCastle();
        imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_kasugayama.png"));
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_uesugi/carta_uesugi_cla.png"));
        
        castle.setCastleName("Kasugayama");
        castle.setCastlePoints(4);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "archery");
        castle.addList(0, "archery");
        castle.addList(1, "cavalry");
        castle.addList(1, "cavalry");
        castle.setCastleFigures(imageList);
        
        this.castles.add(castle);
        this.clan.getCastles().add(castle);
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
    
    @Override
    public int sizeCastleList() {
        return this.castles.size();
    }
    
//    public void accept(Visitor visitor) throws Exception {
//        visitor.visit(this);
//    }
}
