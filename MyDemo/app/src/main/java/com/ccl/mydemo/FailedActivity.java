package com.ccl.mydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ccl.mydemo.util.BaseActivity;

/**
 * Created by CCL on 2016/12/3.
 */

public class FailedActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);
    }

    public static void actionStart(Context context, String Response) {
        Intent intent = new Intent(context, SuccessActivity.class);
        intent.putExtra("response", Response);
        context.startActivity(intent);
    }
}
