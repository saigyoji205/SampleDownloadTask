package com.example.hirokazu.sampledownloadtask.Activity;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hirokazu.sampledownloadtask.Adapter.TopListAdapter;
import com.example.hirokazu.sampledownloadtask.Model.Model;
import com.example.hirokazu.sampledownloadtask.R;

import java.util.ArrayList;

public class TopListActivity extends Activity {

//    private static final Constant[] items = {"1つ目","2つ目","3つ目"};
    private ArrayList mList = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView splashImageView = (ImageView) findViewById(R.id.splash_image);
        final Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fadein);

        splashImageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashImageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        createDummyData();
        TopListAdapter topListAdapter = new TopListAdapter(this,R.layout.list_item,mList);
        ListView listView = (ListView) findViewById(R.id.show_list);
        listView.setAdapter(topListAdapter);
    }

    private void createDummyData() {
        mList = new ArrayList();
        final Model item1 = new Model();
        item1.setScreenName("techfirmlab");
        item1.setText("おわったー");
        mList.add(item1);

        mList = new ArrayList();
        final Model item2 = new Model();
        item2.setScreenName("techfirmlab");
        item2.setText("背景の変更に小ハマリなう");
        mList.add(item2);



        final Model item3 = new Model();
        item3.setScreenName("techfirmlab");
        item3.setText("ListAdapter継承なう");
        mList.add(item3);

        final Model item4 = new Model();
        item4.setScreenName("techfirmlab");
        item4.setText("Twitterデータ格納用クラス作成なう");
        mList.add(item4);

        final Model item5 = new Model();
        item5.setScreenName("techfirmlab");
        item5.setText("ListViewのカスタマイズなう");
        mList.add(item5);

        final Model item6 = new Model();
        item6.setScreenName("techfirmlab");
        item6.setText("はじめるか");
        mList.add(item6);

    }
}
