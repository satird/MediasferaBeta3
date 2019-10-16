package com.example.mediasferaflash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailMagazin extends AppCompatActivity {
    private Toolbar toolbar;

    String start = "В ахиве доступны ";
    String orange = "бесплатные ";
    String finish = "выпуски\n" +
            "за прошлые года";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazin_detail);

        toolbar = findViewById(R.id.toolbar_logo_qr);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.arrow_left_black);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView title = findViewById(R.id.magazineDetailTitle);
        TextView info = findViewById(R.id.magazineDetailInfoNumbers);
        TextView description = findViewById(R.id.magazineDetailDescription);
        TextView imd = findViewById(R.id.imd);
        ImageView image = findViewById(R.id.magazineDetailImage);

//        RelativeLayout lastContentBtn = findViewById(R.id.go_to_last_number);

        Intent intent = getIntent();
        if (intent != null) {
            title.setText(intent.getStringExtra("titleMagazineDetail"));
            info.setText(intent.getStringExtra("infoMagazineDetail"));
            description.setText(intent.getStringExtra("descriptionMagazineDetail"));
            imd.setText(intent.getStringExtra("imd"));
//            image.setImageResource(intent.getIntExtra("imageMagazineDetail", 0));
            Picasso.get().load(intent.getStringExtra("imageMagazineDetail")).into(image);

//        holder.magDiscription.setText(dataMagazines.get(position).getMagazineDiscription());
//        holder.magCover.setImageResource(dataMagazines.get(position).getMagazineCover());
//        Picasso.get().load(dataMagazines.get(position).getMagazineCover()).fit().centerInside().into(holder.magCover);
        }


        TextView t = (TextView) findViewById(R.id.detailMagazineCaption);
//        t.setText(start + orange + finish);
        t.setText(start + orange + finish, TextView.BufferType.SPANNABLE);
        Spannable s = (Spannable)t.getText();
        int first = start.length();
        int end = first + orange.length();
        s.setSpan(new ForegroundColorSpan(0xFFEB5912), first, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_qr) {
            Intent openQr = new Intent(this, ActivityQr.class);
            startActivity(openQr);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_to_last_number:
                Intent intent = new Intent(this, LastMagazineContentActivity.class);
                startActivity(intent);
                break;
        }
    }
}
