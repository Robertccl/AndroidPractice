package com.ccl.androidtest.intentTest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ccl.androidtest.util.BaseActivity;
import com.ccl.androidtest.R;

/**
 * Created by CCL on 2016/12/7.
 */

public class FirstActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏标题栏
        setContentView(R.layout.activity_first);
        Button button1 = (Button) findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String data="Hello SecondActivity";

                //Toast.makeText(FirstActivity.this,"You clicked Buttton 1", Toast.LENGTH_SHORT).show();
                //finish();         //结束当前活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);     //显示跳转
                /*
                隐式跳转,指定一系列更为抽象的action和category等信息，只有action标签和category标签的内容都完全匹配才会跳转
                android.intent.category.DEFAULT，是一种默认的category，在调用startActivity方法时会自动添加；
                要定义自己的category，可以再addCategory时添加进去，就可以匹配到了

                 */
                //Intent intent = new Intent("com.example.ccl.activitytest.ACTION_START");
                //intent.addCategory("android.intent.category.MY_CATEGORY");

                /*
                这里我们首先指定Intent的action是Intent.ACTION_VIEW，这是一个android系统的内置动作
                ，然后通过URiri.parse（）,将一个网址字符串解析成一个Uri对象，在调用Intent的setData()，方法将这个Uri对象传进去,这个方法接收一个Uri对象，指定当前Intent正在操作的对象
                运行界面发现他打开了系统浏览器,
                与setData对应可以在<intent_filter>标签在配置一个<data>标签，用于更精确的指定当前活动能够响应什么类型的数据，可以配置以下内容
                android:scheme 指定数据协议部分，如http
                android:host 指定数据主机名部分，如www.baidu.com
                android:port 指定数据端口部分，跟在主机后面
                andriod:path  路径，跟在端口后面
                android:mimeType   用于制定可以处理的数据类型，允许使用通配符的方式指定


                 */
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));

                /*
                Intent.ACTION_DIAL是android的一个内置动作，
                以下可以跳转到拨电话的界面

                 */
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                /*
                以下代码用于向下一个活动传数据

                 */
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
                //startActivity(intent);

            }
        });
    }

/*
onCreateOptionsMenu重写，通过getMenuInflater,得到menuInflater对象，
在调用他的inflate方法给当前活动创建菜单

 */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
/*
onOptionsItemSelected定义菜单响应事件

 */
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked ADD", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    /*
    当有活动通过intent的setResult方法向当前活动返回数据时，会调用该方法，重写该方法即可获得返回的数据
    例如secondactivity中的button2事件

     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK ){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }

    }
}
