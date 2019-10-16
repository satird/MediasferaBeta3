package com.example.mediasferaflash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterContent extends RecyclerView.Adapter<AdapterContent.AdapterContentViewHolder>  {
    private ArrayList<DataContent> arrayList;

    public AdapterContent(ArrayList<DataContent> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);

        Context context = parent.getContext();
        int layoutWithArticle = R.layout.content_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View currentView = inflater.inflate(layoutWithArticle, parent, false);

        AdapterContentViewHolder adapterContentViewHolder= new AdapterContentViewHolder(currentView);
        return adapterContentViewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull AdapterContentViewHolder holder, int position) {
        DataContent dataContent = arrayList.get(position);

        holder.contentArticleTitle.setText(dataContent.getArticleTitle());
        holder.article_price.setText(dataContent.getPriceArticle());
    }

    public static class AdapterContentViewHolder extends RecyclerView.ViewHolder {

        public TextView contentArticleTitle;
        public TextView article_price;
        public ImageView bookmark_icon;

        public AdapterContentViewHolder(@NonNull View itemView) {
            super(itemView);
            contentArticleTitle = itemView.findViewById(R.id.contentArticleTitle);
            article_price = itemView.findViewById(R.id.article_price);
            bookmark_icon = itemView.findViewById(R.id.bookmark_icon);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
