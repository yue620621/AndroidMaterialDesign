package com.macyyue.materialdesign.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.util.*;
import com.macyyue.materialdesign.R;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.*;


//extends is for extending a class.
//implements is for implementing an interface
//The difference between an interface and a regular class is that in an interface you can not implement any of the declared methods. Only the class that "implements" the interface can implement the methods.
public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar yToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //----- Tool Bar -----
            yToolbar = (Toolbar) findViewById(R.id.toolbar);
            // setSupportActionBar() method sets the toolbar as the app bar for the activity
            setSupportActionBar(yToolbar);
            // getSupportActionBar() allows you to use any of the ActionBar methods to adjust the app bar
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setTitle("SuperCool");

        //------- Drawer Menu -----------
            drawerFragment = (FragmentDrawer)
                    getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), yToolbar);
            drawerFragment.setDrawerListener(this);

    }

    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Menu items click listener
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Log.i("YUE","click setting!");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position){
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch(position){
            case 0:
                fragment = new fragmentHome();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new fragmentFriend();
                title = getString(R.string.title_friends);
                break;
            case 2:
                fragment = new fragmentMessage();
                title = getString(R.string.title_messages);
                break;
            default:
                break;
        }

        if (fragment != null) {
            // FragmentManager is the interface for interacting with Fragment objects inside of an Activity
            // getSupportFragmentManager() method return the FragmentManager for interacting with fragments associated with this activity.
            FragmentManager fragmentManager = getSupportFragmentManager();
            // FragmentTransaction is API for performing a set of Fragment operations.
            // beginTransaction() Start a series of edit operations on the Fragments associated with this FragmentManager.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // replace(int containerViewId, Fragment fragment, String tag) Replace an existing fragment that was added to a container.
            fragmentTransaction.replace(R.id.container_body, fragment);
            // commit() Schedules a commit of this transaction.
            // Commit() is instantaneous but performs disk writes. If you are on the ui thread you should call apply() which is asynchronous.
            // Because disk writes is time consuming.
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

    }
}
