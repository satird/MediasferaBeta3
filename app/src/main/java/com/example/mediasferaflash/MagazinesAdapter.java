package com.example.mediasferaflash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MagazinesAdapter extends RecyclerView.Adapter<MagazinesAdapter.DataMagazinesViewHolder> {

    public static class DataMagazinesViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView magName;
        TextView magInfo;
        TextView magDiscription;
        ImageView magCover;
        DataMagazinesViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            magName = (TextView)itemView.findViewById(R.id.magazineName);
            magInfo = (TextView)itemView.findViewById(R.id.magazineInfo);
            magDiscription = (TextView)itemView.findViewById(R.id.magazineDiscription);
            magCover = (ImageView)itemView.findViewById(R.id.magazineCover);
        }
    }

    List<DataMagazines> dataMagazines;

    MagazinesAdapter(List<DataMagazines> dataMagazines){
        this.dataMagazines = dataMagazines;
    }

    @NonNull
    @Override
    public DataMagazinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.magazine_item, parent, false);
        DataMagazinesViewHolder pvh = new DataMagazinesViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataMagazinesViewHolder holder, int position) {
        holder.magName.setText(dataMagazines.get(position).magazineName);
        holder.magInfo.setText(dataMagazines.get(position).magazineInfo);
        holder.magDiscription.setText(dataMagazines.get(position).magazineDiscription);
        holder.magCover.setImageResource(dataMagazines.get(position).magazineCover);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return dataMagazines.size();
    }
}
