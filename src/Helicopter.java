public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(String[] weathers) {
        if(earth_plane == true)
            return;
        String weather = weatherTower.getWeather(coordinates, weathers);
        FileWriters writer = FileWriters.getInstance();
        if (weather.equals("SUN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            writer.add_text("Helicopter#"+ getName() + "(" + getId() + "): This is hot.");
        } else if (weather.equals("RAIN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            writer.add_text("Helicopter#"+ getName() + "(" + getId() + "): Gyrocopter! Gyrocopter! Rain!.");
        } else if (weather.equals("FOG")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            writer.add_text("Helicopter#"+ getName() + "(" + getId() + "): SHIT... Fog...");
        } else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            writer.add_text("Helicopter#"+ getName() + "(" + getId() + "):  My rotor is going to freeze!");
        }
        if (this.coordinates.getHeight() <= 0) {
            writer.add_text("Tower says: Helicopter#" + getName() + "("+ getId() +") landing");
            writer.add_text("Tower says: Helicopter#" + getName() + "("+ getId() +") unregistered from weather tower.");
            weatherTower.unregister(this);
            earth_plane = true;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWriters writer = FileWriters.getInstance();
        weatherTower.register(this);
        writer.add_text("Tower says: Helicopter#" + getName() + "("+ getId() +") registered to weather tower.");

    }
}
