package core.builder;

import core.model.Clan;

public class Director {
    
    private AbstractBuilderClan builder;
    
    public Director(AbstractBuilderClan builder) {
        this.builder = builder;
    }
    
    public void construir() {
        builder.reset();
        builder.createCastles();
        builder.createClan();
    }
    
    public Clan getClan() {
        return builder.getClan();
    }
}
