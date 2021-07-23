public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(String[] weathers) {
        if(earth_plane == true)
            return;
        String weather = weatherTower.getWeather(coordinates, weathers);
        if (weather.equals("SUN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            System.out.println("Baloon#"+ getName() + "(" + getId() + "): Let's enjoy the good weather and take some pics.");
        } else if (weather.equals("RAIN")) {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            System.out.println("Baloon#"+ getName() + "(" + getId() + "): Damn you rain! You messed up my baloon.");
        } else if (weather.equals("FOG")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() - 3);
            System.out.println("Baloon#"+ getName() + "(" + getId() + "): Damn you fog! I see nothing");
        } else if (weather.equals("SNOW")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() - 15);
            System.out.println("Baloon#"+ getName() + "(" + getId() + "): It's snowing. We're gonna crash.");
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Tower says: Baloon#" + getName() + "("+ getId() +") landing");
            System.out.println("Tower says: Baloon#" + getName() + "("+ getId() +") unregistered from weather tower.");
            weatherTower.unregister(this);
            earth_plane = true;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + getName() + "("+ getId() +") registered to weather tower.");
    }
}
