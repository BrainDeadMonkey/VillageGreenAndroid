//package com.example.villagegreen.ui.detail;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.PopupMenu;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.villagegreen.ProduitsAdapter;
//import com.example.villagegreen.R;
//import com.example.villagegreen.model.Produit;
//
//import java.util.List;
//
//public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder> {
//
//    private Context mContext;
//    private Produit produit;
//
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        private CardView detail_card, main_card_view;
//        private TextView lib, ref, prix, des;
//        private ImageView img;
//
//        public MyViewHolder(View view) {
//            super(view);
//            main_card_view = view.findViewById(R.id.card_view);
//            detail_card = view.findViewById(R.id.detail_card);
//            lib = view.findViewById(R.id.lib_detail);
//            ref = view.findViewById(R.id.ref_detail);
//            prix = view.findViewById(R.id.prix_detail);
//            des = view.findViewById(R.id.des_detail);
//            img = view.findViewById(R.id.image_detail);
//        }
//    }
//
//    public DetailsAdapter(Context mContext, Produit produit) {
//        this.mContext = mContext;
//        this.produit = produit;
//    }
//
//    @Override
//    public DetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.produit_card, parent, false);
//
//        return new DetailsAdapter.MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(final DetailsAdapter.MyViewHolder holder, int position) {
//        Produit produit = .get(position);
//        String prix = String.valueOf(produit.getPro_priV());
//        holder.ref.setText(produit.getPro_lib());
//        holder.lib.setText(prix + "€");
//
//        Glide.with(mContext).load("https://dev.amorce.org/vboulard/VillageGreen/assets/img/produits/" + produit.getPro_id() + produit.getPro_pho()).into(holder.thumbnail);
//
//    }
//
//    private void showPopupMenu(View view) {
//
//        PopupMenu popup = new PopupMenu(mContext, view);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu_produit, popup.getMenu());
//        popup.setOnMenuItemClickListener(new ProduitsAdapter.MyMenuItemClickListener());
//        popup.show();
//    }
//
//    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
//
//        public MyMenuItemClickListener() {
//        }
//
//        @Override
//        public boolean onMenuItemClick(MenuItem menuItem) {
//            switch (menuItem.getItemId()) {
//                case R.id.action_add_favourite:
//                    Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.action_play_next:
//                    Toast.makeText(mContext, "Details", Toast.LENGTH_SHORT).show();
//                    return true;
//                default:
//            }
//            return false;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return produitList.size();
//    }
//}
