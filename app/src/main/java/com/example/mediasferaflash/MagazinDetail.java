package com.example.mediasferaflash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MagazinDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazin_detail);

        TextView title = findViewById(R.id.magazineDetailTitle);
        TextView info = findViewById(R.id.magazineDetailInfo);
        TextView description = findViewById(R.id.magazineDetailDescription);
        ImageView image = findViewById(R.id.magazineDetailImage);

        Intent intent = getIntent();
        if (intent != null) {
            title.setText(intent.getStringExtra("titleMagazineDetail"));
            info.setText(intent.getStringExtra("infoMagazineDetail"));
            description.setText(intent.getStringExtra("descriptionMagazineDetail"));
            image.setImageResource(intent.getIntExtra("imageMagazineDetail", 0));
        }
    }
}
