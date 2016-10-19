package com.example.xiaoping.backkeywithfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IBackInterface{
    private Button button1,button2, button3;
    private Fragment fragment;
    private boolean flag; //用于定位当前显示的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        flag = false;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new FragmentOne());
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.button:
                flag = false;
                transaction.replace(R.id.fragment_container, new FragmentOne());
                break;
            case R.id.button2:
                flag = true;
                transaction.replace(R.id.fragment_container, new FragmentTwo());
                break;
            case R.id.button3:
                flag = false;
                transaction.replace(R.id.fragment_container, new FragmentThree());
                break;
        }
        transaction.commit();
    }

    @Override
    public void setSelectedFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onBackPressed() {
        //最好定义一个flag用于区分fragment，便于处理多个fragment需要监听back键
        if (fragment != null && flag && ((FragmentTwo) fragment).onBackPressed()) {
            //处理希望的点击效果
            Toast.makeText(MainActivity.this, "FragmentTwo click backKey", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
