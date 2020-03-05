package com.example.villagegreen.ui.categ;

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

public class CategActivity extends AppCompatActivity {

    private ProduitsAdapter adapter;
    private List<Produit> produitList;
    private RecyclerView recyclerView;
    private ScrollView scrollView;
    private CardView main_card_view, detail_card;
    private TextView lib, ref, prix, des;
    private ImageView img;
    public Produit prod2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorie_main);

        CardView card_view = findViewById(R.id.card4);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareProduits(3);
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        CardView card_view1 = findViewById(R.id.card3);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareProduits(2);
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        CardView card_view2 = findViewById(R.id.card5);
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareProduits(4);
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        CardView card_view3 = findViewById(R.id.card1);
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareProduits(1);
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        CardView card_view4 = findViewById(R.id.card2);
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareProduits(5);
                scrollView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

//        main_card_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                scrollView.setVisibility(View.GONE);
//                recyclerView.setVisibility(View.GONE);
//                detail_card.setVisibility(View.VISIBLE);
//
//                prepareProd(159151);
//            }
//        });

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        Intent mainIntent = new Intent(bottomNavigationView.getContext(), MainActivity.class);
                        startActivity(mainIntent);
//                     Toast.makeText(MainActivity.this, "Accueil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:
//                        recyclerView.setVisibility(View.VISIBLE);
//                        Intent intent2 = new Intent(bottomNavigationView.getContext(), CategActivity.class);
//                        startActivity(intent2);
//                        Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                        scrollView.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        break;
                    case R.id.action_compte:
                        Intent intent = new Intent(bottomNavigationView.getContext(), LoginActivity.class);
                        startActivity(intent);
//                        Toast.makeText(MainActivity.this, "Mon Compte", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        scrollView = findViewById(R.id.scrollView2);
        main_card_view = findViewById(R.id.card_view);

        detail_card = findViewById(R.id.detail_card);
        lib = findViewById(R.id.lib_detail);
        ref = findViewById(R.id.ref_detail);
        prix = findViewById(R.id.prix_detail);
        des = findViewById(R.id.des_detail);
        img = findViewById(R.id.image_detail);

//        des.setText(prod2.getPro_des());

        recyclerView.setVisibility(View.GONE);
        produitList = new ArrayList<>();
        adapter = new ProduitsAdapter(this, produitList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new CategActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void prepareProduits(int id) {
        JsonReceiver.createProdCall(id).enqueue(new Callback<List<Produit>>() {
            @Override
            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                List<Produit> prods = response.body();
                adapter.notifyDataSetChanged();
                for (Produit prod : prods){
                    Produit pr = new Produit();
                    pr.setPro_id(prod.getPro_id());
                    pr.setPro_lib(prod.getPro_lib());
                    pr.setPro_ref(prod.getPro_ref());
                    pr.setPro_priV(prod.getPro_priV());
                    pr.setPro_pho(prod.getPro_pho());
                    produitList.add(pr);
                }
            }
            @Override
            public void onFailure(Call<List<Produit>> call, Throwable t) {
            }
        });
    }

    private void prepareProd(int id) {
        JsonReceiver.createProdByIdCall(id).enqueue(new Callback<Produit>() {
            @Override
            public void onResponse(Call<Produit> call, Response<Produit> response) {
                prod2 = response.body();
            }
            @Override
            public void onFailure(Call<Produit> call, Throwable t) {
            }
        });
    }



    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ((Resources) r).getDisplayMetrics()));
    }

}
