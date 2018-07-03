package com.github.kavata9.myshoping;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WalMartService {

    public static void findProducts(String productName, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WALMART_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.PARAM_KEY,Constants.WALMART_API_KEY );
        urlBuilder.addQueryParameter(Constants.WALMART_QUERY_PARAMETER,productName);
        String url = urlBuilder.build().toString();


        Request request= new Request.Builder()
                .url(url)
                .build();


    }
}
