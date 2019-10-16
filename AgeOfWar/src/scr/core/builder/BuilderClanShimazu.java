package scr.core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import scr.core.factory.ClassicCastle;
import scr.core.model.Castle;
import scr.core.model.Clan;

public class BuilderClanShimazu extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles = new ArrayList<>();
    
    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Shimazu");
        clan.setIsConquered(false);
        clan.setPoints(3);
        ImageIcon icon = null; //definir a imagem do clã
        clan.setIcon(icon);
        clan.setCastles(castles);
    }
    
    @Override
    public void createCastles() {
        Castle castle = new ClassicCastle().createCastle();

        castle.setCastleName("Kumamoto");
        castle.setCastlePoints(3);
        castle.addList(0, "daimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "archery");
        castle.addList(2, "cavalry");
        for (int i=0; i<=3; i++) {
            castle.addList(3, "sword");
        }
        List<ImageIcon> imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_shimazu/carta_shimazu_kumamoto.png"));
        imageList.add(new ImageIcon("image/cartas/cla_shimazu/carta_shimazu_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_shimazu/carta_shimazu_cla.png"));
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
