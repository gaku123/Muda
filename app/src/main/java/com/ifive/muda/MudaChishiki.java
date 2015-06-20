package com.ifive.muda;

import android.os.Handler;
import android.util.Xml;

import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gaku on 2015/06/20.
 */
public class MudaChishiki implements Runnable {
    public String title;
    public String content;

    private MudaFragment mf;

    Handler mHandler = new Handler();

    public MudaChishiki(MudaFragment mf) {
        this.mf = mf;
        new Thread(this).start();
    }

    public void update(MudaFragment mf) {
        this.mf = mf;
    }

    @Override
    public void run() {

        try {
            String json = httpGet("https://ja.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exintro=&explaintext=&indexpageids=&generator=random&grnnamespace=0");
            JSONObject jsonObject = new JSONObject(json);
            String id = jsonObject.getJSONObject("query").getJSONArray("pageids").getString(0);
            JSONObject tmp = jsonObject.getJSONObject("query").getJSONObject("pages").getJSONObject(id);
            title = tmp.getString("title");
            content = tmp.getString("extract");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mf.update();
            }
        });
    }


    public static String httpGet(String strURL) {

        HttpURLConnection connection = null;
        try {
            URL url = new URL(strURL);
            connection = (HttpURLConnection)url.openConnection();
            InputStream stream = new BufferedInputStream(connection.getInputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(stream));
            String data = "";
            String tmp;
            while ((tmp = input.readLine()) != null) {
                data += tmp;
            }
            stream.close();
            input.close();
            return data;
        } catch (Exception e) {
            return e.toString();
        } finally {
            connection.disconnect();
        }
    }

}
