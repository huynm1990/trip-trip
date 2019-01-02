package com.org.triptrip.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;

import java.util.List;

/**
 * Experiences Navigation Type
 * @author Huy Nguyen
 */
public class ExperiencesNavigationType extends NavigationType {

    /**
     * Experiences Navigation Type
     * @param id
     * @param name
     * @param layoutId
     */
    public ExperiencesNavigationType(int id, String name, int layoutId) {
        super(id, name, layoutId);
    }

    @Override
    public void loadContent(CardView cardView, List<ItemViewDTO> items, int position) {
        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(items.get(position).getTitle());

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_image);
        Drawable drawable = cardView.getResources().getDrawable(R.drawable.triptrip_logo);
        imageView.setImageDrawable(drawable);

        TextView txtDateCreated = (TextView) cardView.findViewById(R.id.txt_date_created);
        txtDateCreated.setText("27-Nov-2018");

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //
            }
        });
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new GridLayoutManager(activity, 2);
    }
}
