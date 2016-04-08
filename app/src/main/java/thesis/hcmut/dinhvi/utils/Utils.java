package thesis.hcmut.dinhvi.utils;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.model.Wifi;

/**
 * Created by huylv on 06-Apr-16.
 */
public class Utils {
    public static ArrayList<Wifi> filteredWifiList = new ArrayList<>();
    public static ArrayList<Wifi> savedWifiList = new ArrayList<>();

    public static boolean CHOOSING;
    public static final double d0 = 1;
    //hang so n
    public static final double n = 3.61;
    //cuong do tai khoang cach d0
    public static final double level0 = -33;
    public static final String SP_KEY = "savedWifiSP";
    public static String SP_KEY_SAVED_WIFI = "savedWifiKey";

    public static double calculateDistanceFromLevel(int level){
        return d0*Math.pow(10,(level0 - level)/(10*n));
    }
}
