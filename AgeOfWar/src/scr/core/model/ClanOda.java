package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanOda implements Clan {

    private List<Castle> castles = new ArrayList<>();
    
    private static ClanOda instance;
    
    public static synchronized ClanOda getInstance() {
        if(instance == null) {
            instance = new ClanOda();
        }
        return instance;
    }
    
    @Override
    public String getClanDescription() {
        return "Oda";
    }

    @Override
    public ImageIcon getClanIcons() {
        // aqui deve ser criado o ícone do clã (parte de traz da carta)
        return null;
    }

    @Override
    public int getNumberCards() {
        return 4;
    }

    @Override
    public int getClanPoints() {
        return 10;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleAzuchi(3, "Azuchi", castle.getBattleLine(), "", castle.getCastleFigure());
        castles.add(castle);
        castle = new CastleGifu(1, "Gifu", castle.getBattleLine(), "", castle.getCastleFigure());
        castles.add(castle);
        castle = new CastleMatsumoto(2, "Matsumoto", castle.getBattleLine(), "", castle.getCastleFigure());
        castles.add(castle);
        castle = new CastleOdani(1, "Odani", castle.getBattleLine(), "", castle.getCastleFigure());
        castles.add(castle);
        return castles;
    }
}
