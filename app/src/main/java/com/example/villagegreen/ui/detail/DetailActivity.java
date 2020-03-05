package com.example.villagegreen.ui.detail;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villagegreen.MainActivity;
import com.example.villagegreen.ProduitsAdapter;
import com.example.villagegreen.R;
import com.example.villagegreen.model.Produit;
import com.example.villagegreen.ui.login.LoginActivity;
import com.example.villagegreen.util.JsonReceiver;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ProduitsAdapter adapter;
    private List<Produit> produitList;
    private RecyclerView recyclerView;
    private ScrollView scrollView;
    private CardView detail_card, main_card_view;
    private TextView lib, ref, prix, des;
    private ImageView img;
    public Produit prod, prod2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorie_main);

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        Intent mainIntent = new Intent(bottomNavigationView.getContext(), MainActivity.class);
                        startActivity(mainIntent);
                        break;
                    case R.id.action_favorites:
                        scrollView.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        break;
                    case R.id.action_compte:
                        Intent intent = new Intent(bottomNavigationView.getContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });

        main_card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                detail_card.setVisibility(View.VISIBLE);

                prepareProd(159151);
            }
        });

        main_card_view = findViewById(R.id.card_view);
        detail_card = findViewById(R.id.detail_card);
        lib = findViewById(R.id.lib_detail);
        ref = findViewById(R.id.ref_detail);
        prix = findViewById(R.id.prix_detail);
        des = findViewById(R.id.des_detail);
        img = findViewById(R.id.image_detail);
    }

    private void prepareProd(int id) {
        JsonReceiver.createProdByIdCall(id).enqueue(new Callback<Produit>() {
            @Override
            public void onResponse(Call<Produit> call, Response<Produit> response) {
                prod = response.body();
                prod2.setPro_des(prod.getPro_des());
            }
            @Override
            public void onFailure(Call<Produit> call, Throwable t) {
            }
        });
    }

//    private void prepareProd(int id) {
//        JsonReceiver.createProdCall(id).enqueue(new Callback<List<Produit>>() {
//            @Override
//            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
//                List<Produit> prods = response.body();
//                adapter.notifyDataSetChanged();
//                for (Produit prod : prods){
//                    Produit pr = new Produit();
//                    pr.setPro_id(prod.getPro_id());
//                    pr.setPro_lib(prod.getPro_lib());
//                    pr.setPro_ref(prod.getPro_ref());
//                    pr.setPro_priV(prod.getPro_priV());
//                    pr.setPro_des(prod.getPro_des());
//                    pr.setPro_pho(prod.getPro_pho());
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Produit>> call, Throwable t) {
//            }
//        });
//    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ((Resources) r).getDisplayMetrics()));
    }

}
