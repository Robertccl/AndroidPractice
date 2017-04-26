package com.ccl.mydemo.util.httpUtil;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by CCL on 2016/12/2.
 */

public class HttpUtil {

    public static void sendHttpRequest(final HashMap<String, String> hashMap, final String address, final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try{
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    /* optional request header */
                    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        /* optional request header */
                    connection.setRequestProperty("Accept", "application/json");

                    connection.connect();
                    JSONObject json = new JSONObject();//创建json对象
                    for(String key : hashMap.keySet()) {
                        json.put(key, URLEncoder.encode(hashMap.get(key), "UTF-8"));//使用URLEncoder.encode对特殊和不可见字符进行编码
                        //json.put("passWord", URLEncoder.encode("1", "UTF-8"));//把数据put进json对象中

                    }

                    String jsonstr = json.toString();//把JSON对象按JSON的编码格式转换为字符串

                    OutputStream out = connection.getOutputStream();
                    //输出流，用来发送请求，http请求实际上直到这个函数里面才正式发送出去

                    BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(out));//创建字符流对象并用高效缓冲流包装它，便获得最高的效率,发送的是字符串推荐用字符流，其它数据就用字节流
                    bw.write(jsonstr);//把json字符串写入缓冲区中
                    bw.flush();//刷新缓冲区，把数据发送出去，这步很重要
                    out.close();
                    bw.close();//使用完关闭
                    Log.i("cc","responseCode:"+connection.getResponseCode());

                    InputStream inputResponse = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputResponse));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine() )!= null){
                        response.append(line);
                    }
                    inputResponse.close();
                    if(connection.getResponseCode()==200) {

                        if (listener != null) {
                            listener.onFinish(response.toString());
                        }
                    }

                }catch(Exception e){
                    if(listener != null){
                        listener.onError(e);
                    }
                }finally {
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

}
