package scr.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ClanTokugawa implements Clan {

    private static ClanTokugawa instance;
    
    private List<Castle> castles = new ArrayList<>();

    public static synchronized ClanTokugawa getInstance() {
        if(instance == null) {
            instance = new ClanTokugawa();
        }
        return instance;
    }

    @Override
    public String getClanDescription() {
        return "Tokugawa";
    }

    @Override
    public ImageIcon getClanIcons() {
        // aqui deve ser criado o ícone do clã (parte de traz da carta)
        return null;
    }

    @Override
    public int getNumberCards() {
        return 3;
    }

    @Override
    public int getClanPoints() {
        return 8;
    }

    @Override
    public List<Castle> getCastle() {
        Castle castle = null;
        castle = new CastleInuyama(1, "Inuyama", castle.getBattleLine(), "");
        castles.add(castle);
        castle = new CastleKiyosu(2, "Kiyosu", castle.getBattleLine(), "");
        castles.add(castle);
        castle = new CastleEdo(3, "Kiyosu", castle.getBattleLine(), "");
        castles.add(castle);
        return castles;
    }
}
