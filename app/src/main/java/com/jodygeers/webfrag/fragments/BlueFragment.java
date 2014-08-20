package com.jodygeers.webfrag.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jodygeers.webfrag.app.R;
import com.jodygeers.webfrag.utils.Browser;

public class BlueFragment extends Fragment {

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View fragment_blue
     */
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        return inflater.inflate( R.layout.fragment_blue, container, false );

    }

    /**
     * Appends HTML Dom to webkit
     */
    @Override
    public void onStart() {

        super.onStart();

        new Browser( getActivity(), R.id.fragment_blue_webview, "file:///android_asset/fragment_blue.html", null );

    }

}