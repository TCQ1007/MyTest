package com.example.myapplication000;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;


public class HeaderFragment extends Fragment {
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //绑定事件
        ImageButton readback = (ImageButton)getActivity().findViewById(R.id.readback);
        readback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加返回跳转
                //Intent.
            }
        });
    }
}
