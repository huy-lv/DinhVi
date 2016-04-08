package thesis.hcmut.dinhvi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import thesis.hcmut.dinhvi.R;
import thesis.hcmut.dinhvi.model.Wifi;

/**
 * Created by huylv on 06-Apr-16.
 */
public class APAdapter extends RecyclerView.Adapter<APAdapter.APViewHolder> {

    ArrayList<Wifi> apList;
    Context context;
    DecimalFormat numberFormat;

    public APAdapter(Context c, ArrayList<Wifi> aps){
        apList= aps;
        context = c;
        numberFormat = new DecimalFormat("#.00");
    }

    @Override
    public APViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calculate_wifi, parent, false);
        return new APViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final APViewHolder holder, int position) {
        final Wifi wifi = apList.get(position);
        holder.item_calculate_wifi_name.setText(wifi.getSSID());
        holder.item_calculate_wifi_level.setText(wifi.getLevel() + "dBm");
        if(wifi.getDistance() != 0) {
            holder.item_calculate_wifi_distance.setText(numberFormat.format(wifi.getDistance()) + "m");
        }else{
            holder.item_calculate_wifi_distance.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return apList.size();
    }

    class APViewHolder extends RecyclerView.ViewHolder {
        TextView item_calculate_wifi_name;
        TextView item_calculate_wifi_level;
        TextView item_calculate_wifi_distance;
        public APViewHolder(View itemView) {
            super(itemView);
            item_calculate_wifi_name = (TextView)itemView.findViewById(R.id.item_calculate_wifi_name);
            item_calculate_wifi_level =(TextView)itemView.findViewById(R.id.item_calculate_wifi_level);
            item_calculate_wifi_distance = (TextView)itemView.findViewById(R.id.item_calculate_wifi_distance);
        }
    }
}
