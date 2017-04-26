package com.ccl.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ccl.mydemo.util.BaseActivity;
import com.ccl.mydemo.util.httpUtil.HttpCallbackListener;
import com.ccl.mydemo.util.httpUtil.HttpUtil;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button button;
    private EditText account;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.submit_btn);
        account = (EditText) findViewById(R.id.account_editText);
        passWord = (EditText) findViewById(R.id.passWord_editText);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String address = "http://192.168.43.145:8080/login.do";
        Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
        switch (v.getId()){
            case R.id.submit_btn:
                String userNumber = account.getText().toString();
                String pwd = passWord.getText().toString();
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("userNumber", userNumber);
                hashMap.put("passWord", pwd);
                //Toast.makeText(LoginActivity.this, userNumber+pwd, Toast.LENGTH_SHORT).show();
                HttpUtil httpUtil = new HttpUtil();
                HttpCallbackListener listener = new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        /*Looper curLooper = Looper.myLooper();
                        Looper mainLooper = Looper.getMainLooper();
                        String msg ;
                        MyHandler mHandler =new MyHandler(mainLooper);
                        msg = response;
                        mHandler.removeMessages(0);
                        Message m = mHandler.obtainMessage(1, 1, 1, msg);
                        mHandler.sendMessage(m);*/
                        SuccessActivity.actionStart(LoginActivity.this, response);
                    }

                    @Override
                    public void onError(Exception e) {
                        FailedActivity.actionStart(LoginActivity.this,"failed");

                    }
                };
                httpUtil.sendHttpRequest(hashMap, address, listener);

                break;
            default:
                break;
        }


    }


    private class MyHandler extends Handler

    {

        public MyHandler(Looper looper){

            super(looper);

        }

        @Override

        public void handleMessage(Message msg) {//处理消息

            super.handleMessage(msg);

            //mText.setText("This update by message");


        }

    }



}
