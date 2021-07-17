public class Helicopter extends Aircraft implements Flyable {

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("Helicopter " + name + " created!");
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
