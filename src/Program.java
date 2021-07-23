import java.io.FileReader;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        String file = "";
        int count_start = 0;
        ArrayList<Flyable> flyableArrayList = new ArrayList<Flyable>();
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        try(FileReader reader = new FileReader("scenario.txt"))
        {
            int c;
            while((c = reader.read()) != -1) {
                file += (char)c;
            }
            String[] parts = file.split("\n");
            if(Integer.parseInt(parts[0]) == 0) {
                System.out.println("Error count simulations!");
                System.exit(-1);
            }
            count_start = Integer.parseInt(parts[0]);
            for(int i = 1; i != parts.length; i++) {
                String[] fly = parts[i].split(" ");
                if(fly.length != 5) {
                    System.out.println("Error fly machine params in file read!");
                    System.exit(-1);
                }
                Flyable fly_machine = aircraftFactory.newAircraft(fly[0], fly[1], Integer.parseInt(fly[2]), Integer.parseInt(fly[3]), Integer.parseInt(fly[4]));
                if(fly_machine == null) {
                    System.out.println("Error!\n" +
                            "Invalid type or characteristics in read file! Good type: Baloon, JetPlane, Helicopter!" +
                            "\nCharacteristics: coordinates are positive numbers. The height is in the 0-100 range.");
                    System.exit(-1);
                }
                fly_machine.registerTower(weatherTower);
                flyableArrayList.add(fly_machine);
            }
        } catch(Exception e) {
            System.out.println("Error file read!");
            System.exit(-1);
        }
        for(int i = 0; i != count_start; i++){
            String[] weather = generateWeather();
            for(int it = 0; it != flyableArrayList.size(); it++) {
                flyableArrayList.get(it).updateConditions(weather);
            }
        }
    }

    private static String[] generateWeather() {
        String[] weathers = new String[4];
        Integer[] weather = {(1 + (int) (Math.random() * 4)), (1 + (int) (Math.random() * 4)),
                (1 + (int) (Math.random() * 4)), (1 + (int) (Math.random() * 4))};
        for(int i = 0; i != 4; i++) {
            if(weather[i] == 1)
                weathers[i] = "SUN";
            else if(weather[i] == 2)
                weathers[i] = "RAIN";
            else if(weather[i] == 3)
                weathers[i] = "FOG";
            else if(weather[i] == 4)
                weathers[i] = "SNOW";
        }
        for(int i = 3; i != -1; i--) {
            if(weathers[i].equals("FOG"))
                System.out.println("\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B");
            else if(weathers[i].equals("SNOW"))
                System.out.println("❄️❄️❄️❄️️❄️❄️❄️❄️️");
            else if(weathers[i].equals("RAIN"))
                System.out.println("\uD83C\uDF27️\uD83C\uDF27️\uD83C\uDF27️\uD83C\uDF27\uD83C\uDF27️\uD83C\uDF27️\uD83C\uDF27️\uD83C\uDF27️");
            else if(weathers[i].equals("SUN"))
                System.out.println("☀️☀️☀️☀️☀️☀️☀️☀️️");
        }
        return weathers;
    }
}
