package scr.core.factory;

import scr.core.model.Clan;
import scr.core.model.ClanTokugawa;

public class TokugawaClanFactory extends AbstractClanFactory {

    private static TokugawaClanFactory instance;
    
    public static synchronized TokugawaClanFactory getInstance() {
        if(instance == null) {
            instance = new TokugawaClanFactory();
        }
        return instance;
    }
    
    @Override
    public Clan CreateClan() {
        return new ClanTokugawa();
    }
}
