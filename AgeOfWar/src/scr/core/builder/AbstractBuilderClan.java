package scr.core.builder;

import scr.core.model.Castle;
import scr.core.model.Clan;

public abstract class AbstractBuilderClan {
    
    public abstract void reset();

    public abstract Clan getClan();
    
    public abstract void createClan();
    
    public abstract void createCastles();
    
    public abstract Castle getCastle(int position);
    
    public abstract Castle getCastle();
}
