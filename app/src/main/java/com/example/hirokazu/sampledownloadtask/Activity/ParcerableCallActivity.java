package com.example.hirokazu.sampledownloadtask.Activity;

import android.content.Intent;
import android.widget.TextView;

import com.example.hirokazu.sampledownloadtask.Model.SampleParcelableModel;
import com.example.hirokazu.sampledownloadtask.R;

/**
 * Created by Hirokazu on 2016/07/05.
 */
public class ParcerableCallActivity extends BaseActivity {
    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_sample_parcelable_call);
        // インテント取得
        Intent intent = getIntent();

        //データをデシリアライズして受け取る
        SampleParcelableModel model = intent.getParcelableExtra("data");

        // 表示
        TextView textView1,textView2,textView3;
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView1.setText(model.mSampleString);
        textView2.setText(Integer.toString(model.mSampleInt));
        textView3.setText(Integer.toString(model.mSampleIntArray[0]));
    }
}
