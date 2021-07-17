public class JetPlane extends Aircraft implements Flyable {

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("JetPlane " + name + " created!");
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
