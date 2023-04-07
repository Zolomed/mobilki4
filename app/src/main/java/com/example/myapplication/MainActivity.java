package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();
    Fragment3 fragment3 = new Fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, mainFragment)
                .commit();
    }

    public void changeFragment(View view) {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btnFragment2: {
                fTrans.replace(R.id.fragment_container_view, fragment2);
                break;
            }
            case R.id.btnFragment3: {
                fTrans.replace(R.id.fragment_container_view, fragment3);
                break;
            }
            case R.id.btnFragment2:
            case R.id.btnFragment3: {
                fTrans.replace(R.id.fragment_container_view, fragment1);
                break;
            }
        }
        fTrans.addToBackStack(null).commit();
    }
}