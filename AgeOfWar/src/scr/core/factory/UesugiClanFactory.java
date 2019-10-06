package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanUesugi;

public class UesugiClanFactory extends AbstractClanFactory {

    private static UesugiClanFactory instance;
    
    public static synchronized UesugiClanFactory getInstance() {
        if(instance == null) {
            instance = new UesugiClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanUesugi();
    }
}
