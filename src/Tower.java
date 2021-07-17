import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unregisters = new ArrayList<>();

    void register(Flyable flyable) {
        observers.add(flyable);
    }

    void unregister(Flyable flyable) {
        unregisters.add(flyable);
    }

    void conditionsChanged() {

    }
}
