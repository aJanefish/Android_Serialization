package com.zy.android_serialization.presenter;

import android.content.Intent;

import com.zy.android_serialization.model.OtherModel;
import com.zy.android_serialization.view.IOtherView;

import java.lang.ref.WeakReference;

public class OtherPresenter {

    private WeakReference<IOtherView> weakReference;

    public OtherPresenter(IOtherView iOtherView) {
        this.weakReference = new WeakReference<>(iOtherView);
    }


    /**
     * 测试序列化
     * */
    public void test(Intent intent){
        OtherModel.test(intent);
    }
}
