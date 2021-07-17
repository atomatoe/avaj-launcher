import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();

    WeatherProvider() { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int weather = 1 + (int) (Math.random() * 4);
        if(weather == 1)
            return("SUN");
        else if(weather == 2)
            return("RAIN");
        else if(weather == 3)
            return("FOG");
        else if(weather == 4)
            return("SNOW");
        return null;
    }
}
