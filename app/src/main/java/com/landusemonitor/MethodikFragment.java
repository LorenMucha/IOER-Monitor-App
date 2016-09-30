package com.landusemonitor;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;


public class MethodikFragment extends Fragment {

    //Defining Variables
    private static WebView webView;
    LinearLayout mLinearLayout;
    LinearLayout list;
    int count = 0;

    ScrollView methodik_ScrollView;
    TextView text_list_end;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_methodik, container, false);
        setHasOptionsMenu(true);

        TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);

        t.setText("Glossar");

        methodik_ScrollView = (ScrollView) v.findViewById(R.id.scoll_methodik);
        text_list_end = (TextView) v.findViewById(R.id.end_list);


        final ImageButton collapse_text = (ImageButton) v.findViewById(R.id.collapse_text);
        mLinearLayout = (LinearLayout) v.findViewById(R.id.text_methodik1);
        DocumentView dc = (DocumentView) v.findViewById(R.id.methodik_1);
        DocumentView dc2 = (DocumentView) v.findViewById(R.id.methodik_2);
        DocumentView dc3 = (DocumentView) v.findViewById(R.id.methodik_3);
        dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc2.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc3.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc.setText(getString(R.string.methodik_1));
        dc2.setText(getString(R.string.methodik_2));
        dc3.setText(getString(R.string.methodik_3));

        // fester Bestandteil
        DocumentView dc4 = (DocumentView) v.findViewById(R.id.methodik_4);
        DocumentView dc5 = (DocumentView) v.findViewById(R.id.methodik_5);
        dc4.setText(getString(R.string.methodik_4));
        dc5.setText(getString(R.string.methodik_5));

        collapse_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                if (count == 1) {
                    LinearLayout temp = (LinearLayout) mLinearLayout.findViewById(R.id.text_methodik1);
                    temp.setVisibility(View.GONE);
                    collapse_text.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_down));
                } else {
                    final LinearLayout temp_ll = (LinearLayout) mLinearLayout.findViewById(R.id.text_methodik1);
                    temp_ll.setVisibility(View.VISIBLE);
                    collapse_text.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_up));
                    count = 0;
                }
            }
        });

        final ImageButton collapse_list = (ImageButton) v.findViewById(R.id.collapse_list);
        list = (LinearLayout) v.findViewById(R.id.text_methodik2);
        list.setVisibility(View.GONE);
        collapse_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count == 1) {
                    list.setVisibility(View.VISIBLE);
                    collapse_list.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_up));
                    addTextToTextView();
                } else {
                    list.setVisibility(View.GONE);
                    collapse_list.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.arrow_down));
                    count = 0;
                }
            }
        });

        webView = (WebView) v.findViewById(R.id.table);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(savedInstanceState != null ? savedInstanceState.getString("url") : "file:///android_asset/flaechenschema.html");
        webView.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                viewx.loadUrl(urlx);
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            // Allow Geolocation
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }

            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!TextUtils.isEmpty(title)) {
                    TextView t = (TextView) getActivity().findViewById(R.id.toolbar_title);  //UPDATE
                    t.setText(title);
                    t.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    t.setFocusable(true);
                    t.setFocusableInTouchMode(true);
                    t.requestFocus();
                    t.setSingleLine(true);
                    t.setSelected(true);
                    t.setMarqueeRepeatLimit(-1);
                    ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);
                }
            }
        });
        webView.getSettings().setGeolocationEnabled(true);
        return v;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("url", webView.getUrl());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void addTextToTextView()
    {
        //INSTEAD, scroll all the way down with:
        methodik_ScrollView.post(new Runnable() {
            public void run() {
                methodik_ScrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

}

