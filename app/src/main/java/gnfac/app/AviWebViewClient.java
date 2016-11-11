package gnfac.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;

/**
 * Created by mark on 11/11/16.
 */

public class AviWebViewClient extends WebViewClient
{
    Activity parent;

    public AviWebViewClient(Activity act)
    {
        super();
        parent = act;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("www.mtavalanche.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        parent.startActivity(intent);
        return true;
    }
}

