package store.theimitation.theimitationstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import store.theimitation.util.AndroidNetworkUtility;
import store.theimitation.util.ProductAsyncTask;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworkUtility androidNetworkUtility = new AndroidNetworkUtility();
        if (androidNetworkUtility.isConnected(this)) {
            Log.i(TAG, "Connected.");
            new ProductAsyncTask().execute(this);
        } else {
            Log.v(TAG, "Network not Available!");
        }
    }
}
