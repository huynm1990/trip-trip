package com.org.triptrip.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.common.ItemViewDTO;

import java.util.List;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewAdapter.ViewHolder>  {

    private int navigationId;
    private List<ItemViewDTO> items;
    private Activity activity;

    public ItemViewAdapter(int navigationId, List<ItemViewDTO> items, Activity activity) {
        this.navigationId = navigationId;
        this.items = items;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    @Override
    public ItemViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView cv = null;
        if (this.navigationId == R.id.navigation_events) {
            cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_events, viewGroup, false);
        } else if (this.navigationId == R.id.navigation_services) {
            cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_services, viewGroup, false);
        } else if (this.navigationId == R.id.navigation_experiences) {
            cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_experience, viewGroup, false);
        }
        return new ItemViewAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;
        if (this.navigationId == R.id.navigation_events) {
            TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
            txtTitle.setText(items.get(position).getTitle());

            TextView txtEventNote = (TextView) cardView.findViewById(R.id.txt_event_note);
            txtEventNote.setText("Halloween");

            TextView txtPlace = (TextView) cardView.findViewById(R.id.txt_place);
            txtPlace.setText("Canada");

            TextView txtFromDate = (TextView) cardView.findViewById(R.id.txt_from_date);
            txtFromDate.setText("27-Nov-2018");

            TextView txtToDate = (TextView) cardView.findViewById(R.id.txt_to_date);
            txtToDate.setText("30-Nov-2018");

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    //onItemClick(events.get(position));
                }
            });
        } else if (this.navigationId == R.id.navigation_services) {
            TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
            txtTitle.setText(this.items.get(position).getTitle());

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
        } else if (this.navigationId == R.id.navigation_experiences) {
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
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<ItemViewDTO> getItems() {
        return items;
    }
}
