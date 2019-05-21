package com.zy.android_serialization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.TextView;

import com.zy.android_serialization.activity.OtherActivity;
import com.zy.android_serialization.serializable.PBook;
import com.zy.android_serialization.serializable.SBook;
import com.zy.android_serialization.viewinjection.ViewField;
import com.zy.android_serialization.viewinjection.ViewMethod;
import com.zy.android_serialization.viewinjection.ViewUtils;

/**
 * Android 序列化研究
 */

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @ViewField(R.id.activity_main_title)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.register(this);
        initData();
        Looper.getMainLooper().setMessageLogging(new Printer() {
            private static final String START = ">>>>> Dispatching";
            private static final String END = "<<<<< Finished";

            @Override
            public void println(String x) {
                if(x.startsWith(START)){

                }else if (x.startsWith(END)){

                }
                Log.d(TAG, "" + x);
            }
        });
    }

    private void initData() {
//        Intent intent = new Intent(this, OtherActivity.class);
//        intent.putExtra("SBook", new SBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
//        intent.putExtra("PBook", new PBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
    }


    @ViewMethod(R.id.activity_main_parcelable)
    public void testParcelable(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("SBook", new SBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
        intent.putExtra("PBook", new PBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
        startActivity(intent);
    }


    @ViewMethod(R.id.activity_main_serializable)
    public void testSerializable(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("SBook", new SBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
        intent.putExtra("PBook", new PBook("钢铁是怎样炼成的", "How the Steel Was Tempered", 1001));
        startActivity(intent);
    }
}
