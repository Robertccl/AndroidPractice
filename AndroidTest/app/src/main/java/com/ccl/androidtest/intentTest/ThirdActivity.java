package com.ccl.androidtest.intentTest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ccl.androidtest.util.ActivityController;
import com.ccl.androidtest.util.BaseActivity;
import com.ccl.androidtest.R;

/**
 * Created by CCL on 2016/12/7.
 */

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity", "Task id is" + getTaskId());
        setContentView(R.layout.activity_third);

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ActivityController.finishAll();
            }
        });
    }
}
