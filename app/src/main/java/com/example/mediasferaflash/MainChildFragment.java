package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainChildFragment extends Fragment {

    private static final String ARGUMENT_POSITION = "argument_position";

    public static MainChildFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        MainChildFragment fragment = new MainChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_child, container, false);
    }


//    @SuppressLint("SetTextI18n")
//    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvDashBoard = view.findViewById(R.id.tv_dashboard);
        int position = getArguments().getInt(ARGUMENT_POSITION, -1);
        tvDashBoard.setText(getString(R.string.title_main) + "" + position);
    }
}