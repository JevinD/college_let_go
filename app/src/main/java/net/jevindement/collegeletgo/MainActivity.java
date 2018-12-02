package net.jevindement.collegeletgo;
/**
 * Description: MainActivity is in charge of the menu navigation bar
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        //default screen is the home screen
        loadFragment(new HomeFragment());
    }

    /**
     * replaces current screen with the new screen while still keeping the nav menu
     * @param fragment- certain item clicked
     * @return returns false after checking if fragment isnt null
     */
    private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fragment_container,fragment)
                   .commit();
        }
        return false;
    }

    /**
     * Description: Checks to see which menu item is being clicked
     * and then loads that layout
     * @param menuItem (menu navigation bar)
     * @return loadFragment(specific screen)
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        Fragment fragment = null;
        switch (menuItem.getItemId())
        {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_sell:
                fragment = new SellFragment();
                break;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
