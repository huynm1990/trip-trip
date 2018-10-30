package com.org.triptrip;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ExperienceMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView experienceRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_experience_material, container, false);

        int length = Experience.experiences.length;
        String[] titles = new String[length];
        int[] images = new int[length];
        String[] dateCreated = new String[length];
        for (int i = 0; i < length; i++) {
            titles[i] = Experience.experiences[i].getTitle();
            images[i] = Experience.experiences[i].getImage();
            dateCreated[i] = Experience.experiences[i].getDateCreated();
        }


        ExperienceAdapter adapter = new ExperienceAdapter(titles, images, dateCreated);
        experienceRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        experienceRecycler.setLayoutManager(layoutManager);

        return experienceRecycler;
    }
}
