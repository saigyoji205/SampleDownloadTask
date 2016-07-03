package com.example.hirokazu.sampledownloadtask.Activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hirokazu.sampledownloadtask.R;
import com.example.hirokazu.sampledownloadtask.strings.Constant;

/**
 * Created by Hirokazu on 2016/07/03.
 */
public class IntentSampleActivity extends BaseActivity implements View.OnClickListener {
    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    public void initView() {
        super.initView();
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウト生成
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        //ボタンの生成
        linearLayout.addView(makeButton(getString(R.string.sample_url_title), Constant.IntentTag.TAG_WEB));
        linearLayout.addView(makeButton(getString(R.string.sample_map_title), Constant.IntentTag.TAG_MAP));
        linearLayout.addView(makeButton(getString(R.string.sample_call_title), Constant.IntentTag.TAG_CALL));
        linearLayout.addView(makeButton(getString(R.string.sample_dial_title), Constant.IntentTag.TAG_DIAL));
        linearLayout.addView(makeButton(getString(R.string.sample_setup_title), Constant.IntentTag.TAG_SETUP));
//        linearLayout.addView(makeButton(getString(R.string.sample_active_helloworld), Constant.IntentTag.TAG_HELLO));
    }

    //Buttonインスタンス生成
    private Button makeButton(String text, String tag) {
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        return button;
    }


    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();

        if (tag != null) {

            /**
             * 暗黙的Intentによる処理委譲(委譲できるアプリが存在しないと、ActivityNotFoundException
             */
            if (Constant.IntentTag.TAG_WEB.equals(tag)) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.sample_url)));
                startActivity(intent);
            } else if (Constant.IntentTag.TAG_MAP.equals(tag)) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.sample_geo)));
                startActivity(intent);
            } else if (Constant.IntentTag.TAG_CALL.equals(tag)) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(getString(R.string.sample_tel_number)));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else if (Constant.IntentTag.TAG_DIAL.equals(tag)) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.sample_tel_number)));
                startActivity(intent);
            } else if (Constant.IntentTag.TAG_SETUP.equals(tag)) {
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
            }


//            } else if (Constant.IntentTag.TAG_WEB.equals(tag)) {
//                Intent intent = new Intent("android.intent.action.View", Uri.parse(getString(R.string.sample_url)));
//                startActivity(intent);
//            }
        }
    }
}
