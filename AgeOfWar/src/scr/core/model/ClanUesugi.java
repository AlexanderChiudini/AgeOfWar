package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanUesugi implements Clan {

    private List<Castle> castles = new ArrayList<>();
    
    private static ClanUesugi instance;

    public static synchronized ClanUesugi getInstance() {
        if(instance == null) {
            instance = new ClanUesugi();
        }
        return instance;
    }
    
    @Override
    public String getClanDescription() {
        return "Uesugi";
    }

    @Override
    public ImageIcon getClanIcons() {
        // aqui deve ser criado o ícone do clã (parte de traz da carta)
        return null;
    }

    @Override
    public int getNumberCards() {
        return 2;
    }

    @Override
    public int getClanPoints() {
        return 8;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleKitanosho(3, "Kitanosho", castle.getBattleLine(), "",castle.getCastleFigure());
        castles.add(castle);
        castle = new CastleKasugayama(4, "Kasugayama", castle.getBattleLine(), "",castle.getCastleFigure());
        castles.add(castle);
        return castles;
    }
}
