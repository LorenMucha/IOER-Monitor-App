package com.landusemonitor;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Loren on 18.04.2016.
 */
class GetLatestVersion extends AsyncTask<String, String, String> {
    String latestVersion;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            //It retrieves the latest version by scraping the content of current version from play store at runtime
            String urlOfAppFromPlayStore = "https://play.google.com/store/apps/details?id=com.landusemonitor";
            Document doc = Jsoup.connect(urlOfAppFromPlayStore).get();
            latestVersion = doc.getElementsByAttributeValue("itemprop","softwareVersion").first().text();

        }catch (Exception e){
            e.printStackTrace();

        }

        return latestVersion;
    }
}