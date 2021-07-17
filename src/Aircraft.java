public class Aircraft {
    private long id;
    private String name;
    Coordinates coordinates;

    Aircraft(String name, Coordinates coordinates) {
        this.id = AirIdGenerator.getInstance().generateId();
    }

    long idCounter() {
        return id;
    }

    long nextId() {
        return (id + 1);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
