package com.hyein.stockfish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyein.stockfish.R;
import com.hyein.stockfish.model.Item;
import com.hyein.stockfish.network.HttpClient;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by nolgong-hyein on 2016. 12. 23..
 */

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Item> data;

    public ItemAdapter(Context context, int layout, ArrayList<Item> data){
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;

    }
    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public String getItem(int position){return data.get(position).getName();}
    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.cellItemImageView);
        Glide.with(context).load(HttpClient.getAddress()+"/static/images/"+data.get(position).getFileName())
                .into(imageView);
//        imageView.setImageResource(R.drawable.test_img);

        TextView textView = (TextView)convertView.findViewById(R.id.cellItemTextView);
        textView.setText(data.get(position).getName());

        return convertView;
    }
}
