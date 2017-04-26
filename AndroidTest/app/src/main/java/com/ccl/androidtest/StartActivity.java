package com.ccl.androidtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ccl.androidtest.listViewTest.ListViewActivity;
import com.ccl.androidtest.util.BaseActivity;

/**
 * Created by CCL on 2016/12/7.
 */

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button = (Button) findViewById(R.id.listView_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ListViewActivity.actionStart(StartActivity.this);

            }

        });

        Button chatUIButton = (Button) findViewById(R.id.chatUI_btn);
        chatUIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                com.ccl.androidtest.chatUIPractice.MainActivity.actionStart(StartActivity.this);

            }
        });

        Button sqliteButton = (Button) findViewById(R.id.sqlitetest_btn);
        sqliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                com.ccl.androidtest.dataTest.SQLTestActivity.actionStart(StartActivity.this);

            }
        });

        Button fragButton = (Button) findViewById(R.id.fragtest_btn);
        sqliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                com.ccl.androidtest.fragment.FragmentBestPractice.NewsActivity.actionStart(StartActivity.this);

            }
        });


    }



}
