package thesis.hcmut.dinhvi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.ArrayList;

import thesis.hcmut.dinhvi.R;
import thesis.hcmut.dinhvi.model.Wifi;

/**
 * Created by huylv on 07-Apr-16.
 */
public class SavedWifiAdapter extends RecyclerView.Adapter<SavedWifiAdapter.SavedWifiViewHolder> {

    ArrayList<Wifi> savedWifiList;
    Context context;
    DecimalFormat numberFormat;

    public SavedWifiAdapter(Context c, ArrayList<Wifi> aps) {
        savedWifiList = aps;
        context = c;
        numberFormat = new DecimalFormat("#.00");
    }


    @Override
    public SavedWifiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wifi_setting, parent, false);
        return new SavedWifiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SavedWifiViewHolder holder, int position) {
        final Wifi wifi = savedWifiList.get(position);
        holder.item_saved_wifi_name.setText(wifi.getSSID());
        holder.item_saved_wifi_x.setText(String.valueOf(wifi.x));
        holder.item_saved_wifi_y.setText(String.valueOf(wifi.y));
        holder.item_saved_wifi_z.setText(String.valueOf(wifi.z));

 /*       holder.item_setting_save_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.EDITTING){

                }else{

                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return savedWifiList.size();
    }

    public class SavedWifiViewHolder extends RecyclerView.ViewHolder {
        public EditText item_saved_wifi_name;
        public EditText item_saved_wifi_x;
        public EditText item_saved_wifi_y;
        public EditText item_saved_wifi_z;
        public SavedWifiViewHolder(View itemView) {
            super(itemView);
            item_saved_wifi_name = (EditText) itemView.findViewById(R.id.item_saved_wifi_name);
            item_saved_wifi_x = (EditText) itemView.findViewById(R.id.item_saved_wifi_x);
            item_saved_wifi_y = (EditText) itemView.findViewById(R.id.item_saved_wifi_y);
            item_saved_wifi_z = (EditText) itemView.findViewById(R.id.item_saved_wifi_z);
        }
    }
}