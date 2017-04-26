package com.ccl.mydemo.util.httpUtil;

/**
 * Created by CCL on 2016/12/2.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
