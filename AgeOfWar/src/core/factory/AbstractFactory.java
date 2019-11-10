package core.factory;

import core.model.Castle;
import core.model.Clan;

public abstract class AbstractFactory {
    public abstract Castle createCastle();
    public abstract Clan createClan();
}
