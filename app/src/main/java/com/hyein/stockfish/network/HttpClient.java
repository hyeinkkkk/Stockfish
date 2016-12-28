package com.hyein.stockfish.network;

import com.google.gson.JsonObject;
import com.hyein.stockfish.model.Category;
import com.hyein.stockfish.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nolgong-hyein on 2016. 12. 28..
 */

public class HttpClient {
    private static HttpClient instance = null;
    private Retrofit retrofit;
    private StockfishService service;
    private static String address = "http://52.78.136.153";



    private HttpClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(address)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(StockfishService.class);
    }

    public static HttpClient getInstance(){
        if(instance == null){
            instance = new HttpClient();
        }
        return instance;
    }

    public static String getAddress() {
        return address;
    }

    public void getCategories(Callback<ArrayList<Category>> callback){
        Call<ArrayList<Category>> call = service.getCategories();
        call.enqueue(callback);
    }

    public void getCategoryItems(int categoryId, Callback<ArrayList<Item>> callback){
        Call<ArrayList<Item>> call = service.getCategoryItems(categoryId);
        call.enqueue(callback);
    }
}
