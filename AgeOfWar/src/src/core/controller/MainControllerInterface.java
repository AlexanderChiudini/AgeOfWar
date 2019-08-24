package src.core.controller;

public interface MainControllerInterface {

    void attach(MainControllerObserver observer);

    void detach(MainControllerObserver observer);

}
