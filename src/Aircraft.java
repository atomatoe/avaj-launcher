public class Aircraft {
    private long id;
    private String name;
    Coordinates coordinates;
    boolean earth_plane;

    Aircraft(String name, Coordinates coordinates) {
        this.id = AirIdGenerator.getInstance().generateId();
        this.coordinates = coordinates;
        this.name = name;
        this.earth_plane = false;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
