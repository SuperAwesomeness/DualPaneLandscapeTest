package com.example.ddfshhh.dualpanelandscapetest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ddfshhh.dualpanelandscapetest.fragments.StepDetailsFragment;
import com.example.ddfshhh.dualpanelandscapetest.fragments.StepListFragment;

public class RecipeStepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            Log.i("MainActivity", "adding StepListFragment...");
            StepListFragment fragment = new StepListFragment();
            FragmentTransaction fragmentTransactionStepList = fragmentManager.beginTransaction();
            fragmentTransactionStepList.add(R.id.steps_frag_container, fragment, "step_list_fragment");
            fragmentTransactionStepList.commit();
        }

        // in landscape mode, load step details frag
        if (findViewById(R.id.step_details_container) != null) {
            // only if it hasn't been added before
            // (if we don't check this, then there will be two fragment instances added if the
            // device is rotated twice in a row)
            if (fragmentManager.findFragmentByTag("step_details_fragment") == null) {
                Log.i("MainActivity", "adding StepDetailsFragment...");
                StepDetailsFragment fragmentStepDetails = new StepDetailsFragment();
                FragmentTransaction fragmentTransactionStepDetails = fragmentManager.beginTransaction();
                fragmentTransactionStepDetails.add(R.id.step_details_container, fragmentStepDetails, "step_details_fragment");
                fragmentTransactionStepDetails.commit();
            }
        }
    }

}
