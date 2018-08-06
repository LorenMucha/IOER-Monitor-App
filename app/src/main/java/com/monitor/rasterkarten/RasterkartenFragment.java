package com.monitor.rasterkarten;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.monitor.Connectivity_Manager;
import com.monitor.R;


public class RasterkartenFragment extends Fragment {

    private WebView webView;
    private String saved_url;
    private String saved_tag;
    String indikatorname;
    private JavaScriptInterface JSInterface;
    Bundle mBundle;

    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.karten_fragment, container, false);
        setHasOptionsMenu(true);

        mBundle = new Bundle();
        mBundle = getArguments();

        if(mBundle != null){
            Toast.makeText(getActivity(), mBundle.getString("rasterweite"), Toast.LENGTH_LONG).show();
        }else{

        }

        Connectivity_Manager cm = new Connectivity_Manager();
        if(!cm.isConnected(getActivity())) cm.buildDialog(getActivity()).show();

        webView = (WebView) v.findViewById(R.id.webPage);

       final ProgressBar progressBar = (ProgressBar)v.findViewById(R.id.progressBar);
        progressBar.setMax(100);

        webView.setScrollbarFadingEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            webView.getSettings().setDatabasePath("/data/data/" + webView.getContext().getPackageName() + "/databases/");
        }
        if (Build.VERSION.SDK_INT >= 11){
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        webView.loadUrl(savedInstanceState != null ? savedInstanceState.getString("kat") : mBundle.getString("kat"));

        JSInterface = new JavaScriptInterface(getActivity());
        webView.addJavascriptInterface(JSInterface, "JSInterface");
        indikatorname = mBundle.getString("tag");

        webView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {}

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                progressBar.setProgress(100);

                //Save the URL
                saved_tag = mBundle.getString("tag");
                saved_url = webView.getUrl();
                SharedPreferences prefs = PreferenceManager
                        .getDefaultSharedPreferences(getActivity().getApplicationContext());
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("SAVE_URL", saved_url);
                edit.putString("SAVE_TAG",saved_tag);
                edit.commit();

                System.out.println("Saved URL===================="+saved_url);

            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
            }
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith("http://www.ioer-monitor.de/karten/karten/")) {
                    view.getContext().startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                } else {
                    view.loadUrl(url);
                    return false;
                }
            }
        });
        webView.getSettings().setGeolocationEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {

            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
            }

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
        return v;
    }
    // speichert die aktuelle URL, welche bei einer drehung des Displays abgerufen wird
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Bundle zBundle = new Bundle();
        zBundle = getArguments();
        outState.putString("kat", zBundle.getString("kat"));
        super.onSaveInstanceState(outState);
    }

    public class JavaScriptInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        JavaScriptInterface(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public String getIndikatorName()
        {
            // Here call any of the public activity methods....
            return indikatorname;
        }
    }

}

