package com.fullstackoasis.webviewfragmentdemo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fullstackoasis.webviewfragmentdemo.R;

import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getCanonicalName();
    private MainViewModel mViewModel;
    private String myurl;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myurl = "http://amazon.com/";
        // myurl = "https://nhlocalgrocer.com/";
        setUpWebView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }


    private void setUpWebView() {
        WebView myWebView = (WebView) getActivity().findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        // Experiment with user agent string
        // webSettings.setUserAgentString("Mozilla/5.0 (platform; rv:geckoversion) Gecko/geckotrail Firefox/firefoxversion");
        // webSettings.setUserAgentString("Mozilla/5.0 (platform; rv:geckoversion) Gecko/geckotrail Firefox/firefoxversion");
        // webSettings.setUserAgentString("AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75");
        // Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)
        // webSettings.setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)");
        // This one works exactly as expected.
        String ua =  "Mozilla/5.0 (Linux; Android 10; SM-A205U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.48 Mobile Safari/537.36";
        webSettings.setUserAgentString(ua);

        if (2 == 1) {
            applyWebViewClient(myWebView);
        } else {
            applyWebViewController(myWebView);
            //applyWebChromeClient(myWebView);
        }
        myWebView.loadUrl(myurl);

    }
    public class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(TAG, "loading url " + url);
            // view.loadUrl(url);
            return false;
        }
    }

    private void applyWebViewController(WebView myWebView) {
        myWebView.setWebViewClient(new WebViewController());
    }
    private void applyWebViewClient(WebView myWebView) {
        myWebView.setWebViewClient(new WebViewClient());
    }

    private void applyWebChromeClient(WebView myWebView) {
        myWebView.setWebChromeClient(new WebChromeClient());/* {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d(TAG, consoleMessage.message() + " : line : "
                        + consoleMessage.lineNumber() + " : source : "
                        + consoleMessage.sourceId());
                return super.onConsoleMessage(consoleMessage);
            }
        });*/
    }
}