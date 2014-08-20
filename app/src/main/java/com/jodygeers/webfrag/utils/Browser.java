package com.jodygeers.webfrag.utils;

import android.app.Activity;
import android.graphics.Color;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.jodygeers.webfrag.app.R;

public class Browser {

    /**
     * Bind web content to android content
     * @param activity - current context
     * @param id - Android view id of where to load content
     * @param html - DOM to load
     * @param javaScriptInterface - Java class to be ultilized by javascript
     */
    public Browser( Activity activity, int id, String html, Object javaScriptInterface ) {

        WebView webView = ( WebView ) activity.findViewById( id );
            webView.setBackgroundColor( activity.getResources().getColor( R.color.dark_gray ) );
            webView.getSettings().setJavaScriptEnabled( true );
            webView.setWebChromeClient( new WebChromeClient() );
            webView.loadUrl( html );
            webView.addJavascriptInterface( javaScriptInterface, "androidInterface" );

    }

}
