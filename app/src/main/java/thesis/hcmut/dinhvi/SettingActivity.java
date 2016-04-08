package thesis.hcmut.dinhvi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.adapter.SavedWifiAdapter;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 07-Apr-16.
 */
public class SettingActivity extends AppCompatActivity {
    RecyclerView recyclerViewSavedWifi;
    SavedWifiAdapter savedWifiAdapter;
    Button saveWifi;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerViewSavedWifi = (RecyclerView)findViewById(R.id.setting_recyclerview_saved_wifi);
//        Log.e("cxz", "cxz " + Utils.savedWifiList.size());
        savedWifiAdapter = new SavedWifiAdapter(this,Utils.savedWifiList);
        recyclerViewSavedWifi.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSavedWifi.setAdapter(savedWifiAdapter);

        saveWifi = (Button) findViewById(R.id.setting_save_bt);
        saveWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = Utils.savedWifiList.size();
                Utils.savedWifiList.clear();
                for(int i=0;i<size;i++){
                    SavedWifiAdapter.SavedWifiViewHolder holder = savedWifiAdapter.getViewAt(i);
                    Utils.savedWifiList.add(new Wifi(holder.item_saved_wifi_name.getText().toString(),Double.valueOf(holder.item_saved_wifi_x.getText().toString()),Double.valueOf(holder.item_saved_wifi_y.getText().toString()),Double.valueOf(holder.item_saved_wifi_z.getText().toString())));
                    Log.e("cxz","wifi " + holder.item_saved_wifi_name.getText().toString());
                }
                SharedPreferences sp = getSharedPreferences(Utils.SP_KEY,MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                Gson gson = new Gson();
                String json = gson.toJson(Utils.savedWifiList, ArrayList.class);
                editor.putString(Utils.SP_KEY_SAVED_WIFI, json);
                editor.apply();

                finish();
            }
        });
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
