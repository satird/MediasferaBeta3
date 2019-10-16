package com.example.mediasferaflash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class LastMagazineContentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvContent;
    private RecyclerView.Adapter rvContentAdapter;
    private RecyclerView.LayoutManager rvContentManager;



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_magazine_content);

        toolbar = findViewById(R.id.toolbar_content_magazine);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.arrow_left_black);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        ArrayList<DataContent> dataContent = new ArrayList<>();
        dataContent.add(new DataContent("test article1", "500$", false));
        dataContent.add(new DataContent("test article2", "600$", true));
        dataContent.add(new DataContent("test article3", "700$", false));
        dataContent.add(new DataContent("test article4", "800$", false));

        rvContent = (RecyclerView) findViewById(R.id.rv_content);
        rvContentAdapter = new AdapterContent(dataContent);

        rvContent.setHasFixedSize(true);
        rvContentManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvContent.setLayoutManager(rvContentManager);

        rvContent.setAdapter(rvContentAdapter);
    }
}
