package core.builder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import core.factory.AbstractFactoryCastle;
import core.factory.ClassicCastle;
import core.model.Castle;
import core.model.Clan;
import core.visitor.Visitor;

public class BuilderClanChosokabe extends AbstractBuilderClan {

    private Clan clan;
    private List<Castle> castles = new ArrayList<>();

    private AbstractFactoryCastle createCastle;

    public BuilderClanChosokabe() {
        createCastle = new ClassicCastle();
    }

    @Override
    public void reset() {
        this.clan = new Clan();
    }

    @Override
    public void createClan() {
        clan.setName("Chosokabe");
        clan.setIsConquered(false);
        clan.setPoints(4);
        ImageIcon icon = null; //definir a imagem do cla
        clan.setIcon(icon);
        clan.setCastles(castles);
    }

    @Override
    public void createCastles() {
        Castle castle = createCastle.createCastle();
        List<ImageIcon> imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_marugame.png"));
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_cla.png"));

        castle.setCastleName("Marugame");
        castle.setCastlePoints(1);
        castle.addList(0, "daimyo");
        castle.addList(0, "daimyo");
        castle.addList(1, "cavalry");
        castle.setCastleFigures(imageList);

        this.castles.add(castle);

        castle = createCastle.createCastle();
        imageList = new ArrayList<>();
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_matsuyama.png"));
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_castelo.png"));
        imageList.add(new ImageIcon("image/cartas/cla_chosokabe/carta_chosokabe_cla.png"));

        castle.setCastleName("Matsuyama");
        castle.setCastlePoints(2);
        castle.setDaimyoBattleLine("especialDaimyo");
        castle.addList(0, "daimyo");
        for (int i = 0; i <= 3; i++) {
            castle.addList(1, "sword");
        }
        for (int i = 0; i <= 3; i++) {
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

    @Override
    public int sizeCastleList() {
        return this.castles.size();
    }
    
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }
}
