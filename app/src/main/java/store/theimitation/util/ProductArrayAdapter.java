package store.theimitation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import store.theimitation.dto.Product;
import store.theimitation.theimitationstore.R;

public class ProductArrayAdapter extends ArrayAdapter<Product> {
    private static final String IMAGE_WEB_SERVICE_URL = "http://www.theimitation.store/";
    private static final String TAG = "ProductArrayAdapter";
    private List<Product> productList = new ArrayList<Product>();

    static class ProductViewHolder {
        TextView id;
        TextView name;
        TextView price;
        ImageView productimage;
    }

    public ProductArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Product object) {
        productList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public Product getItem(int index) {
        return this.productList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProductViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_row_layout, parent, false);
            viewHolder = new ProductViewHolder();
            viewHolder.id = (TextView) row.findViewById(R.id.id);
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.price = (TextView) row.findViewById(R.id.price);
            viewHolder.productimage=(ImageView)row.findViewById(R.id.productimage);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ProductViewHolder) row.getTag();
        }
        Product product = getItem(position);
        viewHolder.id.setText(product.getId()+"");
        viewHolder.name.setText(product.getName());
        viewHolder.price.setText(product.getPrice()+"");
        Picasso.with(getContext()).load(IMAGE_WEB_SERVICE_URL+product.getPictureUrl()).into(viewHolder.productimage);
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
