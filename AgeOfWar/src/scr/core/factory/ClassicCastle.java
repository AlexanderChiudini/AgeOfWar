package scr.core.factory;

import scr.core.model.Castle;

public class ClassicCastle extends AbstractFactoryCastle {

    private static ClassicCastle instance;

    public static synchronized ClassicCastle getInstance() {
        if (instance == null) {
            instance = new ClassicCastle();
        }
        return instance;
    }

    @Override
    public Castle createCastle() {
        return new Castle();
    }
}
