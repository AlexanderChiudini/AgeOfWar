package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanOda;

public class OdaClanFactory extends AbstractClanFactory {

    private static OdaClanFactory instance;
    
    public static synchronized OdaClanFactory getInstance() {
        if(instance == null) {
            instance = new OdaClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanOda();
    }
}