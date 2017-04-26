package com.ccl.androidtest.fragment.FragmentBestPractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.ccl.androidtest.R;
import com.ccl.androidtest.listViewTest.ListViewActivity;
import com.ccl.androidtest.util.BaseActivity;

/**
 * Created by CCL on 2016/12/10.
 */

public class NewsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news);
    }

    public static void actionStart(Context context) {
        Intent itent = new Intent(context, NewsActivity.class);
        context.startActivity(itent);
    }
}
