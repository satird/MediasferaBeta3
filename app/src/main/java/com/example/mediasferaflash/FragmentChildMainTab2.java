package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FragmentChildMainTab2 extends Fragment {
    private List<DataMagazines> dataMagazines;
    private RecyclerView rv;

    public static FragmentChildMainTab2 newInstance() {
        return new FragmentChildMainTab2();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_main_child_tab2, container, false);

        rv = (RecyclerView)rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();



//        AdapterMagazines adapter = new AdapterMagazines();
//        rv.setAdapter(adapter);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        rv.setLayoutManager(layoutManager);

        return rootView;

    }

    private void initializeAdapter() {
        AdapterMagazines adapter = new AdapterMagazines(dataMagazines, getActivity());
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        dataMagazines = new ArrayList<>();
        dataMagazines.add(new DataMagazines("Magazine1", "01.01.2019", "Magazine1 discription", R.drawable.magazine1));
        dataMagazines.add(new DataMagazines("Magazine2", "02.02.2019", "Magazine2 discription", R.drawable.magazine2));
        dataMagazines.add(new DataMagazines("Magazine2", "03.03.2019", "Magazine3 discription", R.drawable.magazine3));
        dataMagazines.add(new DataMagazines("Magazine1", "01.01.2019", "Magazine1 discription", R.drawable.magazine1));
        dataMagazines.add(new DataMagazines("Magazine2", "02.02.2019", "Magazine2 discription", R.drawable.magazine2));
        dataMagazines.add(new DataMagazines("Magazine2", "03.03.2019", "Magazine3 discription", R.drawable.magazine3));
    }
}