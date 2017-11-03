package com.example.raldoron.jsoncards;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private int currentFragment;

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectivityManager = (ConnectivityManager) getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo == null || !networkInfo.isConnectedOrConnecting()){
            Toast.makeText(getBaseContext(), "Internet is not available!", Toast.LENGTH_LONG).show();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, CardsFragment.getInstance());
        transaction.commitAllowingStateLoss();
        currentFragment = 1;

        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab_cards:
                                if (currentFragment != 1) {
                                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                    transaction.replace(R.id.content, CardsFragment.getInstance());
                                    transaction.commitAllowingStateLoss();
                                    currentFragment = 1;
                                }
                                break;
                            case R.id.tab_contact:
                                if (currentFragment != 2) {
                                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                    transaction.replace(R.id.content, ContactsFragment.getInstance());
                                    transaction.commitAllowingStateLoss();
                                    currentFragment = 2;
                                }
                                break;
                        }
                        return false;
                    }
                });


    }
}
