package com.hyein.stockfish.network;

import com.google.gson.JsonObject;
import com.hyein.stockfish.model.Category;
import com.hyein.stockfish.model.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nolgong-hyein on 2016. 12. 28..
 */

public interface StockfishService {
    @GET("/categories")
    Call<ArrayList<Category>> getCategories();

    @GET("/categories/{categoryId}")
    Call<ArrayList<Item>> getCategoryItems(@Path("categoryId") int categoryId);
}
