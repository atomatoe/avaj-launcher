import java.io.FileReader;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        String file = "";
        int count_start = 0;
        ArrayList<Flyable> flyableArrayList = new ArrayList<Flyable>();
        AircraftFactory aircraftFactory = new AircraftFactory();
        try(FileReader reader = new FileReader("scenario.txt"))
        {
            int c;
            while((c = reader.read()) != -1) {
                file += (char)c;
            }
            String[] parts = file.split("\n");
            count_start = Integer.parseInt(parts[0]);
            WeatherTower weatherTower = new WeatherTower();
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
    }
}
