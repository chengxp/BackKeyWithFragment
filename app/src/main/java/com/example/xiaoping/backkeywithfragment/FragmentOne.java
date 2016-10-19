package com.example.xiaoping.backkeywithfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * Created by xiaoping on 2016/10/14.
 */
public class FragmentOne extends Fragment{
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        textView.setText("Fragment_One");
        textView.setBackgroundColor(Color.parseColor("#FF00FF"));
        return view;
    }
}
