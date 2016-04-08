package thesis.hcmut.dinhvi;

/**
 * Created by huylv on 05-Apr-16.
 */

import java.util.Comparator;

/**
 * Created by Thien on 10/26/2015.
 */
public class MyWifi implements Comparator<MyWifi> {
    public String ssid;
    public int RSS;
    public double x;
    public double y;
    public double z;
    public MyWifi() {
    }

    public MyWifi(String ssid, int RSS, double x, double y, double z) {
        this.ssid = ssid;
        this.RSS = RSS;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int setRSS(int RSS) {
        return RSS;
    }

    public int compare(MyWifi m1, MyWifi m2) {
        return m2.RSS - m1.RSS;
    }
}