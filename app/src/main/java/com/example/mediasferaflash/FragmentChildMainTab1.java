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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentChildMainTab1 extends Fragment {
    private List<DataMagazines> dataMagazines;
    private List<DataTest> dataTest;
    private RecyclerView rv;
    private RecyclerView rv2;
    private RequestQueue requestQueue;

    public static FragmentChildMainTab1 newInstance() {
        return new FragmentChildMainTab1();
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
//        initializeData();
//        initializeAdapter();

        dataMagazines = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));

        getMovies();

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

    private void getMovies() {
        String url = "http://test.satird.ru/test.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Search");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String magazineName = jsonObject.getString("Title");
                        String magazineInfo = jsonObject.getString("Year");
                        String magazineDescription = jsonObject.getString("Description");
                        String magazineCover = jsonObject.getString("Cover");
                        String imd = jsonObject.getString("Type");

                        DataMagazines dataMagazine = new DataMagazines();
                        dataMagazine.setMagazineName(magazineName);
                        dataMagazine.setMagazineInfo(magazineInfo);
                        dataMagazine.setMagazineDiscription(magazineDescription);
                        dataMagazine.setMagazineCover(magazineCover);
                        dataMagazine.setImd(imd);

                        dataMagazines.add(dataMagazine);
                    }

                    AdapterMagazines adapter = new AdapterMagazines(dataMagazines, getActivity());
                    rv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    private void initializeAdapter() {
        AdapterMagazines adapter = new AdapterMagazines(dataMagazines, getActivity());
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        dataMagazines = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));


//        dataMagazines.add(new DataMagazines(UtilsData.title1, UtilsData.info1, UtilsData.description1, UtilsData.imagazineImage1));
//        dataMagazines.add(new DataMagazines("Magazine4", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
//        dataMagazines.add(new DataMagazines("Magazine5", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
//        dataMagazines.add(new DataMagazines("Magazine3", "01.01.2019", "Magazine3 discription", R.drawable.magazine1));
//        dataMagazines.add(new DataMagazines("Magazine4", "02.02.2019", "Magazine4 discription", R.drawable.magazine2));
//        dataMagazines.add(new DataMagazines("Magazine5", "03.03.2019", "Magazine5 discription", R.drawable.magazine3));
    }

    private void initializeAdapterN() {
        AdapterTest adapter = new AdapterTest(dataTest);
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