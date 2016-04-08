//package thesis.hcmut.dinhvi;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Calculate1 extends AppCompatActivity {
//    TextView Wap1, Wap2, Wap3;
//    TextView Rss1, Rss2, Rss3;
//    TextView X, Y, Z;
//    Button btnCalculate, btnDisplay;
//    List<Double> distance = new ArrayList<>();
//    List<Integer> position = new ArrayList<>();
//    // declare distances to 4 nodes
//    TextView Distance1, Distance2, Distance3;
//    //declare the coordinates of 4 nodes
//    Double x1, y1, z1, x2, y2, z2, x3, y3, z3;
//    //declare t4 distances to 4 nodes
//    double r1, r2, r3, r4;
//    int RSS1Value, RSS2Value, RSS3Value;
//    List<WiFiResult> WiFiList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calculate1);
//        // the highest value
//        Wap1 = (TextView) findViewById(R.id.WAP1);
//        Rss1 = (TextView) findViewById(R.id.RSS1);
//        // the second value
//        Wap2 = (TextView) findViewById(R.id.WAP2);
//        Rss2 = (TextView) findViewById(R.id.RSS2);
//        // the third value
//        Wap3 = (TextView) findViewById(R.id.WAP3);
//        Rss3 = (TextView) findViewById(R.id.RSS3);
//        // distanes to 3 nodes
//        Distance1 = (TextView) findViewById(R.id.Distance1);
//        Distance2 = (TextView) findViewById(R.id.Distance2);
//        Distance3 = (TextView) findViewById(R.id.Distance3);
//        // Output of the app
//        X = (TextView) findViewById(R.id.X);
//        Y = (TextView) findViewById(R.id.Y);
//        Z = (TextView) findViewById(R.id.Z);
//        btnCalculate = (Button) findViewById(R.id.Calculate);
//        btnDisplay = (Button) findViewById(R.id.Display);
//        Bundle bd = getIntent().getExtras();
//
//        if (bd != null)
//
//        {             //get values of the highest
//            String WiFiName1 = bd.getString("WiFiName1");
//            RSS1Value = bd.getInt("Rss1");
//            x1 = bd.getDouble("x1");
//            y1 = bd.getDouble("y1");
//            z1 = bd.getDouble("z1");
//            Wap1.setText(WiFiName1);
//            Rss1.setText(String.valueOf(RSS1Value) + "dBm");
//            // get values of the second
//            String WiFiName2 = bd.getString("WiFiName2");
//            RSS2Value = bd.getInt("Rss2");
//            x2 = bd.getDouble("x2");
//            y2 = bd.getDouble("y2");
//            z2 = bd.getDouble("z2");
//            Wap2.setText(WiFiName2);
//            Rss2.setText(String.valueOf(RSS2Value) + "dBm");
//            // get values of the third
//            String WiFiName3 = bd.getString("WiFiName3");
//            RSS3Value = bd.getInt("Rss3");
//            x3 = bd.getDouble("x3");
//            y3 = bd.getDouble("y3");
//            z3 = bd.getDouble("z3");
//            Wap3.setText(WiFiName3);
//            Rss3.setText(String.valueOf(RSS3Value) + "dBm");
//            //add the values into WiFiList
//            WiFiResult WF1 = new WiFiResult();
//            WF1.RssValue = RSS1Value;
//            WF1.toadoX = x1;
//            WF1.toadoY = y1;
//            WF1.toadoZ = z1;
//            WiFiList.add(WF1);
//            WiFiResult WF2 = new WiFiResult();
//            WF2.RssValue = RSS2Value;
//            WF2.toadoX = x2;
//            WF2.toadoY = y2;
//            WF2.toadoZ = z2;
//
//            WiFiList.add(WF2);
//            WiFiResult WF3 = new WiFiResult();
//            WF3.RssValue = RSS3Value;
//            WF3.toadoX = x3;
//            WF3.toadoY = y3;
//            WF3.toadoZ = z3;
//            WiFiList.add(WF3);
//        }
//
//        btnCalculate.setOnClickListener(new View.OnClickListener()
//
//                                        {
//                                            @Override
//                                            public void onClick(View v) {
//                                                for (int i = 0; i < WiFiList.size(); i++) {
//                                                    WiFiList.get(i).distance = calculateDistance(WiFiList.get(i).RssValue);
//                                                }
//                                                // Update UI for distances
//                                                r1 = WiFiList.get(0).distance;
//                                                r2 = WiFiList.get(1).distance;
//                                                r3 = WiFiList.get(2).distance;
//                                                //r4 = WiFiList.get(3).distance;
//                                                Distance1.setText(String.format("%.2f", r1) + "m");
//                                                Distance2.setText(String.format("%.2f", r2) + "m");
//                                                Distance3.setText(String.format("%.2f", r3) + "m");
//                                                position = positioning(x1, y1, x2, y2, x3, y3, WiFiList.get(0).distance, WiFiList.get(1).distance, WiFiList.get(2).distance);
//                                                X.setText("X=" + String.format("%.2f", position.get(1)));
//                                                Y.setText("Y=" + String.format("%.2f", position.get(0)));
//                                                Z.setText("Z=" + String.format("%.2f", z1));
//                                            }
//                                        }
//
//        );
//        btnDisplay.setOnClickListener(new View.OnClickListener()
//
//                                      {
//                                          @Override
//                                          public void onClick(View v) {
//                                              Intent mh3 = new Intent(Calculate1.this, Graphic.class);
//                                              mh3.putExtra("toa do x", position.get(1));
//                                              mh3.putExtra("toa do y", position.get(0));
//                                              startActivity(mh3);
//                                          }
//                                      }
//
//        );
//    }
//
//    // Hàm tính khoảng cách từ 1 điểm tới 1 WiFi Access Point
//    public double calculateDistance(int receivedPower) {
//        int powerAtD0 = -38;         // declare the path loss exponent
//        double n = 3, 61.;
//        //double n = 3.5;
//        double exp = (powerAtD0 - receivedPower) / (10 * n);
//        double distance = Math.pow(10.0, exp);
//        return distance;
//    }
//
//    //Hàm tính Det của 1 ma trận 3x3
//    public Double DetMatrix(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33) {
//        double DetA = a11 * (a22 * a33 - a32 * a23) - a12 * (a21 * a33 - a31 * a23) + a13 * (a21 * a32 - a31 * a22);
//        return DetA;
//    }
//
//    // Hàm tính tọa độ của 1 điểm dựa vào 3 khoảng cách, và tọa độ của 3 AP
//    public List positioning(double a1, double b1, double a2, double b2, double a3, double b3, double r1, double r2, double r3) {
//        List<Double> location = new ArrayList<>();
//        double a1Sp = a1 * a1, a2Sp = a2 * a2, a3Sp = a3 * a3, b1Sp = b1 * b1, b2Sp = b2 * b2, b3Sp = b3 * b3, r1Sp = r1 * r1, r2Sp = r2 * r2, r3Sp = r3 * r3;
//        double numerator1 = (a2 - a1) * (a3Sp + b3Sp - r3Sp) + (a1 - a3) * (a2Sp + b2Sp - r2Sp) + (a3 - a2) * (a1Sp + b1Sp - r1Sp);
//        double denominator1 = 2 * (b3 * (a2 - a1) + b2 * (a1 - a3) + b1 * (a3 - a2));
//        // Toa do y
//        location.add(numerator1 / denominator1);
//        double numerator2 = r2Sp - r1Sp + a1Sp - a2Sp + b1Sp - b2Sp - 2 * (b1b2) * location.get(0);
//        double denumerator2 = 2 * (a1 - a2);         // Toa do x
//
//        location.add(numerator2 / denumerator2);
//        return location;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_calculate, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}