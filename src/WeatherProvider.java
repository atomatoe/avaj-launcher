
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
        else if(coordinates.getHeight() > 20 && coordinates.getHeight() <= 50)
            return(weathers[1]);
        else if(coordinates.getHeight() > 50 && coordinates.getHeight() <= 90)
            return(weathers[2]);
        else if(coordinates.getHeight() > 90)
            return(weathers[3]);
        return "ERROR";
    }
}
