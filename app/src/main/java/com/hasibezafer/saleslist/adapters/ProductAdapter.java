package com.hasibezafer.saleslist.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hasibezafer.saleslist.R;
import com.hasibezafer.saleslist.models.Product;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by hasibezafer on 28.12.2017.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    ArrayList<Product> productList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public ProductAdapter(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        productList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.ivProductImage = (ImageView) v.findViewById(R.id.ivProductImage);
            holder.tvProductName = (TextView) v.findViewById(R.id.tvProductName);
            holder.tvProductPrice = (TextView) v.findViewById(R.id.tvProductPrice);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        new DownloadImageTask(holder.ivProductImage).execute(productList.get(position).getProductImage());
        holder.tvProductName.setText(productList.get(position).getProductName());
        holder.tvProductPrice.setText(productList.get(position).getProductPrice());

        return v;

    }

    static class ViewHolder {
        public ImageView ivProductImage;
        public TextView tvProductName;
        public TextView tvProductPrice;


    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }
}
