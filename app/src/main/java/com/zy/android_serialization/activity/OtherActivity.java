package com.zy.android_serialization.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zy.android_serialization.R;
import com.zy.android_serialization.presenter.OtherPresenter;
import com.zy.android_serialization.view.IOtherView;
import com.zy.android_serialization.viewinjection.ViewMethod;
import com.zy.android_serialization.viewinjection.ViewUtils;

public class OtherActivity extends AppCompatActivity implements IOtherView {

    private OtherPresenter otherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ViewUtils.register(this);
        otherPresenter = new OtherPresenter(this);
    }


    @ViewMethod(R.id.activity_other_test_Parcelable)
    public void testParcelable(View view) {
        otherPresenter.test(getIntent());
    }


    @ViewMethod(R.id.activity_other_test_Serializable)
    public void testSerializable(View view) {
        otherPresenter.test(getIntent());
    }



}
