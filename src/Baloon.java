public class Baloon extends Aircraft implements Flyable {
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("Baloon " + name + " created!");
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
