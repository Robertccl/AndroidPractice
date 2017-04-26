package com.ccl.androidtest.fragment.FragmentBestPractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ccl.androidtest.R;

import java.util.List;

/**
 * Created by CCL on 2016/12/10.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private int resourceId;

    public NewsAdapter(Context context, int textViewResourceId, List<News> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else {
            view = convertView;
        }
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        Log.i("list",news.getTitle());
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
