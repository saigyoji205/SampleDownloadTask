package com.example.hirokazu.sampledownloadtask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hirokazu.sampledownloadtask.Activity.TopListActivity;
import com.example.hirokazu.sampledownloadtask.Model.Model;
import com.example.hirokazu.sampledownloadtask.R;

import java.util.ArrayList;

/**
 * Created by Hirokazu on 2016/06/12.
 */
public class TopListAdapter extends ArrayAdapter{

    private ArrayList mItems;
    private LayoutInflater mInflater;
    public TopListAdapter(Context context, int resource, ArrayList items) {
        super(context, resource, items);
        this.mItems = items;
        this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(convertView != null){
            view = convertView;
        }else {
            view = mInflater.inflate(R.layout.list_item,null);
        }
        view.setBackgroundResource(R.drawable.back);
        Object object = getItem(position);

        if(object instanceof Model){
            if(mItems != null){
                TextView screenName = (TextView)view.findViewById(R.id.topText);
                TextView text = (TextView) view.findViewById(R.id.bottomText);
                if(screenName!=null){
                    screenName.setText(((Model) object).getScreenName());
                }
                if(text!=null){
                    text.setText(((Model)object).getText());
                }
            }
        }
        return view;
    }
}
