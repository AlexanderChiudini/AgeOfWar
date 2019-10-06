package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanShimazu;

public class ShimazuClanFactory extends AbstractClanFactory {

    private static ShimazuClanFactory instance;
    
    public static synchronized ShimazuClanFactory getInstance() {
        if(instance == null) {
            instance = new ShimazuClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanShimazu();
    }
}
