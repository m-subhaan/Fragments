package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager= getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Fragment1 fragment1= new Fragment1();
        final Fragment2 fragment2= new Fragment2();
        final Fragment3 fragment3= new Fragment3();

        fragmentTransaction.add(R.id.fragmentContainer,fragment1);
        fragmentTransaction.commit();

        final Button btn1 = (Button) findViewById(R.id.btn1);//next
        final Button btn2 = (Button) findViewById(R.id.btn2);//previous
        btn2.setEnabled(false);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment fragment;
                fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
                if(fragment instanceof Fragment1){
                    fragment= fragment2;
                    btn2.setEnabled(true);
                }else
                if(fragment instanceof Fragment2) {
                    fragment = fragment3;
                    btn1.setEnabled(false);
                }
                fragmentTransaction.replace(R.id.fragmentContainer,fragment);
                fragmentTransaction.commit();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fragmentManager.findFragmentById(R.id.fragmentContainer);
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
               if(fragment instanceof Fragment3)
               {

                   fragment=fragment2;
                    btn1.setEnabled(true);
               }else
                if(fragment instanceof Fragment2)
                {
                   fragment=fragment1;
                    btn2.setEnabled(false);
                }
                fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");
                fragmentTransaction.commit();
            }
        });

    }

}
