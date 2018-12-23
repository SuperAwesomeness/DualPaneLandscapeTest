package com.example.ddfshhh.dualpanelandscapetest.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ddfshhh.dualpanelandscapetest.R;
import com.example.ddfshhh.dualpanelandscapetest.StepDetailsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class StepListFragment extends Fragment {


    public StepListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_step_list, container, false);

        rootView.findViewById(R.id.tv_step_list_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on tablets or phones (landscape mode), we load step details frag into the details pane
                if (getActivity().findViewById(R.id.step_details_container) != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    // only if it hasn't been added before
                    // (if we don't check this, then there will be two fragment instances added if the
                    // user repeatedly clicks the StepListFragment)
                    if (fragmentManager.findFragmentByTag("step_details_fragment") == null) {
                        StepDetailsFragment fragment = new StepDetailsFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.step_details_container, fragment, "step_details_fragment");
                        fragmentTransaction.commit();
                        Log.i("StepListFragment", "adding StepDetailsFragment...");
                    }
                } else { // on phones (portrait mode), we simply launch the step details activity
                    Intent intent = new Intent(getActivity(), StepDetailsActivity.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
