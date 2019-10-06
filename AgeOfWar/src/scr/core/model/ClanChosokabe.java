package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanChosokabe implements Clan {

    private List<Castle> castles = new ArrayList<>();
    
    private static ClanChosokabe instance;
    
    public static synchronized ClanChosokabe getInstance() {
        if(instance == null) {
            instance = new ClanChosokabe();
        }
        return instance;
    }
    
    @Override
    public String getClanDescription() {
        return "Chosokabe";
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
        return 4;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleMarugame(1, "Marugame", castle.getBattleLine(), "");
        castles.add(castle);
        castle = new CastleMatsuyama(2, "Matsuyama", castle.getBattleLine(), "");
        castles.add(castle);
        return castles;
    }
}
