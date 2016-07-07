package com.example.hirokazu.sampledownloadtask.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.hirokazu.sampledownloadtask.Model.SampleParcelableModel;
import com.example.hirokazu.sampledownloadtask.R;


/**
 * Created by Hirokazu on 2016/07/05.
 */
public class ParcerablePutActivity extends BaseActivity implements View.OnClickListener{

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_sample_parcelable_put);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // シリアライズするインスタンスを生成
        SampleParcelableModel data = new SampleParcelableModel();
        data.mSampleString = "abcde";
        data.mSampleInt = 3;
        data.mSampleIntArray = new int[data.mSampleInt];
        data.mSampleIntArray[0] = 123;
        data.mSampleIntArray[1] = 456;
        data.mSampleIntArray[2] = 789;

        // インテント生成
        Intent intent = new Intent(ParcerablePutActivity.this,ParcerableCallActivity.class);
        // データをシリアライズ
        intent.putExtra("data", data);

        // アクティビティ呼び出し
        startActivity(intent);
    }


}
