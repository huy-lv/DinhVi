//package thesis.hcmut.dinhvi;
//
//import android.os.Bundle;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.WiFi.ScanResult;
//import android.net.WiFi.WiFiManager;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class MainActivity1 extends Activity {
//    TextView txtvAP1Name, txtvAP2Name, txtvAP3Name, txtvAP4Name, txtvAP5Name, txtvAP6Name,
//            txtvAP7Name, txtvAP8Name, txtvAP9Name, txtvAP10Name, txtvAP11Name, txtvAP12Name,
//            txtvAP13Name, txtvAP14Name, txtvAP15Name;
//    TextView txtvRss1, txtvRss2, txtvRss3, txtvRss4, txtvRss5, txtvRss6, txtvRss7, txtvRss8,
//            txtvRss9, txtvRss10, txtvRss11, txtvRss12, txtvRss13, txtvRss14, txtvRss15;
//    Button btnScan, btnPositioning;
//    List<ScanResult> scans;
//    Integer i = 0;
//    List<MyWifi> myWiFiList = new ArrayList<>();
//
//
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //Access Point 1-Phong 601
//        txtvAP1Name = (TextView) findViewById(R.id.WAP1);
//        txtvRss1 = (TextView) findViewById(R.id.RSS1);
//        //Access Point 2-Phong 602
//        txtvAP2Name = (TextView) findViewById(R.id.WAP2);
//        txtvRss2 = (TextView) findViewById(R.id.RSS2);
//        //Access Point 3-Phong 603
//        txtvAP3Name = (TextView) findViewById(R.id.WAP3);
//        txtvRss3 = (TextView) findViewById(R.id.RSS3);
//        //Access Point 4-Phong 604
//        txtvAP4Name = (TextView) findViewById(R.id.WAP4);
//        txtvRss4 = (TextView) findViewById(R.id.RSS4);
//        //Access Point 5-Phong 605
//        txtvAP5Name = (TextView) findViewById(R.id.WAP5);
//        txtvRss5 = (TextView) findViewById(R.id.RSS5);
//        //Access Point 6- Phong 501
//        txtvAP6Name = (TextView) findViewById(R.id.WAP6);
//        txtvRss6 = (TextView) findViewById(R.id.RSS6);
//        //Access Point 502
//        txtvAP7Name = (TextView) findViewById(R.id.WAP7);
//        txtvRss7 = (TextView) findViewById(R.id.RSS7);
//        //Access Point 503
//        txtvAP8Name = (TextView) findViewById(R.id.WAP8);
//        txtvRss8 = (TextView) findViewById(R.id.RSS8);
//        //Access Point 504
//        txtvAP9Name = (TextView) findViewById(R.id.WAP9);
//        txtvRss9 = (TextView) findViewById(R.id.RSS9);
//        //Access Point 505
//        txtvAP10Name = (TextView) findViewById(R.id.WAP10);
//        txtvRss10 = (TextView) findViewById(R.id.RSS10);
//        //Access Point 701
//        txtvAP11Name = (TextView) findViewById(R.id.WAP11);
//        txtvRss11 = (TextView) findViewById(R.id.RSS11);
//        //Access Point 702
//        txtvAP12Name = (TextView) findViewById(R.id.WAP12);
//
//        txtvRss12 = (TextView) findViewById(R.id.RSS12);
//        //Access Point 703
//        txtvAP13Name = (TextView) findViewById(R.id.WAP13);
//        txtvRss13 = (TextView) findViewById(R.id.RSS13);
//        //Access Point 704
//        txtvAP14Name = (TextView) findViewById(R.id.WAP14);
//        txtvRss14 = (TextView) findViewById(R.id.RSS14);
//        //Access Point 505
//        txtvAP15Name = (TextView) findViewById(R.id.WAP15);
//        txtvRss15 = (TextView) findViewById(R.id.RSS15);
//        btnScan = (Button) findViewById(R.id.Calculate);
//        btnPositioning = (Button) findViewById(R.id.Positioning);
//        //WiFi 601
//        MyWifi myWiFi1 = new MyWifi();
//        myWiFi1.ssid = "Phong601";
//        myWiFi1.x = 16.2;
//        myWiFi1.y = 0.2;
//        myWiFi1.z = 3.5;
//        myWiFiList.add(myWiFi1);
//        //declare WiFi 602
//        MyWifi myWiFi2 = new MyWifi();
//        myWiFi2.ssid = "Phong602";
//        myWiFi2.x = 5.7;
//        myWiFi2.y = 0.2;
//        myWiFi2.z = 3.5;
//        myWiFiList.add(myWiFi2);
//        // declare WiFi 603
//        MyWifi myWiFi3 = new MyWifi();
//        myWiFi3.ssid = "P0603";
//        myWiFi3.x = 17.8;
//        myWiFi3.y = 11.6;
//        myWiFi3.z = 3.5;
//        myWiFiList.add(myWiFi3);
//        // declare WiFi 604
//        MyWifi myWiFi4 = new MyWifi();
//        myWiFi4.ssid = "P604";
//        myWiFi4.x = 0.2;
//        myWiFi4.y = 11.6;
//        myWiFi4.z = 3.5;
//        myWiFiList.add(myWiFi4);
//
//        // declare WiFi 605
//        MyWifi myWiFi5 = new MyWifi();
//        myWiFi5.ssid = "605";
//        myWiFi5.x = 17;
//        myWiFi5.y = 12.0;
//        myWiFi5.z = 3.5;
//        myWiFiList.add(myWiFi5);
//        // WiFi 501
//        MyWifi myWiFi6 = new MyWifi();
//        myWiFi6.ssid = "P501";
//        myWiFi6.x = 18;
//        myWiFi6.y = 0.2;
//        myWiFi6.z = 0;
//        myWiFiList.add(myWiFi6);
//        // WiFi P502
//        MyWifi myWiFi7 = new MyWifi();
//        myWiFi7.ssid = "P502";
//        myWiFi7.x = 0.2;
//        myWiFi7.y = 0.2;
//        myWiFi7.z = 0;
//        myWiFiList.add(myWiFi7);
//        // WiFi P503
//        MyWifi myWiFi8 = new MyWifi();
//        myWiFi8.ssid = "P503";
//        myWiFi8.x = 18;
//        myWiFi8.y = 11.4;
//        myWiFi8.z = 0;
//        myWiFiList.add(myWiFi8);
//        // WiFi P.504
//        MyWifi myWiFi9 = new MyWifi();
//        myWiFi9.ssid = "P.504";
//        myWiFi9.x = 0.2;
//        myWiFi9.y = 11.6;
//        myWiFi9.z = 0;
//        myWiFiList.add(myWiFi9);
//        //WiFi P.0505
//        MyWifi myWiFi10 = new MyWifi();
//        myWiFi10.ssid = "P.0505";
//        myWiFi10.x = 18;
//        myWiFi10.y = 11.8;
//
//        myWiFi10.z = 0;
//        myWiFiList.add(myWiFi10);
//        //WiFi P.701
//        MyWifi myWiFi11 = new MyWifi();
//        myWiFi11.ssid = "P701";
//        myWiFi11.x = 17;
//        myWiFi11.y = 0.2;
//        myWiFi11.z = 7;
//        myWiFiList.add(myWiFi11);
//        //WiFi P.702
//        MyWifi myWiFi12 = new MyWifi();
//        myWiFi12.ssid = "P702";
//        myWiFi12.x = 1;
//        myWiFi12.y = 0.2;
//        myWiFi12.z = 7;
//        myWiFiList.add(myWiFi12);
//        //WiFi P.703
//        MyWifi myWiFi13 = new MyWifi();
//        myWiFi13.ssid = "P703";
//        myWiFi13.x = 17;
//        myWiFi13.y = 11.6;
//        myWiFi13.z = 7;
//        myWiFiList.add(myWiFi13);
//        //WiFi P.704
//        MyWifi myWiFi14 = new MyWifi();
//        myWiFi14.ssid = "P704";
//        myWiFi14.x = 1;
//        myWiFi14.y = 11.6;
//        myWiFi14.z = 7;
//        myWiFiList.add(myWiFi14);
//        //WiFi P.705
//        MyWifi myWiFi15 = new MyWifi();
//        myWiFi15.ssid = "P0705";
//        myWiFi15.x = 17;
//        myWiFi15.y = 11.8;
//        myWiFi15.z = 7;
//        myWiFiList.add(myWiFi15);
//        btnScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                for (int b = 0; b < myWiFiList.size(); b++) {
//                    myWiFiList.get(b).RSS = 0;
//                }
//                for (i = 0; i < 15; i++) {
//                    DisplayWiFiState();
//                }
//                txtvAP1Name.setText(myWiFiList.get(0).ssid);
//                txtvRss1.setText(String.valueOf(myWiFiList.get(0).RSS) + "dBm");
//                txtvAP2Name.setText(myWiFiList.get(1).ssid);
//                txtvRss2.setText(String.valueOf(myWiFiList.get(1).RSS) + "dBm");
//                txtvAP3Name.setText(myWiFiList.get(2).ssid);
//                txtvRss3.setText(String.valueOf(myWiFiList.get(2).RSS) + "dBm");
//                txtvAP4Name.setText(myWiFiList.get(3).ssid);
//                txtvRss4.setText(String.valueOf(myWiFiList.get(3).RSS) + "dBm");
//                txtvAP5Name.setText(myWiFiList.get(4).ssid);
//                txtvRss5.setText(String.valueOf(myWiFiList.get(4).RSS) + "dBm");
//                txtvAP6Name.setText(myWiFiList.get(5).ssid);
//                txtvRss6.setText(String.valueOf(myWiFiList.get(5).RSS) + "dBm");
//                txtvAP7Name.setText(myWiFiList.get(6).ssid);
//                txtvRss7.setText(String.valueOf(myWiFiList.get(6).RSS) + "dBm");
//                txtvAP8Name.setText(myWiFiList.get(7).ssid);
//                txtvRss8.setText(String.valueOf(myWiFiList.get(7).RSS) + "dBm");
//                txtvAP9Name.setText(myWiFiList.get(8).ssid);
//                txtvRss9.setText(String.valueOf(myWiFiList.get(8).RSS) + "dBm");
//                txtvAP10Name.setText(myWiFiList.get(9).ssid);
//                txtvRss10.setText(String.valueOf(myWiFiList.get(9).RSS) + "dBm");
//                txtvAP11Name.setText(myWiFiList.get(10).ssid);
//                txtvRss11.setText(String.valueOf(myWiFiList.get(10).RSS) + "dBm");
//                txtvAP12Name.setText(myWiFiList.get(11).ssid);
//                txtvRss12.setText(String.valueOf(myWiFiList.get(11).RSS) + "dBm");
//                txtvAP13Name.setText(myWiFiList.get(12).ssid);
//                txtvRss13.setText(String.valueOf(myWiFiList.get(12).RSS) + "dBm");
//                txtvAP14Name.setText(myWiFiList.get(13).ssid);
//                txtvRss14.setText(String.valueOf(myWiFiList.get(13).RSS) + "dBm");
//                txtvAP15Name.setText(myWiFiList.get(14).ssid);
//                txtvRss15.setText(String.valueOf(myWiFiList.get(14).RSS) + "dBm");
//            }
//        });
//        btnPositioning.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Collections.sort(myWiFiList, new MyWifi());
//                List<MyWifi> newMyWifiList = new ArrayList<>();
//                for (int a = 0; a < myWiFiList.size(); a++) {
//                    if (myWiFiList.get(a).RSS < 0) {
//                        newMyWifiList.add(myWiFiList.get(a));
//                    }
//                }
//                Collections.sort(newMyWifiList, new MyWifi());
//                // Lấy những WiFi cùng tầng với giá trị lớn nhất
//                List<MyWifi> updatedWiFiList = new ArrayList<MyWifi>();
//                Double toadoZ = newMyWifiList.get(0).z;
//                for (int t = 0; t < newMyWifiList.size(); t++) {
//                    if (newMyWifiList.get(t).z == toadoZ) {
//                        updatedWiFiList.add(newMyWifiList.get(t));
//                    }
//                }
//                Collections.sort(updatedWiFiList, new MyWifi());
//                Intent mh2 = new Intent(MainActivity1.this, Calculate1.class);
//                // put values of the highest
//                mh2.putExtra("WiFiName1", updatedWiFiList.get(0).ssid.toString());
//                mh2.putExtra("Rss1", updatedWiFiList.get(0).RSS);
//                mh2.putExtra("x1", updatedWiFiList.get(0).x);
//                mh2.putExtra("y1", updatedWiFiList.get(0).y);
//                mh2.putExtra("z1", updatedWiFiList.get(0).z);
//
//                //put values of the  second
//                mh2.putExtra("WiFiName2", newMyWifiList.get(1).ssid.toString());
//                mh2.putExtra("Rss2", updatedWiFiList.get(1).RSS);
//                mh2.putExtra("x2", updatedWiFiList.get(1).x);
//                mh2.putExtra("y2", updatedWiFiList.get(1).y);
//                mh2.putExtra("z2", updatedWiFiList.get(1).z);
//                //put values of the third
//                mh2.putExtra("WiFiName3", updatedWiFiList.get(2).ssid.toString());
//                mh2.putExtra("Rss3", updatedWiFiList.get(2).RSS);
//                mh2.putExtra("x3", updatedWiFiList.get(2).x);
//                mh2.putExtra("y3", updatedWiFiList.get(2).y);
//                mh2.putExtra("z3", updatedWiFiList.get(2).z);
//                startActivity(mh2);
//            }
//        });
//        this.registerReceiver(this.myWiFiReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//    }
//
//    private BroadcastReceiver myWiFiReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context arg0, Intent arg1) {
//            // TODO Auto-generated method stub
//            NetworkInfo networkInfo = (NetworkInfo) arg1.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
//            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
//                DisplayWiFiState();
//            }
//        }
//    };
//
//    private void DisplayWiFiState() {
//        ConnectivityManager myConnManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo myNetworkInfo = myConnManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        WiFiManager myWiFiManager = (WiFiManager) getSystemService(Context.WIFI_SERVICE);
//        if (myWiFiManager.isWiFiEnabled()) {
//            if (myWiFiManager.startScan()) {
//                // List available APs
//                List<ScanResult> scans = myWiFiManager.getScanResults();
//                if (scans != null && !scans.isEmpty()) {
//                    for (ScanResult scan : scans) {
//                        //for (int i = 0; i < macList.size(); i++)
//                        if (scan.SSID.equals(myWiFiList.get(i).ssid)) {
//                            int level = WiFiManager.calculateSignalLevel(scan.level, 20);
//                            if (i == 0) {
//                                myWiFiList.get(0).RSS = scan.level;
//                            }
//                            if (i == 1) {
//                                myWiFiList.get(1).RSS = scan.level;
//                            }
//                            if (i == 2) {
//                                myWiFiList.get(2).RSS = scan.level;
//                            }
//                            if (i == 3) {
//                                myWiFiList.get(3).RSS = scan.level;
//                            }
//                            if (i == 4) {
//                                myWiFiList.get(4).RSS = scan.level;
//                            }
//                            if (i == 5) {
//                                myWiFiList.get(5).RSS = scan.level;
//                            }
//                            if (i == 6) {
//                                myWiFiList.get(6).RSS = scan.level;
//                            }
//                            if (i == 7) {
//                                myWiFiList.get(7).RSS = scan.level;
//                            }
//                            if (i == 8) {
//                                myWiFiList.get(8).RSS = scan.level;
//                            }
//                            if (i == 9) {
//                                myWiFiList.get(9).RSS = scan.level;
//                            }
//                            if (i == 10) {
//                                myWiFiList.get(10).RSS = scan.level;
//                            }
//                            if (i == 11) {
//                                myWiFiList.get(11).RSS = scan.level;
//                            }
//                            if (i == 12) {
//                                myWiFiList.get(12).RSS = scan.level;
//                            }
//                            if (i == 13) {
//                                myWiFiList.get(13).RSS = scan.level;
//                            }
//                            if (i == 14) {
//                                myWiFiList.get(14).RSS = scan.level;
//                            }
//                        }
//                    }
//                }
//            }
//        }
