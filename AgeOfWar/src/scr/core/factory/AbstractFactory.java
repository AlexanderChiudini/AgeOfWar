package scr.core.factory;

import scr.core.model.Castle;
import scr.core.model.Clan;

public abstract class AbstractFactory {
    public abstract Castle createCastle();
    public abstract Clan createClan();
}
