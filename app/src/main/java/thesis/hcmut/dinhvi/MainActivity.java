package thesis.hcmut.dinhvi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import thesis.hcmut.dinhvi.adapter.WifiAdapter;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 05-Apr-16.
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewWifiList;
    ArrayList<Wifi> wifiList;
    public WifiManager wifiManager;
    WifiScanReceiver wifiScanReceiver;
    WifiAdapter wifiAdapter;

    Button btScanWifi;
    Button btStartPositioning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewWifiList = (RecyclerView) findViewById(R.id.main_recycler_view);
        btScanWifi = (Button) findViewById(R.id.main_start_scan);
        btStartPositioning = (Button)findViewById(R.id.main_start_positioning);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiScanReceiver = new WifiScanReceiver();
        wifiManager.startScan();

        wifiList = new ArrayList<>();
        wifiAdapter = new WifiAdapter(this, wifiList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerViewWifiList.setLayoutManager(llm);
        recyclerViewWifiList.setAdapter(wifiAdapter);

        btScanWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.startScan();
            }
        });
        btStartPositioning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SelectedWifiActivity.class);
                startActivity(i);
            }
        });

        getDataFromSP();
    }

    public void getDataFromSP() {
        SharedPreferences sp = getSharedPreferences(Utils.SP_KEY, MODE_PRIVATE);
        String json = sp.getString(Utils.SP_KEY_SAVED_WIFI, "null");
        if(!json.equals("null")){
            Gson gson = new Gson();
            ArrayList<Wifi> wifis = gson.fromJson(json, ArrayList.class);
            Utils.savedWifiList.addAll(wifis);
        }else{
            //add data manual
            ArrayList<Wifi> wifis = new ArrayList<>();
            wifis.add(new Wifi("DIS Office",18,0.2,0));
            wifis.add(new Wifi("DIS Office3",0.2,0.2,0));
            wifis.add(new Wifi("DIS Office2",18,11.4,0));
            wifis.add(new Wifi("P.504",0.2,11.6,0));//1 //11
            wifis.add(new Wifi("P.0505",18,11.8,0));//2 //5
            wifis.add(new Wifi("P.0506",19,11.8,0));//3 //
            wifis.add(new Wifi("P.0507",20,11.8,0));//4
            wifis.add(new Wifi("P.0508",21,11.8,0));//5
            wifis.add(new Wifi("P.0509",22,11.8,0));//6
            wifis.add(new Wifi("P.05010",23,11.8,0));//7
            wifis.add(new Wifi("P.05011",24,11.8,0));//8
            wifis.add(new Wifi("P.05012",25,11.8,0));//9
            wifis.add(new Wifi("P.05013",26,11.8,0));//10
            Utils.savedWifiList.addAll(wifis);
        }


    }

    private class WifiScanReceiver extends BroadcastReceiver {
        public void onReceive(Context c, Intent intent) {
            List<ScanResult> wifiScanList = wifiManager.getScanResults();
            wifiList.clear();
            for (ScanResult scanResult : wifiScanList) {
                wifiList.add(new Wifi(scanResult.SSID, scanResult.level));
            }
            wifiAdapter.notifyDataSetChanged();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!Utils.CHOOSING) {
                        wifiManager.startScan();
                    }
                }
            }, 5);
        }
    }

    protected void onPause() {
        if(wifiScanReceiver != null){
            unregisterReceiver(wifiScanReceiver);
        }
        super.onPause();
    }

    protected void onResume() {
        if(wifiScanReceiver != null) {
            registerReceiver(wifiScanReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        }
        super.onResume();
    }
}
