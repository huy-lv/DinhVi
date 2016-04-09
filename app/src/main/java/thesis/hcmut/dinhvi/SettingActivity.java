package thesis.hcmut.dinhvi;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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
    Button setting_save_bt;
    Toolbar toolbar;
    LinearLayout linearLayoutList;

    ArrayList<View> arrayListItemView;
    ArrayList<EditText> arrayListETName;
    ArrayList<EditText> arrayListETx;
    ArrayList<EditText> arrayListETy;
    ArrayList<EditText> arrayListETz;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //scrollview
        arrayListItemView = new ArrayList<>();
        arrayListETName = new ArrayList<>();
        arrayListETx = new ArrayList<>();
        arrayListETy = new ArrayList<>();
        arrayListETz = new ArrayList<>();
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                for (Wifi w : Utils.savedWifiList) {
                    linearLayoutList = (LinearLayout) findViewById(R.id.linearLayoutList);
                    LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v = vi.inflate(R.layout.item_wifi_setting, null);
                    arrayListItemView.add(v);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                for(int i=0;i<Utils.savedWifiList.size();i++) {
                    EditText e1 = (EditText) arrayListItemView.get(i).findViewById(R.id.item_saved_wifi_name);
                    e1.setText(Utils.savedWifiList.get(i).getSSID());
                    e1.setTextColor(Color.BLACK);
                    arrayListETName.add(e1);
                    EditText e2 = (EditText) arrayListItemView.get(i).findViewById(R.id.item_saved_wifi_x);
                    e2.setText(String.valueOf(Utils.savedWifiList.get(i).x));
                    e2.setTextColor(Color.BLACK);
                    arrayListETx.add(e2);
                    EditText e3 = (EditText) arrayListItemView.get(i).findViewById(R.id.item_saved_wifi_y);
                    e3.setText(String.valueOf(Utils.savedWifiList.get(i).y));
                    e3.setTextColor(Color.BLACK);
                    arrayListETy.add(e3);
                    EditText e4 = (EditText) arrayListItemView.get(i).findViewById(R.id.item_saved_wifi_z);
                    e4.setText(String.valueOf(Utils.savedWifiList.get(i).z));
                    e4.setTextColor(Color.BLACK);
                    arrayListETz.add(e4);
                    linearLayoutList.addView(arrayListItemView.get(i), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }
            }
        }.execute();

        setting_save_bt = (Button) findViewById(R.id.setting_save_bt);
        setting_save_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = Utils.savedWifiList.size();
                Utils.savedWifiList.clear();
                for(int i = 0; i< size; i++){
                    String name = arrayListETName.get(i).getText().toString();
                    double X = Double.parseDouble(arrayListETx.get(i).getText().toString());
                    double Y = Double.parseDouble(arrayListETy.get(i).getText().toString());
                    double Z = Double.parseDouble(arrayListETz.get(i).getText().toString());
                    Utils.savedWifiList.add(new Wifi(name,X,Y,Z));
                }
                SharedPreferences sp = getSharedPreferences(Utils.SP_KEY, MODE_PRIVATE);
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
