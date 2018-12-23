package com.example.ddfshhh.dualpanelandscapetest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ddfshhh.dualpanelandscapetest.fragments.RecipeListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Log.i("MainActivity", "adding RecipeListFragment...");
            FragmentManager fragmentManager = getSupportFragmentManager();
            RecipeListFragment fragment = new RecipeListFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_frag_container, fragment, "recipe_list_fragment");
            fragmentTransaction.commit();
        }
    }

}
