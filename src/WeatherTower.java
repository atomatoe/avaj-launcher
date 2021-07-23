public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates, String[] weathers) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates, weathers));
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
