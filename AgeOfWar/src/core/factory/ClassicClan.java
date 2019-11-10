package core.factory;

import core.model.Clan;

public class ClassicClan extends AbstractFactoryClan {

    private static ClassicClan instance;
    
    @Override
    public Clan createClan() {
        return new Clan();
    }
}
