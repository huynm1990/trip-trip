package com.org.triptrip.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.org.triptrip.R;
import com.org.triptrip.common.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huy Nguyen
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    List<Service> services = new ArrayList<Service>();


    public ServicesAdapter(List<Service> services) {
        this.services = services;
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
        txtTitle.setText(this.services.get(position).getTitle());

        ImageView imageView = (ImageView) cardView.findViewById(R.id.img_image);
        Drawable drawable = cardView.getResources().getDrawable(this.services.get(position).getImage());
        imageView.setImageDrawable(drawable);

        TextView txtPhone = (TextView) cardView.findViewById(R.id.txt_phone);
        txtPhone.setText(this.services.get(position).getPhone());

        TextView txtLocation = (TextView) cardView.findViewById(R.id.txt_location);
        txtLocation.setText(this.services.get(position).getLocation());


    }

    @Override
    public int getItemCount() {
        return services.size();
    }
}
