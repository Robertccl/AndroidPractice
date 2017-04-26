package com.ccl.mydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ccl.mydemo.util.BaseActivity;

/**
 * Created by CCL on 2016/12/3.
 */

public class SuccessActivity extends BaseActivity {

    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Intent intent=getIntent();
        String responseData=intent.getStringExtra("response");
        responseText = (TextView) findViewById(R.id.text_view_success);//一个TextView
        responseText.setText(responseData);
    }

    public static void actionStart(Context context, String Response) {
        Intent intent = new Intent(context, SuccessActivity.class);
        intent.putExtra("response", Response);
        context.startActivity(intent);
    }

}
