package thesis.hcmut.dinhvi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.adapter.APAdapter;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 06-Apr-16.
 */
public class CalculateActivity extends AppCompatActivity {

    RecyclerView recyclerViewAP;
    APAdapter apAdapter;
    ArrayList<Wifi> apList;
    Toolbar toolbar;
    Button calculate_setting_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewAP = (RecyclerView)findViewById(R.id.calculate_recyclerview_aplist);
        calculate_setting_bt = (Button)findViewById(R.id.calculate_setting);
        calculateDistance(Utils.filteredWifiList);

        apAdapter = new APAdapter(this, Utils.filteredWifiList);
        recyclerViewAP.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAP.setAdapter(apAdapter);

        calculatePosition(Utils.filteredWifiList);
        calculate_setting_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CalculateActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
    }

    private void calculatePosition(ArrayList<Wifi> filteredWifiList) {
//        double up =
    }

    private void calculateDistance(ArrayList<Wifi> filteredWifiList) {
        for(Wifi wifi:filteredWifiList){
            if(wifi.getLevel() != 0){
                wifi.setDistance(Utils.calculateDistanceFromLevel(wifi.getLevel()));
            }else{
                wifi.setDistance(0);
            }
        }
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
