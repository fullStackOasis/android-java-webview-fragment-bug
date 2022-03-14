# Android Java Mobile App with a WebView in a Fragment

This project can be used to debug problems when displaying a WebView in a Fragment.

Some websites just don't load in this demo.

Some load, but widgets like menu drawers do not display properly.

If you choose to load up https://amazon.com you will see a hamburger menu in the upper left corner. 
The hamburger menu does not function. 
When you click on it, the screen just goes blank.

## Attempts to Fix Hamburger Menu Bug

Here's a list of things that were tried to fix the issue, but did not work:

* In `main_fragment.xml`, completely remove the surrounding `ScrollView`.
Change app:layout_constraintBottom_toTopOf="parent" in `LinearLayout`.
* Tried adding a whole slew of settings to the `WebView`:
```
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
```
* Tried changing the User Agent string in various ways:
```
       String ua =  "Mozilla/5.0 (Linux; Android 10; SM-A205U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.48 Mobile Safari/537.36";
       webSettings.setUserAgentString(ua);
```
* Tried using a `WebViewController` as the `WebViewClient`.
* Tried using a `WebChromeClient` as the  `WebViewClient`.
* Tried moving `myWebView.loadUrl(myurl)` before and after applying settings.

[StackOverflow link to question from someone else about "Activity webview and Fragment Webview different behaviour"](https://stackoverflow.com/questions/32140073/activity-webview-and-fragment-webview-different-behaviour)