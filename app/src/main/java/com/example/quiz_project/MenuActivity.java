package com.example.quiz_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle params = getIntent().getExtras();
        String username = params.getString("username");
        this.setTitle("Hello, " + username + "!");

        ArrayList<Batik> batiks = new ArrayList<>();
        batiks.add(new Batik("Batik Android", R.drawable.ic_android_black_24dp, 100000, "Batik Android adalah batik lorem ipsum dolor sit amet"));
        batiks.add(new Batik("Batik Musik", R.drawable.ic_audiotrack_black_24dp, 80000, "Batik Musik adalah batik lorem ipsum dolor sit amet"));
        batiks.add(new Batik("Batik Baterai", R.drawable.ic_battery_full_black_24dp, 125000, "Batik Baterai adalah batik lorem ipsum dolor sit amet"));

        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(new BatikAdapter(batiks, this));
    }
}
class BatikAdapter extends BaseAdapter {

    private ArrayList<Batik> batiks;
    private Context context;

    @Override
    public int getCount() {
        return batiks.size();
    }

    @Override
    public Object getItem(int position) {
        return batiks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_listview, parent, false);
        }

        Batik currentItem = (Batik) getItem(position);

        TextView title = convertView.findViewById(R.id.title_listview);
        TextView bullshit = convertView.findViewById(R.id.bullshit_listview);
        TextView price = convertView.findViewById(R.id.price_listview);
        ImageView image = convertView.findViewById(R.id.img_listview);

        title.setText(currentItem.getName());
        bullshit.setText(currentItem.getBullshit());
        price.setText("Rp " + currentItem.getPrice());
        image.setImageResource(currentItem.getImgId());

        return convertView;
    }

    public BatikAdapter(ArrayList<Batik> batiks, Context context) {
        this.batiks = batiks;
        this.context = context;
    }
}

class Batik {
    String name;
    int imgId;
    int price;
    String bullshit;

    public Batik(String name, int imgId, int price, String bullshit) {
        this.name = name;
        this.imgId = imgId;
        this.price = price;
        this.bullshit = bullshit;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

    public int getPrice() {
        return price;
    }

    public String getBullshit() {
        return bullshit;
    }
}
