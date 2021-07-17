public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        if(earth_plane == true)
            return;
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            System.out.println("Helicopter#"+ getName() + "(" + getId() + "): This is hot.");
        } else if (weather.equals("RAIN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            System.out.println("Helicopter#"+ getName() + "(" + getId() + "): Gyrocopter! Gyrocopter! Rain!.");
        } else if (weather.equals("FOG")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            System.out.println("Helicopter#"+ getName() + "(" + getId() + "): SHIT... Fog...");
        } else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            System.out.println("Helicopter#"+ getName() + "(" + getId() + "):  My rotor is going to freeze!");
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Tower says: Helicopter#" + getName() + "("+ getId() +") landing");
            System.out.println("Tower says: Helicopter#" + getName() + "("+ getId() +") unregistered from weather tower.");
            weatherTower.unregister(this);
            earth_plane = true;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Helicopter#" + getName() + "("+ getId() +") registered to weather tower.");

    }
}
