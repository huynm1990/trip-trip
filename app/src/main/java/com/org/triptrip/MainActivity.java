package com.org.triptrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView androidGridView;

    String[] gridViewString = {
            "Events", "Experience", "Services", "Q&A"
    } ;


    int[] gridViewImageId = {
            R.drawable.travel_guideline,
            R.drawable.travel_experience,
            R.drawable.travel_services,
            R.drawable.travel_discussion
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
            if (i == 0) {
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            } else if (i == 1) {
                Intent intent = new Intent(MainActivity.this, ExperiencesActivity.class);
                startActivity(intent);
            } else if (i == 2) {
                Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                startActivity(intent);
            } else if (i == 3) {
                Intent intent = new Intent(MainActivity.this, QuestionsAnswersActivity.class);
                startActivity(intent);
            }

                /*Toast.makeText(MainActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_login) {
            // call Log in activity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.action_register) {
            // call Register activity
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
