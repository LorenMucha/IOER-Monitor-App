package com.landusemonitor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.landusemonitor.rasterkarten.HomeFragment;
import com.landusemonitor.rasterkarten.RasterkartenFragment;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GPSManager gps = new GPSManager(
                MainActivity.this);
        gps.start();

        if (savedInstanceState == null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 =  getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();
        }

        // Fullscreen
        ImageButton fullscreen = (ImageButton)findViewById(R.id.fullscreen);
        final ImageButton close = new ImageButton(this);
        fullscreen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getSupportActionBar().hide();
                close.setBackgroundResource(R.drawable.fullscreen_exit);

                final FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
                FrameLayout.LayoutParams layoutParams = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT | Gravity.CENTER_HORIZONTAL);
                layoutParams.height = 48;
                layoutParams.width = 48;
                layoutParams.setMargins(0,5,5,0);
                close.setLayoutParams(layoutParams);
                frame.addView(close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                        getSupportActionBar().show();
                        frame.removeView(close);
                    }
                });
            }
        });

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        //Initializing NavigationView
        navigationView = (NavigationView)

                findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
                                                         {

                                                             // This method will trigger on item Click of navigation menu
                                                             @Override
                                                             public boolean onNavigationItemSelected(MenuItem menuItem) {
                                                                 //Checking if the item is in checked state or not, if not make it in checked state
                                                                 if (menuItem.isChecked())
                                                                     menuItem.setChecked(false);
                                                                 else menuItem.setChecked(true);
                                                                 //Closing drawer on item click
                                                                 drawerLayout.closeDrawers();
                                                                 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                                                                 //Check to see which item was being clicked and perform appropriate action
                                                                 switch (menuItem.getItemId()) {
                                                                     //Replacing the main content with ContentFragment Which is our Inbox View;
                                                                     case R.id.start:
                                                                         HomeFragment fragment = new HomeFragment();
                                                                         Bundle args = new Bundle();
                                                                         fragment.setArguments(args);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction.replace(R.id.frame, fragment,"home");
                                                                         fragmentTransaction.commit();
                                                                         return true;
                                                                     case R.id.raster:
                                                                         RasterkarenChoiceFragment fragment1 = new RasterkarenChoiceFragment();
                                                                         Bundle args1 = new Bundle();
                                                                         fragment1.setArguments(args1);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction1.replace(R.id.frame, fragment1,"raster_choice");
                                                                         fragmentTransaction1.commit();
                                                                         return true;
                                                                     case R.id.wfs:
                                                                         Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ioer-monitor.de/karten/karten"));
                                                                         startActivity(browserIntent);
                                                                         return true;
                                                                     case R.id.indikatoren:
                                                                         IndikatorenFragment fragment2 = new IndikatorenFragment();
                                                                         Bundle args2 = new Bundle();
                                                                         fragment2.setArguments(args2);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction2.replace(R.id.frame, fragment2,"indi");
                                                                         fragmentTransaction2.commit();
                                                                         return true;
                                                                     case R.id.flaechenschema:
                                                                         MethodikFragment fragment3 = new MethodikFragment();
                                                                         Bundle args3 = new Bundle();
                                                                         fragment3.setArguments(args3);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction3.replace(R.id.frame, fragment3,"methodik");
                                                                         fragmentTransaction3.commit();
                                                                         return true;
                                                                     case R.id.glossar:
                                                                         GlossarFragment fragment4 = new GlossarFragment();
                                                                         Bundle args4 = new Bundle();
                                                                         fragment4.setArguments(args4);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction4.replace(R.id.frame, fragment4,"glossar");
                                                                         fragmentTransaction4.commit();
                                                                         return true;
                                                                     case R.id.service:
                                                                         ServiceFragment fragment5 = new ServiceFragment();
                                                                         Bundle args5 = new Bundle();
                                                                         fragment5.setArguments(args5);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction5.replace(R.id.frame, fragment5,"service");
                                                                         fragmentTransaction5.commit();
                                                                         return true;
                                                                     case R.id.exit:
                                                                         new AlertDialog.Builder(MainActivity.this)
                                                                                 .setIcon(android.R.drawable.ic_dialog_alert)
                                                                                 .setTitle("Beenden der App")
                                                                                 .setMessage("Wollen Sie die App beenden?")
                                                                                 .setPositiveButton("Ja", new DialogInterface.OnClickListener()
                                                                                 {
                                                                                     @Override
                                                                                     public void onClick(DialogInterface dialog, int which) {
                                                                                         finish();
                                                                                     }

                                                                                 })
                                                                                 .setNegativeButton("Nein", null)
                                                                                 .show();
                                                                         return true;
                                                                     default:
                                                                         RasterkartenFragment fragment6 = new RasterkartenFragment();
                                                                         Bundle args6 = new Bundle();
                                                                         fragment6.setArguments(args6);
                                                                         android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                                                                         fragmentTransaction6.replace(R.id.frame, fragment6);
                                                                         fragmentTransaction6.commit();
                                                                         return true;
                                                                 }
                                                             }
                                                         }

        );

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout)

                findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

    @Override
    protected void onStart(){
        super.onStart();
        System.out.println("####################################################################################### onStart");

        String latestVersion = "";
        String currentVersion = getCurrentVersion();
        System.out.println("Update Check====================================" + "Current version = " + currentVersion);
        try {
            latestVersion = new GetLatestVersion().execute().get();
            System.out.println("Update Check====================================" + "Latest version = " + latestVersion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //If the versions are not the same
        if(!currentVersion.equals(latestVersion)){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ein Update der App ist vorhanden");
            builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Click button action
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.landusemonitor")));
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Cancel button action
                }
            });

            builder.setCancelable(false);
            builder.show();
        }

    }

    @Override
    protected  void onResume() {
        super.onResume();

        System.out.println("####################################################################################### onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("####################################################################################### onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("####################################################################################### onStop");

    }

    @Override
    protected void  onDestroy(){
        super.onDestroy();

        System.out.println("####################################################################################### onDestroy");

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("home") != null) {
            WebView webView = (WebView) findViewById(R.id.webPage);
            if (webView.canGoBack()) {
                webView.goBack();
                System.out.println("####################################################################################### Methodik on back Press");
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Möchten Sie die Anwendung beenden");
                builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
            }
        } else if (getSupportFragmentManager().findFragmentByTag("raster_choice") != null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();
        }else if (getSupportFragmentManager().findFragmentByTag("raster") != null) {
            WebView webView = (WebView) findViewById(R.id.webPage);
            if (webView.canGoBack()) {
                webView.goBack();
                System.out.println("####################################################################################### Raster on back Press");
            } else {
                HomeFragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction6.replace(R.id.frame, fragment, "home");
                fragmentTransaction6.commit();
            }
        }else if (getSupportFragmentManager().findFragmentByTag("indi") != null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();
        }
        else if (getSupportFragmentManager().findFragmentByTag("tools") != null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();

        }else if (getSupportFragmentManager().findFragmentByTag("methodik") != null) {
            WebView webView = (WebView) findViewById(R.id.table);
            if (webView.canGoBack()) {
                webView.goBack();
                System.out.println("####################################################################################### Raster on back Press");
            } else {
                HomeFragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction6.replace(R.id.frame, fragment, "home");
                fragmentTransaction6.commit();
            }
        }else if (getSupportFragmentManager().findFragmentByTag("glossar") != null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();
        }else if (getSupportFragmentManager().findFragmentByTag("service") != null) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            android.support.v4.app.FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction6.replace(R.id.frame, fragment, "home");
            fragmentTransaction6.commit();
        }
    }
    // check for Updates
    private String getCurrentVersion(){
        PackageManager pm = this.getPackageManager();
        PackageInfo pInfo = null;

        try {
            pInfo =  pm.getPackageInfo(this.getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        String currentVersion = pInfo.versionName;

        return currentVersion;
    }
}