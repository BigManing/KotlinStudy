package com.example.jiang.myapplication.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.example.jiang.myapplication.R;
import com.yhao.firstkotlin.IMyAidlInterface;

/**
 * Created by BigManing on 17-12-6.
 * 邮箱：lingshui2008@qq.com
 * aidl  客户端的调用
 */

public class AIDLClient extends AppCompatActivity {

    private IMyAidlInterface iMyAidlInterface;
    private ServiceConnection serverConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            把ibinder 转化过
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                // 获得 调用另外的app进程  来获取对象
                System.out.println(iMyAidlInterface.getStudent().toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidlclient);
        Intent intent=new Intent("com.example.tee.testapplication.aidl.IMyAidlInterface");
// 绑定
        bindService(intent, serverConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//         解绑
        if (serverConnection!=null) {
            unbindService(serverConnection);
        }
    }
}
