package com.example.hirokazu.sampledownloadtask.Activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Hirokazu on 2016/06/29.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView() {
    }


}
