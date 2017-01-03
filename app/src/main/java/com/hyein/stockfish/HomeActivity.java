package com.hyein.stockfish;

import android.content.Intent;
import android.net.Uri;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.JsonObject;
import com.hyein.stockfish.adapter.CategoryNameAdapter;
import com.hyein.stockfish.model.Category;
import com.hyein.stockfish.network.HttpClient;
import com.hyein.stockfish.notifiactation.InstanceIDService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MultiDex.install(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.e("CHECK ","s??" + GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this));

        listView = (ListView)findViewById(R.id.categoryListView);

        HttpClient client = HttpClient.getInstance();
        client.getCategories(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                Log.e("INFO","resoponse???? "+ response.body());
                setCategories(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                Log.e("INFO","fail ???? "+ t.getMessage());
            }
        });

    }

    public void setCategories(final ArrayList<Category> categorys){
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
