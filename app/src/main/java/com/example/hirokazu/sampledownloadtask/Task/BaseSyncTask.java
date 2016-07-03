package com.example.hirokazu.sampledownloadtask.Task;

import android.os.AsyncTask;

/**
 * Created by Hirokazu on 2016/06/29.
 */
public class BaseSyncTask<Params,Progress,Result> extends AsyncTask {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Params doInBackground(Object[] params) {
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
