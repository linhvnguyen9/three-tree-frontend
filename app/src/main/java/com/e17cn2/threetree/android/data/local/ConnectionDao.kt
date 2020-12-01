package com.e17cn2.threetree.android.data.local

import android.content.Context
import android.net.wifi.WifiManager
import androidx.core.content.getSystemService
import java.net.InetAddress

class ConnectionDao() {
    fun getClientIpAddress() : String {
//        return context.getSystemService<WifiManager>().let {
//            when {
//                it == null -> "No wifi available"
//                !it.isWifiEnabled -> "Wifi is disabled"
//                it.connectionInfo == null -> "Wifi not connected"
//                else -> {
//                    val ip = it.connectionInfo.ipAddress
//                    val i = InetAddress.getByName(java.lang.String.valueOf(ip))
//                    val ipString: String = i.hostAddress
//                    ipString
//                }
//            }
//        }
        return ""
    }
}