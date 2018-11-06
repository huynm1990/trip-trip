package com.org.triptrip.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.activity.ExperienceDetailActivity;
import com.org.triptrip.common.ExperienceItem;
import com.org.triptrip.common.Item;
import com.org.triptrip.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huy Nguyen
 */
public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> implements OnItemClickListener {

    private List<ExperienceItem> experiences;
    private Activity activity;

    public ExperienceAdapter(List<ExperienceItem> experiences, Activity activity) {
        this.experiences = experiences;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_experience, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        CardView cardView = viewHolder.cardView;

        TextView txtTitle = (TextView) cardView.findViewById(R.id.txt_title);
        txtTitle.setText(experiences.get(position).getTitle());

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_image);
        Drawable drawable = cardView.getResources().getDrawable(experiences.get(position).getImage());
        imageView.setImageDrawable(drawable);

        TextView txtDateCreated = (TextView) cardView.findViewById(R.id.txt_date_created);
        txtDateCreated.setText(experiences.get(position).getDateCreated());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onItemClick(experiences.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }

    @Override
    public void onItemClick(Item item) {
        Intent myIntent = new Intent(this.activity, ExperienceDetailActivity.class);
        this.activity.startActivity(myIntent);
    }
}
