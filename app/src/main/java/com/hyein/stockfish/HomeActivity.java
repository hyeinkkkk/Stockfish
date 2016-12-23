package com.hyein.stockfish;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hyein.stockfish.adapter.CategoryNameAdapter;
import com.hyein.stockfish.model.Category;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Category> categorys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listView = (ListView)findViewById(R.id.categoryListView);


        Category[] arr = {new Category(1,"건새우"),new Category(2,"건오징어"),new Category(3,"황태.북어 류"),
                new Category(4,"노가리"),new Category(5,"쥐포"),new Category(6,"건조개"),new Category(7,"기타")};
        categorys = new ArrayList<>(Arrays.asList(arr));

        CategoryNameAdapter categoryNameAdapter = new CategoryNameAdapter(getApplicationContext(), R.layout.cell_category, categorys);
        listView.setAdapter(categoryNameAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("INFO", "click했다.. "+ categorys.get(i).getId());
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("categoryId",categorys.get(i).getId());
                intent.putExtra("categoryName", categorys.get(i).getName());
                startActivity(intent);

            }
        });
    }

    public void homeCalling(View view){
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
