package com.founq.sdk.getphoneinfo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Created by ring on 2019/7/22.
 */
public class EquipmentUtil {


    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机设备名
     *
     * @return 手机设备名
     */
    public static String getSystemDevice() {
        return Build.DEVICE;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机主板名
     *
     * @return 主板名
     */
    public static String getDeviceBoand() {
        return Build.BOARD;
    }


    /**
     * 获取手机厂商名（硬件制造商）
     *
     * @return 手机厂商名
     */
    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取id
     *
     * @return id
     */
    public static String getID() {
        return Build.ID;
    }

    /**
     * 获取手机版本号
     *
     * @return 版本号
     */
    public static String getDisplay() {
        return Build.DISPLAY;
    }

    /**
     * 获取手机产品名称
     *
     * @return 产品名称
     */
    public static String getProduct() {
        return Build.PRODUCT;
    }

    /**
     * 获取手机系统程序的版本号
     *
     * @return 系统程序的版本号
     */
    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    /**
     * 获取手机硬件名称
     *
     * @return 硬件名称
     */
    public static String getHardware() {
        return Build.HARDWARE;
    }

    /**
     * 获取手机序列号
     *
     * @return 序列号
     */
    public static String getSerial() {
        return Build.SERIAL;
    }

    /**
     * 获取手机设备版本类型
     *
     * @return 设备版本类型
     */
    public static String getType() {
        return Build.TYPE;
    }

    /**
     * 获取手机设备标签
     *
     * @return 设备标签
     */
    public static String getTags() {
        return Build.TAGS;
    }

    /**
     * 获取手机设备标识
     *
     * @return 设备标识
     */
    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    /**
     * 获取手机HOST
     *
     * @return HOST
     */
    public static String getHost() {
        return Build.HOST;
    }

    /**
     * 获取手机USER
     *
     * @return USER
     */
    public static String getUser() {
        return Build.USER;
    }

    /**
     * 获取手机TIME
     *
     * @return TIME
     */
    public static long getTime() {
        return Build.TIME;
    }

    /**
     * 获取手机INCREMENTAL（小米上返回MIUI版本）（源码控制版本号）
     *
     * @return INCREMENTAL
     */
    public static String getIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    /**
     * 获取手机SDK_INT（SDK版本号）
     *
     * @return SDK_INT
     */
    public static int getSDK() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机CODENAME(设备当前的系统开发代号)
     *
     * @return CODENAME
     */
    public static String getCodeName() {
        return Build.VERSION.CODENAME;
    }

    /**
     * 获取手机BASE_OS（目前的开发代号）
     *
     * @return BASE_OS
     */
    public static String getBaseOS() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Build.VERSION.BASE_OS;
        } else {
            return null;
        }
    }


    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 手机IMEI
     */
    public static String getIMEI(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return null;
            }
            return tm.getDeviceId();
        }
        return null;
    }

    /**
     * 获取IP地址，需要权限ACCESS_NETWORK_STATE和ACCESS_WIFI_STATE
     *
     * @param context
     * @return
     */
    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }
//
//    /**
//     * 获取蓝牙地址
//     */
//    public static String getBluetoothMacAddress() {
//        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        String bluetoothMacAddress = "";
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            try {
//                Field mServiceField = bluetoothAdapter.getClass().getDeclaredField("mService");
//                mServiceField.setAccessible(true);
//
//                Object btManagerService = mServiceField.get(bluetoothAdapter);
//
//                if (btManagerService != null) {
//                    bluetoothMacAddress = (String) btManagerService.getClass().getMethod("getAddress").invoke(btManagerService);
//                }
//            } catch (NoSuchFieldException e) {
//
//            } catch (NoSuchMethodException e) {
//
//            } catch (IllegalAccessException e) {
//
//            } catch (InvocationTargetException e) {
//
//            }
//        } else {
//            bluetoothMacAddress = bluetoothAdapter.getAddress();
//        }
//        return bluetoothMacAddress;
//    }

    /**
     * 获取CPU型号
     *
     * @return
     */
    public static String[] getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
        String[] cpuInfo = {"", ""};// 0-cpu型号 //1-cpu频率
        String[] arrayOfString;
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            for (int i = 2; i < arrayOfString.length; i++) {
                cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
            }
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            cpuInfo[1] += arrayOfString[2];
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return cpuInfo;
    }
}
