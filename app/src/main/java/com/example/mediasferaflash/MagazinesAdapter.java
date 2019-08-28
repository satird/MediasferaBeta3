package com.example.mediasferaflash;

import android.content.Context;
import android.content.Intent;
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
    private List<DataMagazines> dataMagazines;
    private Context context;
    public class DataMagazinesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView magName;
        TextView magInfo;
        TextView magDiscription;
        ImageView magCover;
        DataMagazinesViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            cv = (CardView)itemView.findViewById(R.id.cv);
            magName = (TextView)itemView.findViewById(R.id.magazineName);
            magInfo = (TextView)itemView.findViewById(R.id.magazineInfo);
            magDiscription = (TextView)itemView.findViewById(R.id.magazineDiscription);
            magCover = (ImageView)itemView.findViewById(R.id.magazineCover);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            DataMagazines dataMagazine = dataMagazines.get(position);

            Intent intent = new Intent(context, MagazinDetail.class);
            intent.putExtra("imageMagazineDetail", dataMagazine.getMagazineCover());
            intent.putExtra("titleMagazineDetail", dataMagazine.getMagazineName());
            intent.putExtra("infoMagazineDetail", dataMagazine.getMagazineInfo());
            intent.putExtra("descriptionMagazineDetail", dataMagazine.getMagazineDiscription());
            context.startActivity(intent);
        }
    }


    MagazinesAdapter(List<DataMagazines> dataMagazines, Context context){
        this.dataMagazines = dataMagazines;
        this.context = context;
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
        holder.magName.setText(dataMagazines.get(position).getMagazineName());
        holder.magInfo.setText(dataMagazines.get(position).getMagazineInfo());
        holder.magDiscription.setText(dataMagazines.get(position).getMagazineDiscription());
        holder.magCover.setImageResource(dataMagazines.get(position).getMagazineCover());
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
