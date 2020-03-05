package com.example.villagegreen;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import  com.bumptech.glide.*;

import androidx.recyclerview.widget.RecyclerView;

import com.example.villagegreen.model.Produit;

import java.util.List;

public class ProduitsAdapter extends RecyclerView.Adapter<ProduitsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Produit> produitList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView ref, lib, prixV;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            ref = view.findViewById(R.id.title);
            lib = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }

    public ProduitsAdapter(Context mContext, List<Produit> produitList) {
        this.mContext = mContext;
        this.produitList = produitList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.produit_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Produit produit = produitList.get(position);
        String prix = String.valueOf(produit.getPro_priV());
        holder.ref.setText(produit.getPro_lib());
        holder.lib.setText(prix + "€");

        Glide.with(mContext).load("https://dev.amorce.org/vboulard/VillageGreen/assets/img/produits/" + produit.getPro_id() + produit.getPro_pho()).into(holder.thumbnail);

    }

    private void showPopupMenu(View view) {

        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_produit, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Details", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return produitList.size();
    }
}
