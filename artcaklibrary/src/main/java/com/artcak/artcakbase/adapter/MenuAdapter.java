package com.artcak.artcakbase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.artcak.artcakbase.R;
import com.artcak.artcakbase.model.ItemMenu;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    List<ItemMenu> menuModels;
    Context context;

    public MenuAdapter(List<ItemMenu> menuModels) {
        this.menuModels = menuModels;
    }

    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new MenuAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MyViewHolder holder, int position) {
        ItemMenu menuModel = menuModels.get(position);
        holder.tv_title.setText(menuModel.getJudul());
        Glide.with(context).load(menuModel.getGambar_id()).fitCenter().into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView tv_title;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
