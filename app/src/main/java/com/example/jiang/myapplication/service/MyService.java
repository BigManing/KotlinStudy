package com.example.jiang.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.yhao.firstkotlin.IMyAidlInterface;
import com.yhao.firstkotlin.Student;

/**
 * Created by BigManing on 17-12-6.
 * 邮箱：lingshui2008@qq.com
 * 在服务端配置
 * 这里返回自己定义的ibinder
 */

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  new IMyAidlInterface.Stub() {
            private Student student;

            @Override
            public Student getStudent() throws RemoteException {
                return student;
            }

            @Override
            public void setStudent(Student student) throws RemoteException {

                this.student = student;
            }

            @Override
            public String getValue() throws RemoteException {
                return "get value : " + Thread.currentThread().getName() + Thread.currentThread().getId();
            }
        };
    }
}
