public class AircraftFactory {

    Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (longitude > -1 && latitude > -1 && height > -1) {
            if(height > 100) {
                height = 100;
            }
            if (type.equals("Baloon"))
                return (new Baloon(name, new Coordinates(longitude, latitude, height)));
            else if (type.equals("Helicopter"))
                return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
            else if (type.equals("JetPlane"))
                return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
            return null;
        } else
            return null;
    }
}
