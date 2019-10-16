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


public class FragmentChildMainTab2 extends Fragment {
    private List<DataMagazines> dataMagazines;
    private RecyclerView rv;
    private RequestQueue requestQueue;
    public static final String BASE_POSTER_URL = "https://image.tmdb.org/t/p/";
    public static final String SMALL_POSTER_SIZE = "w342";
    public static final String BIG_POSTER_SIZE = "w780";

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

//        initializeData();
//        initializeAdapter();

        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));

        getMovies();
//        AdapterMagazines adapter = new AdapterMagazines();
//        rv.setAdapter(adapter);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        rv.setLayoutManager(layoutManager);

        return rootView;

    }

    private void getMovies() {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=d573d05582a25d40d9c1010f903a6d32&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            List<DataMagazines> dataMagazines = new ArrayList<>();
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String magazineName = jsonObject.getString("title");
                        String magazineInfo = jsonObject.getString("release_date");
                        String magazineDescription = jsonObject.getString("overview");
                        String magazineCover = BASE_POSTER_URL + SMALL_POSTER_SIZE + jsonObject.getString("poster_path");

                        DataMagazines dataMagazine = new DataMagazines();
                        dataMagazine.setMagazineName(magazineName);
                        dataMagazine.setMagazineInfo(magazineInfo);
                        dataMagazine.setMagazineDiscription(magazineDescription);
                        dataMagazine.setMagazineCover(magazineCover);

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

//    private void initializeAdapter() {
//        AdapterMagazines adapter = new AdapterMagazines(dataMagazines, getActivity());
//        rv.setAdapter(adapter);
//    }

//    private void initializeData() {
//        dataMagazines = new ArrayList<>();
//        dataMagazines.add(new DataMagazines("Magazine1", "01.01.2019", "Magazine1 discription", R.drawable.magazine1));
//        dataMagazines.add(new DataMagazines("Magazine2", "02.02.2019", "Magazine2 discription", R.drawable.magazine2));
//        dataMagazines.add(new DataMagazines("Magazine2", "03.03.2019", "Magazine3 discription", R.drawable.magazine3));
//        dataMagazines.add(new DataMagazines("Magazine1", "01.01.2019", "Magazine1 discription", R.drawable.magazine1));
//        dataMagazines.add(new DataMagazines("Magazine2", "02.02.2019", "Magazine2 discription", R.drawable.magazine2));
//        dataMagazines.add(new DataMagazines("Magazine2", "03.03.2019", "Magazine3 discription", R.drawable.magazine3));
//    }
}
