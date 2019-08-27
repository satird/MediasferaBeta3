package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainChildTab1Fragment extends Fragment {
    private List<DataMagazines> dataMagazines;
    private List<DataTest> dataTest;
    private RecyclerView rv;
    private RecyclerView rv2;

    public static MainChildTab1Fragment newInstance() {
        return new MainChildTab1Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main_child_tab1, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
// разделительная линия между карточками
        DividerItemDecoration dividerLine = new DividerItemDecoration(rv.getContext(),
                llm.getOrientation());
        rv.addItemDecoration(dividerLine);
        // конец разделительной линии
        initializeData();
        initializeAdapter();

//        rv2 = (RecyclerView) rootView.findViewById(R.id.recycler_view_home);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        rv2.setLayoutManager(linearLayoutManager);
//// разделительная линия между карточками
//        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(rv2.getContext(),
//                linearLayoutManager.getOrientation());
//        rv2.addItemDecoration(mDividerItemDecoration);
//        // конец разделительной линии
//        initializeDataN();
//        initializeAdapterN();

        return rootView;
    }

    private void initializeAdapter() {
        MagazinesAdapter adapter = new MagazinesAdapter(dataMagazines);
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        dataMagazines = new ArrayList<>();
        dataMagazines.add(new DataMagazines("Magazine3", "01.01.2019", "Magazine3 discription", R.drawable.magazine1));
        dataMagazines.add(new DataMagazines("Magazine4", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
        dataMagazines.add(new DataMagazines("Magazine5", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
        dataMagazines.add(new DataMagazines("Magazine3", "01.01.2019", "Magazine3 discription", R.drawable.magazine1));
        dataMagazines.add(new DataMagazines("Magazine4", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
        dataMagazines.add(new DataMagazines("Magazine5", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
    }

    private void initializeAdapterN() {
        TestAdapter adapter = new TestAdapter(dataTest);
        rv2.setAdapter(adapter);
    }

    private void initializeDataN() {
        dataTest = new ArrayList<>();
        dataTest.add(new DataTest("Magazine6", "01.01.2019", "Magazine3 discription", R.drawable.magazine1));
        dataTest.add(new DataTest("Magazine7", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
        dataTest.add(new DataTest("Magazine8", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
        dataTest.add(new DataTest("Magazine6", "01.01.2019", "Magazine3 discription", R.drawable.magazine1));
        dataTest.add(new DataTest("Magazine7", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
        dataTest.add(new DataTest("Magazine8", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
    }
}