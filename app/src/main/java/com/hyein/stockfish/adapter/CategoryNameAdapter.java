package com.hyein.stockfish.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hyein.stockfish.R;
import com.hyein.stockfish.model.Category;

import java.util.ArrayList;

/**
 * Created by nolgong-hyein on 2016. 12. 22..
 */

public class CategoryNameAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Category> data;

    public CategoryNameAdapter(Context context, int layout, ArrayList<Category> data){
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
        TextView textView = (TextView)convertView.findViewById(R.id.cellCategoryTextView);
        textView.setText(data.get(position).getName());

        return convertView;
    }
}
