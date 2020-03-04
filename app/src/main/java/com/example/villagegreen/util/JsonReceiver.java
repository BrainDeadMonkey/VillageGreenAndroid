package com.example.villagegreen.util;

import com.example.villagegreen.model.Client;
import com.example.villagegreen.model.Produit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonReceiver {

    public static Call<List<Produit>> createCall() {

        Retrofit produits = new Retrofit.Builder()
                .baseUrl("https://dev.amorce.org/vboulard/VillageGreen/index.php/Api/getAllProd/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderApi = produits.create(JsonPlaceHolderAPI.class);

        Call<List<Produit>> call = jsonPlaceHolderApi.getProd();

        return call;
    }

//    public static Call<List<Client>> createUserCall() {
//
//        Retrofit user = new Retrofit.Builder()
//                .baseUrl("https://dev.amorce.org/vboulard/VillageGreen/index.php/Api/getAllProd/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        JsonPlaceHolderAPI jsonPlaceHolderApi = user.create(JsonPlaceHolderAPI.class);
//
//        Call<List<Client>> call = jsonPlaceHolderApi.getUser();
//
//        return call;
//    }
}
