package com.example.mediasferaflash;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class DetailMagazin extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.qr_code_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazin_detail);

        toolbar = findViewById(R.id.toolbar_logo_qr);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

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
