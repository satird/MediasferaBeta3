package com.example.mediasferaflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainChildTab1Fragment extends Fragment {

//    private static final String ARGUMENT_POSITION = "argument_position";
//
//    public static MainChildTab1Fragment newInstance(int position) {
//
//        Bundle args = new Bundle();
//        args.putInt(ARGUMENT_POSITION, position);
//        MainChildTab1Fragment fragment = new MainChildTab1Fragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_main_child_tab1, container, false);
//    }
//
//
////    @SuppressLint("SetTextI18n")
////    @SuppressWarnings("ConstantConditions")
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        TextView tvDashBoard = view.findViewById(R.id.tv_dashboard);
//        int position = getArguments().getInt(ARGUMENT_POSITION, -1);
//        tvDashBoard.setText(position == 0 ? R.string.do_not_stop_believing : R.string.life_is_a_very_funny_proposition_after_all);
//    }
public static MainChildTab1Fragment newInstance() {
    return new MainChildTab1Fragment();
}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_child_tab1, container, false);
    }
}