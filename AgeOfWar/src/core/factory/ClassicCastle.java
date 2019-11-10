package core.factory;

import core.model.Castle;

public class ClassicCastle extends AbstractFactoryCastle {

    private static ClassicCastle instance;

    @Override
    public Castle createCastle() {
        return new Castle();
    }
}
