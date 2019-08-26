package com.example.mediasferaflash;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MagazineCardActivity extends Activity {
    TextView magName;
    TextView magInfo;
    TextView magDiscription;
    ImageView magCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.magazine_item_activity);
        magName = (TextView)findViewById(R.id.magazineName);
        magInfo = (TextView)findViewById(R.id.magazineInfo);
        magDiscription = (TextView)findViewById(R.id.magazineDiscription);
        magCover = (ImageView)findViewById(R.id.magazineCover);

        magName.setText("Журнал1");
        magInfo.setText("26.08.2019");
        magDiscription.setText("Описание журнала");
        magCover.setImageResource(R.drawable.magazine1);
    }
}
