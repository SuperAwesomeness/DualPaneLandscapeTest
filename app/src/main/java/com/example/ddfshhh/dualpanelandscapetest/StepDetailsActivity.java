package com.example.ddfshhh.dualpanelandscapetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ddfshhh.dualpanelandscapetest.fragments.RecipeListFragment;
import com.example.ddfshhh.dualpanelandscapetest.fragments.StepDetailsFragment;
import com.example.ddfshhh.dualpanelandscapetest.fragments.StepListFragment;

public class StepDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_details);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            StepDetailsFragment fragmentStepDetails = new StepDetailsFragment();
            FragmentTransaction fragmentTransactionStepDetails = fragmentManager.beginTransaction();
            fragmentTransactionStepDetails.replace(R.id.step_details_container, fragmentStepDetails, "step_details_fragment");
            fragmentTransactionStepDetails.commit();
        }

        // in landscape mode, load step list frag
        if (findViewById(R.id.steps_frag_container) != null) {
            StepListFragment fragmentStepList = new StepListFragment();
            FragmentTransaction fragmentTransactionStepList = fragmentManager.beginTransaction();
            fragmentTransactionStepList.replace(R.id.steps_frag_container, fragmentStepList, "step_list_fragment");
            fragmentTransactionStepList.commit();
        }
    }

}
