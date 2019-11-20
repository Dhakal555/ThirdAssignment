package com.example.esoftwarica.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.esoftwarica.R;


public class Fragment_AboutUs extends Fragment {
    WebView webView;
    ProgressBar pBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__about_us, container, false);

        pBar = view.findViewById(R.id.proWebView);



        webView = view.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true); // this helps to enable java script
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pBar.setVisibility(view.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pBar.setVisibility(view.GONE);
            }

        }); // it helps to open url to the application
        webView.loadUrl("https://softwarica.edu.np/");
        return view;
    }
}
