package com.jodygeers.webfrag.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;

import com.jodygeers.webfrag.app.R;
import com.jodygeers.webfrag.utils.Browser;

/**
 * Application menu
 */
public class MenuFragment extends Fragment {

    OnMenuItemSelected onMenuItemSelected;

    /**
     * Must implement this to handle ui interaction
     */
    public interface OnMenuItemSelected {

        public void menuItemSelected( String string );

    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View fragment_menu
     */
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        return inflater.inflate( R.layout.fragment_menu, container, false );

    }

    /**
     * Appends HTML Dom to webkit
     */
    @Override
    public void onStart() {

        super.onStart();

        new Browser( getActivity(), R.id.fragment_menu_webview, "file:///android_asset/fragment_menu.html", new JavaScriptInterface() );

    }

    /**
     * Access calling supers OnMenuItemSelected implementation
     * @param activity
     */
    @Override
    public void onAttach( Activity activity ) {

        super.onAttach(activity);

        onMenuItemSelected = ( OnMenuItemSelected ) activity;

    }

    /**
     * View Model for Javascript
     */
    public class JavaScriptInterface {

        private String blueFragment = "com.jodygeers.webfrag.fragments.BlueFragment";
        private String redFragment = "com.jodygeers.webfrag.fragments.RedFragment";

        @JavascriptInterface
        public String getBlueFragment() {

            return blueFragment;

        }

        @JavascriptInterface
        public void setBlueFragment( String blueFragment ) {

            blueFragment = blueFragment;

        }

        @JavascriptInterface
        public String getRedFragment() {

            return redFragment;

        }

        @JavascriptInterface
        public void setRedFragment( String redFragment ) {

            redFragment = redFragment;

        }

        @JavascriptInterface
        public void updateUi( String string ) {

            onMenuItemSelected.menuItemSelected( string );

        };

    }

}