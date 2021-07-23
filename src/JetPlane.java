public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
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
            writer.add_text("JetPlane#"+ getName() + "(" + getId() + "): I'm super hot-boy!");
        } else if (weather.equals("RAIN")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            writer.add_text("JetPlane#"+ getName() + "(" + getId() + "):  It's raining. Better watch out for lightings.");
        } else if (weather.equals("FOG")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
            writer.add_text("JetPlane#"+ getName() + "(" + getId() + "): Damn Rikimaru... Fog !!!");
        } else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
            writer.add_text("JetPlane#"+ getName() + "(" + getId() + "):  OMG! Winter is coming!");
        }
        if (this.coordinates.getHeight() <= 0) {
            writer.add_text("Tower says: JetPlane#" + getName() + "("+ getId() +") landing");
            writer.add_text("Tower says: JetPlane#" + getName() + "("+ getId() +") unregistered from weather tower.");
            weatherTower.unregister(this);
            earth_plane = true;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        FileWriters writer = FileWriters.getInstance();
        weatherTower.register(this);
        writer.add_text("Tower says: JetPlane#" + getName() + "("+ getId() +") registered to weather tower.");
    }
}
