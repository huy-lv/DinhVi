package thesis.hcmut.dinhvi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import thesis.hcmut.dinhvi.adapter.WifiAdapter;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 06-Apr-16.
 */
public class SelectedWifiActivity extends AppCompatActivity {
    public WifiManager wifiManager;
    WifiScanReceiver wifiScanReceiver;
    RecyclerView recyclerViewSelected;
    WifiAdapter wifiAdapter;
    Button selected_go_to_calc_activity;
    Toolbar toolbar;
    private boolean GETTING_LEVEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_wifi);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewSelected = (RecyclerView) findViewById(R.id.selected_recyclerview_selected_wifi);
        selected_go_to_calc_activity = (Button) findViewById(R.id.selected_go_to_calc_activity);

        wifiAdapter = new WifiAdapter(this, Utils.filteredWifiList);
        recyclerViewSelected.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSelected.setAdapter(wifiAdapter);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiScanReceiver = new WifiScanReceiver();
        wifiManager.startScan();

        selected_go_to_calc_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectedWifiActivity.this, CalculateActivity.class);
                startActivity(i);
            }
        });
    }


    private class WifiScanReceiver extends BroadcastReceiver {
        public void onReceive(Context c, Intent intent) {
            List<ScanResult> wifiScanList = wifiManager.getScanResults();
            for (Wifi selectedWifi : Utils.filteredWifiList) {
                GETTING_LEVEL = true;
                for (ScanResult scanResult : wifiScanList) {
                    if (scanResult.SSID.equals(selectedWifi.getSSID())) {
                        selectedWifi.setLevel(scanResult.level);
                        GETTING_LEVEL = false;
                        break;
                    }
                }
                if (GETTING_LEVEL) {
                    selectedWifi.setLevel(0);
                }
            }
            wifiAdapter.notifyDataSetChanged();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    wifiManager.startScan();
                }
            }, 10);
        }
    }

    protected void onPause() {
        if (wifiScanReceiver != null) {
            unregisterReceiver(wifiScanReceiver);
        }
        super.onPause();
    }

    protected void onResume() {
        if (wifiScanReceiver != null) {
            registerReceiver(wifiScanReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        }
        super.onResume();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
