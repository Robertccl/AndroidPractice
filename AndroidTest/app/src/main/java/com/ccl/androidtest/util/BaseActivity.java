package com.ccl.androidtest.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ccl.androidtest.util.ActivityController;

/**
 * Created by CCL on 2016/12/7.
 */

public class BaseActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
