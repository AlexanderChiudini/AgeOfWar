package scr.core.factory;

import scr.core.model.Clan;

public class ClassicClan extends AbstractFactoryClan {

    private static ClassicClan instance;
    
    @Override
    public Clan createClan() {
        return new Clan();
    }
}
