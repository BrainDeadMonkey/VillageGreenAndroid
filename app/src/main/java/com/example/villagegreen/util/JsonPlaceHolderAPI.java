package com.example.villagegreen.util;

import com.example.villagegreen.model.Client;
import com.example.villagegreen.model.Produit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    @GET("getAllProd")
    Call<List<Produit>> getProd();
//    @GET("getUser")
//    Call<List<Client>> getUser();
}
