
public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather;

    WeatherProvider() { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates, String[] weathers) {
        if(coordinates.getHeight() > 0 && coordinates.getHeight() <= 20)
            return(weathers[0]);
        else if(coordinates.getHeight() > 20 && coordinates.getHeight() <= 45)
            return(weathers[1]);
        else if(coordinates.getHeight() > 45 && coordinates.getHeight() <= 80)
            return(weathers[2]);
        else if(coordinates.getHeight() > 80)
            return(weathers[3]);
        return "ERROR";
    }
}
