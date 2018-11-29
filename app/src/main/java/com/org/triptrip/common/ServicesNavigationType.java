package com.org.triptrip.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;

import java.util.List;

public class ServicesNavigationType extends NavigationType {

    public ServicesNavigationType(int id, String name, int layoutId) {
        super(id, name, layoutId);
    }

    @Override
    public void loadContent(CardView cardView, List<ItemViewDTO> items, int position) {
        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(items.get(position).getTitle());

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_image);
        Drawable drawable = cardView.getResources().getDrawable(R.drawable.triptrip_logo);
        imageView.setImageDrawable(drawable);

        TextView txtPhone = (TextView) cardView.findViewById(R.id.txt_phone);
        txtPhone.setText("0763997997");

        TextView txtLocation = (TextView) cardView.findViewById(R.id.txt_location);
        txtLocation.setText("Long Xuyen");

        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 1:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite1);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 2:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite2);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 3:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite3);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 4:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite4);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 5:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite5);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 6:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite6);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 7:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite7);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 8:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite8);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
                case 9:
                    imageView = (ImageView) cardView.findViewById(R.id.img_favorite9);
                    drawable = cardView.getResources().getDrawable(R.drawable.ic_favorite_full_10dp);
                    imageView.setImageDrawable(drawable);
                    ;
            }

        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //onItemClick(items.get(position));
            }
        });
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new GridLayoutManager(activity, 2);
    }
}
