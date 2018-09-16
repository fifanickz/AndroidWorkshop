package com.arit.demo.localstoage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arit.demo.localstoage.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;

     ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.tvProductCode.setText(this.products.get(i).getProductCode());
       viewHolder.tvProductName.setText(this.products.get(i).getProductCode());
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         @BindView(R.id.tvProductCode)
        TextView tvProductCode;
        @BindView(R.id.tvProductName)
        TextView tvProductName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
