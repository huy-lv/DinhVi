package thesis.hcmut.dinhvi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import thesis.hcmut.dinhvi.adapter.SavedWifiAdapter3;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 07-Apr-16.
 */
public class SettingActivity extends AppCompatActivity {
//    RecyclerView recyclerViewSavedWifi;
//    SavedWifiAdapter savedWifiAdapter;

    ListView listViewSavedWifi;
    SavedWifiAdapter3 savedWifiAdapter2;

    Button saveWifi;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewSavedWifi = (ListView)findViewById(R.id.setting_listview_saved_wifi);
        savedWifiAdapter2 = new SavedWifiAdapter3(Utils.savedWifiList,this);
        listViewSavedWifi.setAdapter(savedWifiAdapter2);


//        recyclerViewSavedWifi = (RecyclerView)findViewById(R.id.setting_recyclerview_saved_wifi);
//        Log.e("cxz", "cxz " + Utils.savedWifiList.size());
//        savedWifiAdapter = new SavedWifiAdapter(this,Utils.savedWifiList);
//        recyclerViewSavedWifi.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewSavedWifi.setAdapter(savedWifiAdapter);

        saveWifi = (Button) findViewById(R.id.item_setting_save_bt);
        saveWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<Utils.savedWifiList.size();i++) {
                    EditText et = (EditText) listViewSavedWifi.getChildAt(i).findViewById(R.id.item_saved_wifi_name);
                    Log.e("cxz", "s " + et.getText().toString());
                }
//                int size = Utils.savedWifiList.size();
//                Log.e("cxz","size = "+size);
//                SavedWifiAdapter.SavedWifiViewHolder holder = (SavedWifiAdapter.SavedWifiViewHolder) recyclerViewSavedWifi.findViewHolderForAdapterPosition(size-1);
//                Log.e("cxz","lát item "+holder.item_saved_wifi_name);
//                Utils.savedWifiList.clear();
//                for(int i=0;i<size;i++){
//                    SavedWifiAdapter.SavedWifiViewHolder holder = savedWifiAdapter.getViewAt(i);
//                    Utils.savedWifiList.add(new Wifi(holder.item_saved_wifi_name.getText().toString(),Double.valueOf(holder.item_saved_wifi_x.getText().toString()),Double.valueOf(holder.item_saved_wifi_y.getText().toString()),Double.valueOf(holder.item_saved_wifi_z.getText().toString())));
//                    Log.e("cxz","wifi " + holder.item_saved_wifi_name.getText().toString());
//                }
//                SharedPreferences sp = getSharedPreferences(Utils.SP_KEY,MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                Gson gson = new Gson();
//                String json = gson.toJson(Utils.savedWifiList, ArrayList.class);
//                editor.putString(Utils.SP_KEY_SAVED_WIFI, json);
//                editor.apply();




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
