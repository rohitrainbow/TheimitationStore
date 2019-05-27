package store.theimitation.service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.client.methods.HttpGet;

import java.util.ArrayList;

import store.theimitation.dto.Product;
import store.theimitation.util.AndroidNetworkUtility;

public class ProductService {
    private static final String TAG = "ProductService";

    private static final String PRODUCT_WEB_SERVICE_URL = "http://www.theimitation.store/api/products";

    public ArrayList<Product> getProducts() {
        Log.i(TAG, "getProducts ......");
        ArrayList<Product> productList = null;
        HttpGet httpGet = new HttpGet(PRODUCT_WEB_SERVICE_URL);

        //setting header to request for a JSON response
        httpGet.setHeader("Accept", "application/json");
        AndroidNetworkUtility httpUtil = new AndroidNetworkUtility();
        String productJSONStr = httpUtil.getHttpResponse(httpGet);
        Log.d(TAG, "Response: " + productJSONStr);
        productList = convertJson(productJSONStr);
        return productList;
    }

    private ArrayList<Product> convertJson(String productJSONStr) {
        ArrayList<Product> productList = null;
        if (productJSONStr != null && productJSONStr.length() > 0) {
            try {
                Gson gson = new Gson();
                productList =
                        gson.fromJson(productJSONStr, new TypeToken<ArrayList<Product>>() {
                        }.getType());
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}