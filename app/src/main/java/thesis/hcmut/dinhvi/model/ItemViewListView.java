package thesis.hcmut.dinhvi.model;

import android.widget.EditText;

/**
 * Created by huylv on 08-Apr-16.
 */
public class ItemViewListView {

    EditText item_saved_wifi_name;
    EditText item_saved_wifi_x;
    EditText item_saved_wifi_y;
    EditText item_saved_wifi_z;

    public ItemViewListView(EditText item_saved_wifi_name, EditText item_saved_wifi_x, EditText item_saved_wifi_y, EditText item_saved_wifi_z) {
        this.item_saved_wifi_name = item_saved_wifi_name;
        this.item_saved_wifi_x = item_saved_wifi_x;
        this.item_saved_wifi_y = item_saved_wifi_y;
        this.item_saved_wifi_z = item_saved_wifi_z;
    }

    public EditText getItem_saved_wifi_name() {
        return item_saved_wifi_name;
    }

    public void setItem_saved_wifi_name(EditText item_saved_wifi_name) {
        this.item_saved_wifi_name = item_saved_wifi_name;
    }

    public EditText getItem_saved_wifi_x() {
        return item_saved_wifi_x;
    }

    public void setItem_saved_wifi_x(EditText item_saved_wifi_x) {
        this.item_saved_wifi_x = item_saved_wifi_x;
    }

    public EditText getItem_saved_wifi_y() {
        return item_saved_wifi_y;
    }

    public void setItem_saved_wifi_y(EditText item_saved_wifi_y) {
        this.item_saved_wifi_y = item_saved_wifi_y;
    }

    public EditText getItem_saved_wifi_z() {
        return item_saved_wifi_z;
    }

    public void setItem_saved_wifi_z(EditText item_saved_wifi_z) {
        this.item_saved_wifi_z = item_saved_wifi_z;
    }
}
