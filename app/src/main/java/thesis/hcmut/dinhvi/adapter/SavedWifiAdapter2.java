package thesis.hcmut.dinhvi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.R;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 4/8/16.
 */
public class SavedWifiAdapter2 extends ArrayAdapter<Wifi> {
    ArrayList<Wifi> wifiArrayList;
    Context context;

    public SavedWifiAdapter2(Context c, ArrayList<Wifi> wifis) {
        super(c, R.layout.item_wifi_setting);
        context = c;
        wifiArrayList = wifis;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_wifi_setting, parent, false);
        EditText item_saved_wifi_name = (EditText) rowView.findViewById(R.id.item_saved_wifi_name);
        EditText item_saved_wifi_x = (EditText) rowView.findViewById(R.id.item_saved_wifi_x);
        EditText item_saved_wifi_y = (EditText) rowView.findViewById(R.id.item_saved_wifi_y);
        EditText item_saved_wifi_z = (EditText) rowView.findViewById(R.id.item_saved_wifi_z);

        Wifi w = wifiArrayList.get(position);

        item_saved_wifi_name.setText(w.getSSID());
        item_saved_wifi_x.setText(String.valueOf(w.x));
        item_saved_wifi_y.setText(String.valueOf(w.y));
        item_saved_wifi_z.setText(String.valueOf(w.z));
        Log.d("@@@",position+"");
        return rowView;
    }

    @Override
    public int getCount() {
        return Utils.savedWifiList.size();
    }
}
