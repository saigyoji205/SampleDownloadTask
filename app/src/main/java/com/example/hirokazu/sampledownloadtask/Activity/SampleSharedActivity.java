package com.example.hirokazu.sampledownloadtask.Activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hirokazu.sampledownloadtask.R;

/**
 * Created by Hirokazu on 2016/06/29.
 */
public class SampleSharedActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEditText = null;
    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_sample_shared);
        Button saveButton = (Button)findViewById(R.id.SaveButton);
        Button loadButton = (Button)findViewById(R.id.LoadButton);
        mEditText = (EditText) findViewById(R.id.EditText01);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getSharedPreferences("preferenceSample",MODE_PRIVATE);
        switch (v.getId()){
            case R.id.SaveButton:
//                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("SaveString", mEditText.getText().toString());
                editor.commit();
                break;
            case R.id.LoadButton:
//                SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
                mEditText.setText(preferences.getString("SaveString", null), TextView.BufferType.NORMAL);
                break;
        }
    }
}
