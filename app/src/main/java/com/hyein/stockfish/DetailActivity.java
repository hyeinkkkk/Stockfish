package com.hyein.stockfish;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.hyein.stockfish.adapter.ItemAdapter;
import com.hyein.stockfish.model.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailActivity extends AppCompatActivity {
    int categoryId;
    String categoryName;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        categoryId = intent.getExtras().getInt("categoryId");
        categoryName = intent.getExtras().getString("categoryName");

        TextView nameTextView = (TextView)findViewById(R.id.detailCategoryTextView);
        nameTextView.setText(categoryName);

        Item[] arr = {new Item("건새우"),new Item("건오징어"),new Item("황태.북어 류"),
                new Item("노가리"),new Item("쥐포"),new Item("건조개")};
        items = new ArrayList<>(Arrays.asList(arr));

        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), R.layout.cell_item, items);
        GridView gridView = (GridView)findViewById(R.id.detailGridView);
        gridView.setAdapter(itemAdapter);

    }

    public void detailCalling(View view){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:01050941537"));
//        intent.setData(Uri.parse("tel:01041619690"));
        try{
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
