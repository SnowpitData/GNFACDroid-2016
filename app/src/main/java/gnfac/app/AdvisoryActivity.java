/**
 * @(#)AdvisoryActivity.java
 *
 *
 * @author 
 * @version 1.00 2013/6/10
 */
package gnfac.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class AdvisoryActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.advisory_title));
        setContentView(R.layout.web_view);
        WebView wv = (WebView)findViewById(R.id.webview);
        wv.loadUrl("http://www.mtavalanche.com/current?theme=mobile_simple");
    }
}