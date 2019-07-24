package com.founq.sdk.getphoneinfo;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.founq.sdk.getphoneinfo.utils.EquipmentUtil;
import com.founq.sdk.getphoneinfo.utils.InternetUtil;
import com.founq.sdk.getphoneinfo.utils.MacUtil;

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
        Log.i(TAG, "序列号：" + EquipmentUtil.getSerial(this));
        Log.i(TAG, "设备版本类型：" + EquipmentUtil.getType());
        Log.i(TAG, "设备标签：" + EquipmentUtil.getTags());

        Log.i(TAG, "设备标识：" + EquipmentUtil.getFingerprint());
        Log.i(TAG, "设备主机地址：" + EquipmentUtil.getHost());
        Log.i(TAG, "设备用户名：" + EquipmentUtil.getUser());
        Log.i(TAG, "当前时间：" + EquipmentUtil.getTime());

        Log.i(TAG, "INCREMENTAL（源码控制版本号）：" + EquipmentUtil.getIncremental());
        Log.i(TAG, "SDK版本号：" + EquipmentUtil.getSDK());
        Log.i(TAG, "CODENAME(设备当前的系统开发代号)：" + EquipmentUtil.getCodeName());
        Log.i(TAG, "BASE_OS（目前的开发代号）：" + EquipmentUtil.getBaseOS() + "(23以上版本)");


        Log.i(TAG, "imei：" + EquipmentUtil.getIMEI(this) + "(需要权限READ_PHONE_STATE)");
        Log.i(TAG, "ipv4地址：" + EquipmentUtil.getIPAddress(this) + "(需要权限ACCESS_NETWORK_STATE,  ACCESS_WIFI_STATE, 23及以下还需要INTERNET权限)");
        Log.i(TAG, "mac地址：" + MacUtil.getMac(this) + "(需要权限INTERNET,  ACCESS_WIFI_STATE)");

        Log.i(TAG, "屏幕宽度:" + EquipmentUtil.getWidth(this));
        Log.i(TAG, "屏幕高度:" + EquipmentUtil.getHeight(this));
        Log.i(TAG, "屏幕密度:" + EquipmentUtil.getDensity(this));
        Log.i(TAG, "获取CPU型号:" + EquipmentUtil.getCpuInfo()[0] + ", " + EquipmentUtil.getCpuInfo()[1]);
        Log.i(TAG, "获取运行内存:" + EquipmentUtil.getRAM(this));
        Log.i(TAG, "获取存储内存:" + EquipmentUtil.getROM(this));

        Log.i(TAG, "网络状态:" + InternetUtil.getNetworkState(this));
        Log.i(TAG, "IMSI和运营商:" + EquipmentUtil.getIMSI(this));
        Log.i(TAG, "运营商:" + EquipmentUtil.getCarrier(this));
        Log.i(TAG, "蓝牙地址:" + EquipmentUtil.getBluetoothMacAddress());
        Log.i(TAG, "wifi信息:" + EquipmentUtil.getWifiName(this));
        Log.i(TAG, "ipv6:" + EquipmentUtil.getIpv6Addr());
        Log.i(TAG, "设备ID:" + EquipmentUtil.getAndroidID(this));

        String message = "系统参数：" + "\n" + "手机厂商：" + EquipmentUtil.getDeviceBrand() + "\n" +
                "手机型号：" + EquipmentUtil.getSystemModel() + "\n" + "手机当前系统语言：" + EquipmentUtil.getSystemLanguage() +
                "\n" + "Android系统版本号：" + EquipmentUtil.getSystemVersion() + "\n" + "手机设备名：" + EquipmentUtil.getSystemDevice() +
                "\n" + "主板名：" + EquipmentUtil.getDeviceBoand() + "\n" + "手机厂商名：" + EquipmentUtil.getDeviceManufacturer() +
                "\n" + "id：" + EquipmentUtil.getID() + "\n" + "版本号：" + EquipmentUtil.getDisplay() + "\n" +
                "产品名称：" + EquipmentUtil.getProduct() + "\n" + "系统程序的版本号：" + EquipmentUtil.getBootloader() + " \n" +
                "硬件名称：" + EquipmentUtil.getHardware() + "\n" + "序列号：" + EquipmentUtil.getSerial(this) + "\n" +
                "设备版本类型：" + EquipmentUtil.getType() + "\n" + "设备标签：" + EquipmentUtil.getTags() + "\n" +
                "设备标识：" + EquipmentUtil.getFingerprint() + "\n" + "设备主机地址：" + EquipmentUtil.getHost() + "\n" +
                "设备用户名：" + EquipmentUtil.getUser() + "\n" + "当前时间：" + EquipmentUtil.getTime() + "\n" +
                "INCREMENTAL（源码控制版本号）：" + EquipmentUtil.getIncremental() + "\n" + "SDK版本号：" + EquipmentUtil.getSDK() + "\n" +
                "CODENAME(设备当前的系统开发代号)：" + EquipmentUtil.getCodeName() + "\n" +
                "BASE_OS（目前的开发代号）：" + EquipmentUtil.getBaseOS() + "(23以上版本)" + "\n" +
                "imei：" + EquipmentUtil.getIMEI(this) + "(需要权限READ_PHONE_STATE)" + "\n" +
                "ipv4地址：" + EquipmentUtil.getIPAddress(this) + "(需要权限ACCESS_NETWORK_STATE,  ACCESS_WIFI_STATE, 23及以下还需要INTERNET权限)" + "\n" +
                "mac地址：" + MacUtil.getMac(this) + "(需要权限INTERNET,  ACCESS_WIFI_STATE)" + "\n" +
                "屏幕宽度:" + EquipmentUtil.getWidth(this) + "\n" +
                "屏幕高度:" + EquipmentUtil.getHeight(this) + "\n" +
                "屏幕密度:" + EquipmentUtil.getDensity(this) + "\n" +
                "获取CPU型号:" + EquipmentUtil.getCpuInfo()[0] + ", " + EquipmentUtil.getCpuInfo()[1] + "\n" +
                "获取运行内存:" + EquipmentUtil.getRAM(this) + "\n" +
                "获取存储内存:" + EquipmentUtil.getROM(this) + "\n" +
                "网络状态:" + InternetUtil.getNetworkState(this) + "\n" +
                "IMSI和运营商:" + EquipmentUtil.getIMSI(this) + "\n" +
                "运营商:" + EquipmentUtil.getCarrier(this) + "\n" +
                "蓝牙地址:" + EquipmentUtil.getBluetoothMacAddress() + "\n" +
                "wifi信息:" + EquipmentUtil.getWifiName(this) + "\n" +
                "ipv6:" + EquipmentUtil.getIpv6Addr() + "\n" +
                "设备ID:" + EquipmentUtil.getAndroidID(this) + "\n";

        mTextView.setText(message);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Label", message);
        clipboardManager.setPrimaryClip(clipData);
    }
}
