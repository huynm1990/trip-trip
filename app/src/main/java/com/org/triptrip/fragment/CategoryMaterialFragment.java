package com.org.triptrip.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.org.triptrip.adapter.CategoriesAdapter;
import com.org.triptrip.activity.EventsActivity;
import com.org.triptrip.activity.ExperiencesActivity;
import com.org.triptrip.activity.QuestionsAnswersActivity;
import com.org.triptrip.R;
import com.org.triptrip.activity.ServiceDetailActivity;
import com.org.triptrip.common.Category;


public class CategoryMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView categoryRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_category_material, container, false);

        String[] categoryNames = new String[Category.categories.length];
        for (int i = 0; i < categoryNames.length; i++) {
            categoryNames[i] = Category.categories[i].getName();
        }

        int[] categoryImages = new int[Category.categories.length];
        for (int i = 0; i < categoryImages.length; i++) {
            categoryImages[i] = Category.categories[i].getImageResourceId();
        }

        CategoriesAdapter adapter = new CategoriesAdapter(categoryNames, categoryImages);
        categoryRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        categoryRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CategoriesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = null;
                if (position == 0) {
                    intent = new Intent(getActivity(), EventsActivity.class);
                } else if (position == 1) {
                    intent = new Intent(getActivity(), ExperiencesActivity.class);
                } else if (position == 2) {
                    intent = new Intent(getActivity(), ServiceDetailActivity.class);
                } else if (position == 3) {
                    intent = new Intent(getActivity(), QuestionsAnswersActivity.class);
                }
                getActivity().startActivity(intent);

            }
        });
        return categoryRecycler;
    }
}
