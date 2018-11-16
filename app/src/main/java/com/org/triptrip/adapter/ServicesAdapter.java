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
import com.org.triptrip.activity.ServiceDetailActivity;
import com.org.triptrip.common.Item;
import com.org.triptrip.common.ServiceItem;
import com.org.triptrip.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huy Nguyen
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> implements OnItemClickListener {

    private List<ServiceItem> services = new ArrayList<ServiceItem>();
    private Activity activity;


    public ServicesAdapter(List<ServiceItem> services, Activity activity) {
        this.services = services;
        this.activity = activity;
    }

    public List<ServiceItem> getServices() {
        return services;
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

        for (int i = 0; i < this.services.get(position).getRating(); i++) {
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
                onItemClick(services.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    @Override
    public void onItemClick(Item item) {
        Intent myIntent = new Intent(this.activity, ServiceDetailActivity.class);
        this.activity.startActivity(myIntent);
    }


}
