package com.jodygeers.webfrag.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jodygeers.webfrag.fragments.MenuFragment;
import com.jodygeers.webfrag.fragments.WelcomeFragment;


public class MainActivity extends FragmentActivity implements MenuFragment.OnMenuItemSelected {

    /**
     * Main(); app bootstrap
     * @param savedInstanceState
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // Stop overlapping ui updates
        if ( savedInstanceState != null ) return;

        setUi();

    }

    /**
     * Sets the init UI
     */
    private void setUi() {

        // small display only adds menu
        getSupportFragmentManager().beginTransaction().replace(
            R.id.fragment_menu,
            new MenuFragment()
        ).commit();

        // large display
        if ( findViewById( R.id.fragment_content ) != null ) {

            getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_content,
                new WelcomeFragment()
            ).commit();

        }

    }

    /**
     * Updates UI
     * @param string - context of menu selection
     */
    @Override
    public void menuItemSelected( String string ) {

        Toast.makeText( getApplication(), string, Toast.LENGTH_LONG ).show();

        Object frag = null;
        try {

            frag = Class.forName( string ).newInstance();

        } catch ( Exception e ) {

            e.printStackTrace();

        }

        // large display - add welcome
        if ( findViewById( R.id.fragment_content ) != null ) {

            getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_content,
                ( Fragment ) frag
            ).commit();

            return;
        }

        // small - add menu
        getSupportFragmentManager().beginTransaction().replace(
            R.id.fragment_menu,
            ( Fragment ) frag
        ).commit();

    }

    /**
     * Insted of closing app
     */
    @Override
    public void onBackPressed() {

        // super.onBackPressed();

        setUi();

    }

}