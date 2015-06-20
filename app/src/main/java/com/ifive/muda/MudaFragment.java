package com.ifive.muda;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MudaFragment extends Fragment {

    private MudaChishiki muda;
    private TextView title,content;

    public MudaFragment() {
        // Required empty public constructor
    }

    public static MudaFragment newInstance() {
        return new MudaFragment();
    }

    public void setMudaChishiki(MudaChishiki muda) {
        this.muda = muda;
        muda.update(this);
    }

    public MudaChishiki getMudaChishiki() {
        return muda;
    }

    public void update() {
        title.setText(muda.title);
        content.setText(muda.content);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        muda = new MudaChishiki(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_muda, container, false);
        title = (TextView)rootView.findViewById(R.id.title);
        content = (TextView)rootView.findViewById(R.id.content);

        return rootView;
    }

}
