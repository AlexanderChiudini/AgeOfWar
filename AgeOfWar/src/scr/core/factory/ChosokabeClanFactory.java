package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanChosokabe;

public class ChosokabeClanFactory extends AbstractClanFactory {

    private static ChosokabeClanFactory instance;
    
    public static synchronized ChosokabeClanFactory getInstance() {
        if(instance == null) {
            instance = new ChosokabeClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanChosokabe();
    }
}
