package com.org.triptrip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.adapter.ExperienceAdapter;
import com.org.triptrip.R;
import com.org.triptrip.common.ExperienceItem;

import java.util.ArrayList;
import java.util.List;


public class ExperienceMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_experience_material, container, false);

        List<ExperienceItem> experiences = new ArrayList<ExperienceItem>();
        for (int i = 0; i < ExperienceItem.experiences.length; i++) {
            experiences.add(new ExperienceItem(
                    ExperienceItem.experiences[i].getTitle(),
                    ExperienceItem.experiences[i].getImage(),
                    ExperienceItem.experiences[i].getDateCreated()
            ));
        }


        ExperienceAdapter adapter = new ExperienceAdapter(experiences, getActivity());
        experienceRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        experienceRecycler.setLayoutManager(layoutManager);

        return experienceRecycler;
    }
}
