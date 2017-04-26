package com.ccl.mydemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccl.mydemo.R;

/**
 * Created by CCL on 2016/12/10.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent){
        Log.i("ccl", "nice");
        View visibilitLayout = view.findViewById(R.id.visibility_layout);
        visibilitLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);
        Log.i("ccl", newsTitle);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);

    }

}
