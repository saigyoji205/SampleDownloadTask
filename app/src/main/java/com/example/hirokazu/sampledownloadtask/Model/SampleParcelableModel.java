package com.example.hirokazu.sampledownloadtask.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hirokazu on 2016/07/05.
 */
public class SampleParcelableModel implements Parcelable {
    //Intentで受け渡しするデータクラス
    public String mSampleString;
    public int mSampleInt;
    public  int[] mSampleIntArray;



    public static final Creator<SampleParcelableModel> CREATOR = new Creator<SampleParcelableModel>() {
        @Override
        public SampleParcelableModel createFromParcel(Parcel in) {
            //デシリアライズ処理(バイト配列からのデータ化(読み込み処理))
            //writeToParcelメソッドでシリアライズした順番と同じ順番でメンバ変数をデシリアライズすること

            //インスタンス生成
            SampleParcelableModel model = new SampleParcelableModel();

            //インスタンスに受け取るデータを格納する
            model.mSampleString = in.readString();
            model.mSampleInt = in.readInt();

            //配列の場合は、引数に格納先を指定する
            model.mSampleIntArray = new int[model.mSampleInt];
            in.readIntArray(model.mSampleIntArray);

            return model;
        }

        @Override
        public SampleParcelableModel[] newArray(int size) {
            return new SampleParcelableModel[size];
        }
    };

    @Override
    public int describeContents() {
        // ファイルディスクリプタを返す(Parcelableインタフェースの実装メソッド)
        // ファイルディスクリプタを持たない場合は0を返す
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // シリアライズ処理->直列化処理(Parcelableインターフェースの実装メソッド)
        dest.writeString(mSampleString);
        dest.writeInt(mSampleInt);
        dest.writeIntArray(mSampleIntArray);
    }
}
