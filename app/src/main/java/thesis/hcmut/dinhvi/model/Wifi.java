package thesis.hcmut.dinhvi.model;

/**
 * Created by huylv on 05-Apr-16.
 */
public class Wifi {
    String SSID;
    int level;
    double distance;
    public double x;
    public double y;
    public double z;
    Wifi() {
    }

    public Wifi(String SSID, int level) {
        this.SSID = SSID;
        this.level = level;;
    }

    public Wifi(String SSID, double x, double y, double z) {
        this.SSID = SSID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Wifi{" +
                "SSID='" + SSID + '\'' +
                ", level=" + level +
                ", distance=" + distance +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public String getSSID() {
        return SSID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
