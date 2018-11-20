package com.org.triptrip.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.org.triptrip.R;
import com.org.triptrip.adapter.OrderSpinnerAdapter;
import com.org.triptrip.common.OrderItem;
import com.org.triptrip.fragment.EventMaterialFragment;
import com.org.triptrip.fragment.ExperienceMaterialFragment;
import com.org.triptrip.fragment.ServiceFilterFragment;
import com.org.triptrip.fragment.ServiceMaterialFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private static int navigationId = R.id.navigation_events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        switchFilterFragment(navigationId);
        /**
         * Load spinner
         */
        Spinner spin = (Spinner) findViewById(R.id.spinner_order);
        List<OrderItem> items = new ArrayList<OrderItem>();
        for (int i = 0; i < OrderItem.items.length; i++) {
            items.add(new OrderItem(OrderItem.items[i].getKeyword(), OrderItem.items[i].getImage(), OrderItem.items[i].getTitle()));
        }
        OrderSpinnerAdapter orderSpinnerAdapter = new OrderSpinnerAdapter(getApplicationContext(), items);
        spin.setAdapter(orderSpinnerAdapter);

        switchFragment(navigationId);
        bottomNavigationView.setSelectedItemId(navigationId);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        return switchFragment(item.getItemId());
                    }

                });

    }

    private boolean switchFilterFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        /*if (pos == R.id.navigation_events) {
            fragment = new EventMaterialFragment();
        } else if (pos == R.id.navigation_services) {
            fragment = new ServiceMaterialFragment();
        } else if (pos == R.id.navigation_experiences) {
            fragment = new ExperienceMaterialFragment();
        }*/
        fragment = new ServiceFilterFragment();
        if (fragment == null) {
            return false;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_service_filter, fragment)
                /*.addToBackStack(null)*/
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        return true;
    }

    private boolean switchFragment(int pos) {
        navigationId = pos;
        android.support.v4.app.Fragment fragment = null;
        if (pos == R.id.navigation_events) {
            fragment = new EventMaterialFragment();
        } else if (pos == R.id.navigation_services) {
            fragment = new ServiceMaterialFragment();
        } else if (pos == R.id.navigation_experiences) {
            fragment = new ExperienceMaterialFragment();
        }
        if (fragment == null) {
            return false;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_category_content, fragment)
                /*.addToBackStack(null)*/
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayAdapter mAdapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.months_array));
                mAdapter.getFilter().filter(newText);

                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }/* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
