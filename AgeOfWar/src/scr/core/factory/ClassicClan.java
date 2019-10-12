package scr.core.factory;

import scr.core.model.Clan;

public class ClassicClan extends AbstractFactoryClan {

    private static ClassicClan instance;

    public static synchronized ClassicClan getInstance() {
        if (instance == null) {
            instance = new ClassicClan();
        }
        return instance;
    }
    
    @Override
    public Clan createClan() {
        return new Clan();
    }
}
