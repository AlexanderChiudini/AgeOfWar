package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanMori implements Clan {

    private List<Castle> castles = new ArrayList<>();
    
    private static ClanMori instance;

    public static synchronized ClanMori getInstance() {
        if(instance == null) {
            instance = new ClanMori();
        }
        return instance;
    }
    
    @Override
    public String getClanDescription() {
        return "Mori";
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
        return 5;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleTakahashi(2, "Takahashi", castle.getBattleLine(), "");
        castles.add(castle);
        castle = new CastleGassantoda(2, "Gassantoda", castle.getBattleLine(), "");
        castles.add(castle);
        return castles;
    }
}
