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
public class FragmentTwo extends Fragment{
    private TextView textView;
    private IBackInterface backInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        textView.setText("Fragment_Two");
        textView.setBackgroundColor(Color.parseColor("#48DAC9"));
        //保护机制，判断承载此fragment是否实现了IBackInterface接口
        if(!(getActivity() instanceof IBackInterface)){
            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
        }else{
            backInterface = (IBackInterface)getActivity();
        }
        backInterface.setSelectedFragment(this);//将fragment传递到
        return view;
    }

    /**
     * 用于返回是否需要实现监听：
     */
    public boolean onBackPressed() {
        return true;
    }
}
