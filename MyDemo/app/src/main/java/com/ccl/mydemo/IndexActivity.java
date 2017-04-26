package com.ccl.mydemo;

import android.os.Bundle;

import com.ccl.mydemo.util.BaseActivity;

/**
 * Created by CCL on 2016/12/10.
 */

public class IndexActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);
    }
}
