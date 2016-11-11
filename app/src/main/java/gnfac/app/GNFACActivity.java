package gnfac.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.widget.ScrollView;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GNFACActivity extends Activity implements View.OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.main_title));
        setContentView(R.layout.main);
        findViewById(R.id.advisory).setOnClickListener(this);
        findViewById(R.id.photos).setOnClickListener(this);
        findViewById(R.id.videos).setOnClickListener(this);
        findViewById(R.id.weather).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.full_site).setOnClickListener(this);
        WebView map = (WebView) findViewById(R.id.map);
        map.getSettings().setJavaScriptEnabled(true);
        map.loadUrl("http://national-map.jhavalanche.org/iframe.php?center=GNFAC");
		map.setWebViewClient(new AviWebViewClient(this));
        ScrollView scroller = (ScrollView) findViewById(R.id.scroller);
        scroller.scrollTo(0, 0);
        
    }
    
    public void onClick(View v) 
    {
    	Intent intent1 = new Intent();
    	int id = v.getId();
    	switch (id)
    	{
    		case R.id.advisory:
        		intent1.setClassName("gnfac.app", "gnfac.app.AdvisoryActivity");
    			break;
    		case R.id.photos:
        		intent1.setClassName("gnfac.app", "gnfac.app.PhotoActivity");
    			break;
    		case R.id.videos:
        		intent1.setClassName("gnfac.app", "gnfac.app.VideoActivity");
    			break;
    		case R.id.weather:
        		intent1.setClassName("gnfac.app", "gnfac.app.WeatherActivity");
    			break;
    		case R.id.submit:
				//intent1.setClassName("gnfac.app", "gnfac.app.SubmitActivity");
				//break;
    			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mtavalanche.com/node/add/snow-observations")));
    			return;
    		case R.id.full_site:
    			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mtavalanche.com")));
    			return;
    	}
    	startActivity(intent1);
    }
}
