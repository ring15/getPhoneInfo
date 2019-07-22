package com.founq.sdk.getphoneinfo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView2);
        requestPermission();
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0x01);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                init();
                break;
        }
    }

    private void init() {
        String TAG = "系统参数：";
        Log.i(TAG, "手机厂商：" + EquipmentUtil.getDeviceBrand());
        Log.i(TAG, "手机型号：" + EquipmentUtil.getSystemModel());
        Log.i(TAG, "手机当前系统语言：" + EquipmentUtil.getSystemLanguage());
        Log.i(TAG, "Android系统版本号：" + EquipmentUtil.getSystemVersion());

        Log.i(TAG, "手机设备名：" + EquipmentUtil.getSystemDevice());
        Log.i(TAG, "主板名：" + EquipmentUtil.getDeviceBoand());
        Log.i(TAG, "手机厂商名：" + EquipmentUtil.getDeviceManufacturer());

        Log.i(TAG, "id：" + EquipmentUtil.getID());
        Log.i(TAG, "版本号：" + EquipmentUtil.getDisplay());
        Log.i(TAG, "产品名称：" + EquipmentUtil.getProduct());
        Log.i(TAG, "系统程序的版本号：" + EquipmentUtil.getBootloader());

        Log.i(TAG, "硬件名称：" + EquipmentUtil.getHardware());
        Log.i(TAG, "序列号：" + EquipmentUtil.getSerial());
        Log.i(TAG, "设备版本类型：" + EquipmentUtil.getType());
        Log.i(TAG, "设备标签：" + EquipmentUtil.getTags());

        Log.i(TAG, "设备标识：" + EquipmentUtil.getFingerprint());
        Log.i(TAG, "HOST：" + EquipmentUtil.getHost());
        Log.i(TAG, "USER：" + EquipmentUtil.getUser());
        Log.i(TAG, "TIME：" + EquipmentUtil.getTime());

        Log.i(TAG, "INCREMENTAL：" + EquipmentUtil.getIncremental());
        Log.i(TAG, "SDK_INT：" + EquipmentUtil.getSDK());
        Log.i(TAG, "CODENAME：" + EquipmentUtil.getCodeName());
        Log.i(TAG, "base_os：" + EquipmentUtil.getBaseOS() + "(23以上版本)");


        Log.i(TAG, "imei：" + EquipmentUtil.getIMEI(this) + "(需要权限READ_PHONE_STATE)");
        Log.i(TAG, "ip地址：" + EquipmentUtil.getIPAddress(this) + "(需要权限ACCESS_NETWORK_STATE,  ACCESS_WIFI_STATE, 23及以下还需要INTERNET权限)");
        Log.i(TAG, "mac地址：" + MacUtil.getMac(this) + "(需要权限INTERNET,  ACCESS_WIFI_STATE)");

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        float density = outMetrics.density;
        Log.i(TAG, "屏幕宽度:" + width);
        Log.i(TAG, "屏幕高度:" + height);
        Log.i(TAG, "屏幕密度:" + density);
        Log.i(TAG, "获取CPU型号:" + EquipmentUtil.getCpuInfo()[0] + ", " + EquipmentUtil.getCpuInfo()[1]);

        String message = "系统参数：" + "\n" + "手机厂商：" + EquipmentUtil.getDeviceBrand() + "\n" +
                "手机型号：" + EquipmentUtil.getSystemModel() + "\n" + "手机当前系统语言：" + EquipmentUtil.getSystemLanguage() +
                "\n" + "Android系统版本号：" + EquipmentUtil.getSystemVersion() + "\n" + "手机设备名：" + EquipmentUtil.getSystemDevice() +
                "\n" + "主板名：" + EquipmentUtil.getDeviceBoand() + "\n" + "手机厂商名：" + EquipmentUtil.getDeviceManufacturer() +
                "\n" + "id：" + EquipmentUtil.getID() + "\n" + "版本号：" + EquipmentUtil.getDisplay() + "\n" +
                "产品名称：" + EquipmentUtil.getProduct() + "\n" + "系统程序的版本号：" + EquipmentUtil.getBootloader() + " \n" +
                "硬件名称：" + EquipmentUtil.getHardware() + "\n" + "序列号：" + EquipmentUtil.getSerial() + "\n" +
                "设备版本类型：" + EquipmentUtil.getType() + "\n" + "设备标签：" + EquipmentUtil.getTags() + "\n" +
                "设备标识：" + EquipmentUtil.getFingerprint() + "\n" + "HOST：" + EquipmentUtil.getHost() + "\n" +
                "USER：" + EquipmentUtil.getUser() + "\n" + "TIME：" + EquipmentUtil.getTime() + "\n" +
                "INCREMENTAL：" + EquipmentUtil.getIncremental() + "\n" + "SDK_INT：" + EquipmentUtil.getSDK() + "\n" +
                "CODENAME：" + EquipmentUtil.getCodeName() + "\n" + "base_os：" + EquipmentUtil.getBaseOS() + "(23以上版本)" + "\n" +
                "imei：" + EquipmentUtil.getIMEI(this) + "(需要权限READ_PHONE_STATE)" + "\n" +
                "ip地址：" + EquipmentUtil.getIPAddress(this) + "(需要权限ACCESS_NETWORK_STATE,  ACCESS_WIFI_STATE, 23及以下还需要INTERNET权限)" + "\n" +
                "mac地址：" + MacUtil.getMac(this) + "(需要权限INTERNET,  ACCESS_WIFI_STATE)" + "\n" +
                "屏幕宽度:" + width + "\n" + "屏幕高度:" + height + "\n" + "屏幕密度:" + density + "\n" +
                "获取CPU型号:" + EquipmentUtil.getCpuInfo()[0] + ", " + EquipmentUtil.getCpuInfo()[1] + "\n";

        mTextView.setText(message);
    }
}
