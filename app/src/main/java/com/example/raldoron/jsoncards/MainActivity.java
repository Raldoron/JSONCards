package com.example.raldoron.jsoncards;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
