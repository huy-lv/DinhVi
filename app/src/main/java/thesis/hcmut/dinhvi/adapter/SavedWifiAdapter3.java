//package thesis.hcmut.dinhvi.adapter;
//
//import android.app.Activity;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//
//import java.util.ArrayList;
//
//import thesis.hcmut.dinhvi.R;
//import thesis.hcmut.dinhvi.model.ItemViewListView;
//import thesis.hcmut.dinhvi.model.Wifi;
//
///**
// * Created by huylv on 4/8/16.
// */
//public class SavedWifiAdapter3 extends BaseAdapter {
//    ArrayList<Wifi> wifiArrayList;
//    Activity context;
//    ArrayList<ItemViewListView> listItemView;
//
//
//    public SavedWifiAdapter3(ArrayList<Wifi> wifiArrayList, Activity context) {
//        this.wifiArrayList = wifiArrayList;
//        this.context = context;
//        listItemView = new ArrayList<>();
//    }
//
//    public ItemViewListView getItemViewAt(int pos){
//        return listItemView.get(pos);
//    }
//
//    @Override
//    public int getCount() {
//        return wifiArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        EditText item_saved_wifi_name = null;
//        EditText item_saved_wifi_x = null;
//        EditText item_saved_wifi_y = null;
//        EditText item_saved_wifi_z = null;
//        Wifi w = wifiArrayList.get(position);
//        if(convertView == null) {
//            convertView = context.getLayoutInflater().inflate(R.layout.item_wifi_setting, null);
//            item_saved_wifi_name = (EditText) convertView.findViewById(R.id.item_saved_wifi_name);
//            item_saved_wifi_x = (EditText) convertView.findViewById(R.id.item_saved_wifi_x);
//            item_saved_wifi_y = (EditText) convertView.findViewById(R.id.item_saved_wifi_y);
//            item_saved_wifi_z = (EditText) convertView.findViewById(R.id.item_saved_wifi_z);
//            item_saved_wifi_name.setText(w.getSSID());
//            item_saved_wifi_x.setText(String.valueOf(w.x));
//            item_saved_wifi_y.setText(String.valueOf(w.y));
//            item_saved_wifi_z.setText(String.valueOf(w.z));
//            listItemView.add(new ItemViewListView(item_saved_wifi_name, item_saved_wifi_x, item_saved_wifi_y, item_saved_wifi_z));
////            Log.i("ABAA2", w.getSSID());
//        } else {
//            boolean flag = false;
//            for(ItemViewListView test : listItemView){
//                String tag = (String) convertView.getTag();
//                if(tag == null)
//                    break;
//                if(w.getSSID().equals(tag) && test.getItem_saved_wifi_name().getText().toString().equals(w.getSSID())){
//                   /* item_saved_wifi_name = test.getItem_saved_wifi_name();
//                    item_saved_wifi_x = test.getItem_saved_wifi_x();
//                    item_saved_wifi_y = test.getItem_saved_wifi_y();
//                    item_saved_wifi_z = test.getItem_saved_wifi_z();*/
//                    flag = true;
////                    Log.i("ABAA1",w.getSSID());
//                    break;
//                }
//            }
//            if(!flag){
//                convertView = context.getLayoutInflater().inflate(R.layout.item_wifi_setting, null);
//                item_saved_wifi_name = (EditText) convertView.findViewById(R.id.item_saved_wifi_name);
//                item_saved_wifi_x = (EditText) convertView.findViewById(R.id.item_saved_wifi_x);
//                item_saved_wifi_y = (EditText) convertView.findViewById(R.id.item_saved_wifi_y);
//                item_saved_wifi_z = (EditText) convertView.findViewById(R.id.item_saved_wifi_z);
//                item_saved_wifi_name.setText(w.getSSID());
//                item_saved_wifi_x.setText(String.valueOf(w.x));
//                item_saved_wifi_y.setText(String.valueOf(w.y));
//                item_saved_wifi_z.setText(String.valueOf(w.z));
//                convertView.setTag(w.getSSID());
//                listItemView.add(new ItemViewListView(item_saved_wifi_name, item_saved_wifi_x, item_saved_wifi_y, item_saved_wifi_z));
////                Log.i("ABAA3", w.getSSID());
//            }
//        }
//
//
////        Log.d("@@@",position+"");
//        return convertView;
//    }
//}