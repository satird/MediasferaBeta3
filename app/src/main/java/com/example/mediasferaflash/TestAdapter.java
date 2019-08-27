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

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.DataTestViewHolder> {
    private List<DataTest> dataTest;

    public static class DataTestViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView magName;
        TextView magInfo;
        TextView magDiscription;
        ImageView magCover;
        DataTestViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv2);
            magName = (TextView)itemView.findViewById(R.id.magazineName2);
            magInfo = (TextView)itemView.findViewById(R.id.magazineInfo2);
            magDiscription = (TextView)itemView.findViewById(R.id.magazineDiscription2);
            magCover = (ImageView)itemView.findViewById(R.id.magazineCover2);
        }
    }


    TestAdapter(List<DataTest> dataTest){
        this.dataTest = dataTest;
    }

    @NonNull
    @Override
    public DataTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false);
        DataTestViewHolder pvh = new DataTestViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataTestViewHolder holder, int position) {
        holder.magName.setText(dataTest.get(position).magazineNameN);
        holder.magInfo.setText(dataTest.get(position).magazineInfoN);
        holder.magDiscription.setText(dataTest.get(position).magazineDiscriptionN);
        holder.magCover.setImageResource(dataTest.get(position).magazineCoverN);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return dataTest.size();
    }
}
