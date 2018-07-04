package com.github.kavata9.myshoping.services;

import android.util.Log;

import com.github.kavata9.myshoping.Constants;
import com.github.kavata9.myshoping.models.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WalMartService {

    public static void findProducts(String itemName, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WALMART_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.PARAM_KEY,Constants.WALMART_API_KEY );
        urlBuilder.addQueryParameter(Constants.WALMART_QUERY_PARAMETER,itemName);
        String url = urlBuilder.build().toString();


        Request request= new Request.Builder()
                .url(url)
                .build();


//        Log.d("Generated", "Request: "+request);
        Call call = client.newCall(request);
        call.enqueue(callback);


    }

    public static List<Item> result(Response response) {
        List<Item> result = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if (response.isSuccessful()) {
                // The response JSON is an array of business objects within an object so we need to get that array
                JSONObject musicJSON = new JSONObject(jsonData);
                JSONArray bodyJSON = musicJSON.getJSONArray("items");

                Type collectionType = new TypeToken<List<Item>> () {}.getType();
                Gson gson = new GsonBuilder().create();
                result = gson.fromJson(bodyJSON.toString(), collectionType);
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
