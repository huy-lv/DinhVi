package thesis.hcmut.dinhvi.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.R;
import thesis.hcmut.dinhvi.model.Wifi;

/**
 * Created by huylv on 4/8/16.
 */
public class SavedWifiAdapter3 extends BaseAdapter {
    ArrayList<Wifi> wifiArrayList;
    Activity context;

    public SavedWifiAdapter3(ArrayList<Wifi> wifiArrayList, Activity context) {
        this.wifiArrayList = wifiArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wifiArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = context.getLayoutInflater().inflate(R.layout.item_wifi_setting,null);
        EditText item_saved_wifi_name = (EditText) convertView.findViewById(R.id.item_saved_wifi_name);
        EditText item_saved_wifi_x = (EditText) convertView.findViewById(R.id.item_saved_wifi_x);
        EditText item_saved_wifi_y = (EditText) convertView.findViewById(R.id.item_saved_wifi_y);
        EditText item_saved_wifi_z = (EditText) convertView.findViewById(R.id.item_saved_wifi_z);

        Wifi w = wifiArrayList.get(position);

        item_saved_wifi_name.setText(w.getSSID());
        item_saved_wifi_x.setText(String.valueOf(w.x));
        item_saved_wifi_y.setText(String.valueOf(w.y));
        item_saved_wifi_z.setText(String.valueOf(w.z));
        Log.d("@@@",position+"");
        return convertView;
    }
}
