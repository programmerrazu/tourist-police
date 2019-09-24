package com.tourist.police.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tourist.police.R;
import com.tourist.police.listeners.OnItemClickListener;
import com.tourist.police.model.HomeInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    private static final String TAG = "HomeAdapter";
    private Context context;
    private List<HomeInfo> homeInfoList;
    private OnItemClickListener listener;

    public HomeAdapter(Context context, List<HomeInfo> homeInfoList, OnItemClickListener listener) {
        this.context = context;
        this.homeInfoList = homeInfoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_items, parent, false);
        return new HomeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        HomeInfo home = homeInfoList.get(position);
        holder.acTvHomeName.setText(home.getName());

        Picasso.get().load(home.getImage()).into(holder.acIvHomeImage);
    }

    @Override
    public int getItemCount() {
        return homeInfoList.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.iv_home_image)
        AppCompatImageView acIvHomeImage;

        @Bind(R.id.tv_home_name)
        AppCompatTextView acTvHomeName;

        HomeHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(homeInfoList.get(getAdapterPosition()));
        }
    }
}