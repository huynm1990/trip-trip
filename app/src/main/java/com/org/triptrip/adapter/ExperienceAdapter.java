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
public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private String[] titles;
    private int[] images;
    private String[] dateCreated;


    public ExperienceAdapter(String[] titles, int[] images, String[] dateCreated) {
        this.titles = titles;
        this.images = images;
        this.dateCreated = dateCreated;
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
                .inflate(R.layout.card_experience, parent, false);
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

        TextView txtDateCreated = (TextView) cardView.findViewById(R.id.txt_date_created);
        txtDateCreated.setText(dateCreated[position]);


    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
