package store.theimitation.util;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import store.theimitation.dto.Product;
import store.theimitation.service.ProductService;
import store.theimitation.theimitationstore.R;

public class ProductAsyncTask extends AsyncTask<Object, Void, ArrayList<Product>> {
    Activity callerActivity;
    private Context mContext;
    private ProductArrayAdapter productArrayAdapter;
    private ListView listView;

    private static final String TAG = "ProductAsyncTask";

    @Override
    protected ArrayList<Product> doInBackground(Object... params) {
        Log.i(TAG, "doing in background :) ");
        ArrayList<Product> productList = null;
        mContext = (Context) params[0];
        callerActivity = (Activity) params[0];
        ProductService productService = new ProductService();
        Log.i(TAG, "ProductService instantiated .....................");
        productList = productService.getProducts();
        Log.d(TAG, "COUNT: " + productList.size());
        return productList;
    }

    @Override
    protected void onPostExecute(ArrayList<Product> productList) {

        listView = (ListView) callerActivity.findViewById(R.id.prodsLV);
        productArrayAdapter = new ProductArrayAdapter(mContext, R.layout.listview_row_layout);

        for (Product product : productList) {
            productArrayAdapter.add(product);
        }
        listView.setAdapter(productArrayAdapter);
    }
}
