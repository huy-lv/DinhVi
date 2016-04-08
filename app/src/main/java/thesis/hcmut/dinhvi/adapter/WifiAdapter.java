package thesis.hcmut.dinhvi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

import thesis.hcmut.dinhvi.MainActivity;
import thesis.hcmut.dinhvi.R;
import thesis.hcmut.dinhvi.model.Wifi;
import thesis.hcmut.dinhvi.utils.Utils;

/**
 * Created by huylv on 05-Apr-16.
 */
public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.WifiViewHolder> {

    ArrayList<Wifi> wifiList;
    Context context;

    public WifiAdapter(Context c, ArrayList<Wifi> wifis){
        wifiList= wifis;
        context = c;
    }

    @Override
    public WifiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wifi_recyclerview, parent, false);
        return new WifiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final WifiViewHolder holder, int position) {
        final Wifi wifi = wifiList.get(position);
        holder.item_wifi_name.setText(wifi.getSSID());
        holder.item_wifi_level.setText(wifi.getLevel() + " dBm");
        holder.item_wifi_more_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view, holder, wifi);
            }
        });
        if(arrayContainsElement(Utils.filteredWifiList,wifi)){
//            Log.e("cxz","equal "+wifi.getSSID());
            holder.item_wifi_name.setTextColor(Color.parseColor("#FF001EFF"));
            holder.item_wifi_level.setTextColor(Color.parseColor("#FF001EFF"));
        }else{
            holder.item_wifi_name.setTextColor(Color.parseColor("#000000"));
            holder.item_wifi_level.setTextColor(Color.parseColor("#000000"));
        }
    }

    private void showPopupMenu(View view, final WifiViewHolder holder, final Wifi wifi) {
        PopupMenu popupMenu = new PopupMenu(context,view);
        if(!arrayContainsElement(Utils.filteredWifiList,wifi)){
            popupMenu.getMenu().add("Add to list");
            popupMenu.getMenu().add("Something1 2");
            popupMenu.getMenu().add("Something1 3");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            holder.item_wifi_name.setTextColor(Color.parseColor("#FF001EFF"));
                            holder.item_wifi_level.setTextColor(Color.parseColor("#FF001EFF"));
                            Utils.filteredWifiList.add(wifi);
                            break;
                    }
                    return true;
                }
            });
        }else{
            popupMenu.getMenu().add("Remove from list");
            popupMenu.getMenu().add("Something1 2");
            popupMenu.getMenu().add("Something1 3");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            holder.item_wifi_name.setTextColor(Color.parseColor("#000000"));
                            holder.item_wifi_level.setTextColor(Color.parseColor("#000000"));
                            removeFromArray(Utils.filteredWifiList, wifi);
                            break;
                    }
                    return true;
                }
            });
        }
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu popupMenu) {
                Utils.CHOOSING = false;
                ((MainActivity)context).wifiManager.startScan();
            }
        });
        Utils.CHOOSING = true;
        popupMenu.show();

    }

    boolean arrayContainsElement(ArrayList<Wifi> wifis,Wifi element){
        for(Wifi w : wifis){
            if(element.getSSID().equals(w.getSSID())){
                return true;
            }
        }
        return false;
    }

    void removeFromArray(ArrayList<Wifi> wifis,Wifi element){
        for(int i=0;i<wifis.size();i++){
            if (wifis.get(i).getSSID().equals(element.getSSID())){
                wifis.remove(i);
            }
        }
    }

    @Override
    public int getItemCount() {
        return wifiList.size();
    }

    class WifiViewHolder extends RecyclerView.ViewHolder {
        TextView item_wifi_name;
        TextView item_wifi_level;
        ImageView item_wifi_more_bt;
        public WifiViewHolder(View itemView) {
            super(itemView);
            item_wifi_name = (TextView)itemView.findViewById(R.id.item_wifi_name);
            item_wifi_level =(TextView)itemView.findViewById(R.id.item_wifi_level);
            item_wifi_more_bt = (ImageView)itemView.findViewById(R.id.item_wifi_more_bt);
        }
    }
}
