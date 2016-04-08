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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.adapter.SelectedAdapter;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 06-Apr-16.
 */
public class CalculateActivity extends AppCompatActivity {

    RecyclerView recyclerViewAP;
    SelectedAdapter apAdapter;
    ArrayList<Wifi> apList;
    Toolbar toolbar;
    Button calculate_setting_bt;
    Button calculate_calculate_bt;
    TextView calculate_x_value;
    TextView calculate_y_value;

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
        calculate_calculate_bt = (Button)findViewById(R.id.calculate_calculate_bt);
        calculate_x_value = (TextView)findViewById(R.id.calculate_xValue);
        calculate_y_value = (TextView)findViewById(R.id.calculate_yValue);

        apAdapter = new SelectedAdapter(this, Utils.filteredWifiList);
        recyclerViewAP.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAP.setAdapter(apAdapter);

        calculate_setting_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CalculateActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
        calculate_calculate_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePosition(Utils.filteredWifiList);
            }
        });
    }

    private void calculatePosition(ArrayList<Wifi> filteredWifiList) {
        if(checkCorrectAP()){
            if(filteredWifiList.size()== 3) {
                Wifi q1 = Utils.filteredWifiList.get(0);
                Wifi q2 = Utils.filteredWifiList.get(1);
                Wifi q3 = Utils.filteredWifiList.get(2);

                double upY = (q2.x - q1.x) * (q3.x * q3.x + q3.y * q3.y - q3.distance * q3.distance) + (q1.x - q3.x) * (q2.x * q2.x + q2.y * q2.y - q2.distance * q2.distance) + (q3.x - q2.x) * (q1.x * q1.x + q1.y * q1.y - q1.distance * q1.distance);
                double downY = 2 * (q3.y * (q2.x - q1.x) + q2.y * (q1.x - q3.x) + q1.y * (q3.x - q2.x));
                double resultY = upY / downY;

                double upX = (q2.distance * q2.distance + q1.x * q1.x + q1.y * q1.y - q1.distance * q1.distance - q2.x * q2.x - q2.y * q2.y - 2 * (q1.y - q2.y) * resultY);
                double downX = 2 * (q1.x - q2.x);
                double resultX = upX / downX;

                calculate_x_value.setText("x = " + resultX);
                calculate_y_value.setText("y = " + resultY);
            }else{
                Toast.makeText(this,"Selected wifis must be 3 wifis",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Selected APs are not correct",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkCorrectAP() {
        for(Wifi w : Utils.filteredWifiList){
            if(w.x == 0 || w.y == 0) return false;
        }
        return true;
    }

    private void calculateDistance(ArrayList<Wifi> filteredWifiList) {
        for(Wifi wifi:filteredWifiList){
            if(wifi.getLevel() != 0){
                wifi.distance = Utils.calculateDistanceFromLevel(wifi.getLevel());
            }else{
                wifi.distance = 0;
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
