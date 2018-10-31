package com.org.triptrip.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;

/**
 * @author Huy Nguyen
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    private String[] titles;
    private int[] images;
    private String[] dateCreated;
    private String[] phones;
    private String[] locations;
    private int[] evaluations;


    public ServicesAdapter(String[] titles, int[] images, String[] dateCreated, String[] phones, String[] locations, int[] evaluations) {
        this.titles = titles;
        this.images = images;
        this.dateCreated = dateCreated;
        this.phones = phones;
        this.locations = locations;
        this.evaluations = evaluations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_services, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        CardView cardView = viewHolder.cardView;

        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(titles[position]);

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_image);
        Drawable drawable = cardView.getResources().getDrawable(images[position]);
        imageView.setImageDrawable(drawable);

        TextView txtPhone = (TextView) cardView.findViewById(R.id.txt_phone);
        txtPhone.setText(phones[position]);

        TextView txtLocation = (TextView) cardView.findViewById(R.id.txt_location);
        txtLocation.setText(locations[position]);


    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
