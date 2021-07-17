public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        if (latitude < 0)
            this.latitude = 0;
        else
            this.latitude = latitude;
        if (longitude < 0)
            this.longitude = 0;
        else
            this.longitude = longitude;
        if (height > 100)
            this.height = 100;
        else
            this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
