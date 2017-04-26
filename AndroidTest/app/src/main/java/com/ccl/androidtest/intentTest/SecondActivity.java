package com.ccl.androidtest.intentTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ccl.androidtest.util.BaseActivity;
import com.ccl.androidtest.R;

/**
 * Created by CCL on 2016/12/7.
 */

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*
                构建一个intent，仅用于传数据，把数据放在intent里面，调用setResult方法，该方法专门向上一个活动返回数据

                 */
                //Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                //intent.putExtra("data_return", "Hello FirstActivity");
                //setResult(RESULT_OK, intent);
                //finish(); //销毁当前活动
                //startActivity(intent);

            }

        });
        /*
        以下代码用于获取从firstactivity传来的数据
         */
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("SecondActivity", data);
    }

    /*
    启动活动的最佳写法
    这个方法完成了Intent的构建，将其封装进去，每当需要启动当前activity时调用该方法即可

    使用样例：
    SecondActivity.actionStart(FirstActivity.this, "data1", "data2");

     */
    public static void actionStart(Context context, String data1, String data2){
        Intent itent = new Intent(context, SecondActivity.class);
        itent.putExtra("param1", data1);
        itent.putExtra("param2", data2);
        context.startActivity(itent);
    }

}
