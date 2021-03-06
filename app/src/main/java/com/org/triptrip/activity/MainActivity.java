package com.org.triptrip.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.org.triptrip.R;
import com.org.triptrip.fragment.ContentFragment;
import com.org.triptrip.fragment.FilterFragment;

/**
 * Main activity
 * @author Huy Nguyen
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FilterFragment.OnFilterItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    DrawerLayout drawer;
    private static int navigationId = R.id.navigation_events;
    private static int categoryId = 0;
    private static int orderId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);

        // Initial DrawerLayout
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Load filter fragment
        loadFilterFragment();

        // Load main content
        loadContentFragment();

        // Load bottom navigation
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNavigationView.setSelectedItemId(navigationId);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        navigationId = item.getItemId();
                        return loadContentFragment();
                    }

                });

    }


    /**
     * Load filter fragment
     * @return true/false
     */
    private boolean loadFilterFragment() {
        android.support.v4.app.Fragment fragment = null;
        fragment = new FilterFragment();
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

    /**
     * Load content fragment
     * @return
     */
    private boolean loadContentFragment() {
        ContentFragment contentFragment = new ContentFragment();
        if (contentFragment == null) {
            return false;
        }
        contentFragment.setNavigationId(navigationId);
        contentFragment.setCategoryId(categoryId);
        contentFragment.setOrderId(orderId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main_content, contentFragment)
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
        switch (id) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_information) {

        } else if (id == R.id.navigation_experiences) {

        } else if (id == R.id.nav_articles) {

        } else if (id == R.id.nav_events) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSpinnerItemSelected(int id) {
        orderId = id;
        loadContentFragment();
    }

    @Override
    public void onRecyclerViewItemSelected(int id) {
        categoryId = id;
        loadContentFragment();
    }
}
