package com.zy.android_serialization.model;

import android.content.Intent;

import com.zy.android_serialization.serializable.PBook;
import com.zy.android_serialization.serializable.SBook;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OtherModel {

    private static ExecutorService executors = Executors.newCachedThreadPool();


    /**
     * 测试序列化
     */
    public static void test(final Intent intent) {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                long totalP = testParcelable(intent, 10000);
                long totalS = testSerializable(intent, 10000);
                log("性能比:" + ((float) totalS / (float) totalP));
            }
        });
    }

    private static long testParcelable(Intent intent, int times) {
        long start = System.nanoTime();
        PBook pBook = null;
        for (int i = 0; i < times; i++) {
            pBook = intent.getParcelableExtra("PBook");
        }
        log("testParcelable:" + pBook.toString() + " - " + pBook.hashCode());
        long end = System.nanoTime();
        long total = end - start;
        log("testParcelable:" + (end - start));
        return total;
    }


    private static long testSerializable(Intent intent, int times) {
        long start = System.nanoTime();
        SBook sBook = null;
        for (int i = 0; i < times; i++) {
            sBook = (SBook) intent.getSerializableExtra("SBook");
        }
        log("testSerializable:" + sBook.toString() + " - " + sBook.hashCode());
        long end = System.nanoTime();
        long total = end - start;
        log("testSerializable:" + (end - start));
        return total;
    }


    private static void log(String dates) {
        System.out.println("OtherModel:" + dates);
    }

    private static void testIn(){

        //序列化到本地
        //User user=new User(0,"wcl_android@163.com","123456");
//        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("user.obj"));
//        out.writeObject(user);
//        out.close();

    }
}
