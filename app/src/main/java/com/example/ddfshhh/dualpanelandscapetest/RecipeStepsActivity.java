package com.example.ddfshhh.dualpanelandscapetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.ddfshhh.dualpanelandscapetest.fragments.RecipeListFragment;
import com.example.ddfshhh.dualpanelandscapetest.fragments.StepDetailsFragment;
import com.example.ddfshhh.dualpanelandscapetest.fragments.StepListFragment;

public class RecipeStepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            StepListFragment fragment = new StepListFragment();
            FragmentTransaction fragmentTransactionStepList = fragmentManager.beginTransaction();
            fragmentTransactionStepList.replace(R.id.steps_frag_container, fragment, "step_list_fragment");
            fragmentTransactionStepList.commit();
        }

        // in landscape mode, load step details frag
        if (findViewById(R.id.step_details_container) != null) {
            StepDetailsFragment fragmentStepDetails = new StepDetailsFragment();
            FragmentTransaction fragmentTransactionStepDetails = fragmentManager.beginTransaction();
            fragmentTransactionStepDetails.replace(R.id.step_details_container, fragmentStepDetails, "step_details_fragment");
            fragmentTransactionStepDetails.commit();
        }
    }

}
