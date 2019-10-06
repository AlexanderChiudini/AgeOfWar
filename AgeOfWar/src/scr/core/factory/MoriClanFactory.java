package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanMori;

public class MoriClanFactory extends AbstractClanFactory {

    private static MoriClanFactory instance;
    
    public static synchronized MoriClanFactory getInstance() {
        if(instance == null) {
            instance = new MoriClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanMori();
    }
}
