package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanShimazu implements Clan {

    private List<Castle> castles = new ArrayList<>();
    
    private static ClanShimazu instance;

    public static synchronized ClanShimazu getInstance() {
        if(instance == null) {
            instance = new ClanShimazu();
        }
        return instance;
    }
    
    @Override
    public String getClanDescription() {
        return "Shimazu";
    }

    @Override
    public ImageIcon getClanIcons() {
        // aqui deve ser criado o ícone do clã (parte de traz da carta)
        return null;
    }

    @Override
    public int getNumberCards() {
        return 1;
    }

    @Override
    public int getClanPoints() {
        return 3;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleKumamoto(3, "Kumamoto", castle.getBattleLine(), "",castle.getCastleFigure());
        castles.add(castle);
        return castles;
    }
}
