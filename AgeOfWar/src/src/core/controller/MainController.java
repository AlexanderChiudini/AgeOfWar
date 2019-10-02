package src.core.controller;

import java.util.ArrayList;
import java.util.List;

public class MainController implements MainControllerInterface {

    private static MainController instance;
    private List<MainControllerObserver> observers;
    private String player1;
    private String player2;

    public static MainControllerInterface getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    private MainController() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(MainControllerObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(MainControllerObserver observer) {
        this.observers.remove(observer);
    }

}
