package com.org.triptrip;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CategoryMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza_material, container, false);

        String[] pizzaNames = new String[Category.categories.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Category.categories[i].getName();
        }

        int[] pizzaImages = new int[Category.categories.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Category.categories[i].getImageResourceId();
        }

        CategoriesAdapter adapter = new CategoriesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }
}
