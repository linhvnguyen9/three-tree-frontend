package com.e17cn2.threetree.android.data.local

import android.content.Context
import android.net.wifi.WifiManager
import androidx.core.content.getSystemService
import com.orhanobut.hawk.Hawk
import java.lang.IllegalStateException
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

class ConnectionDao() {

    fun getClientIpAddress() : String {
        NetworkInterface.getNetworkInterfaces()?.toList()?.map { networkInterface ->
            networkInterface.inetAddresses?.toList()?.find {
                !it.isLoopbackAddress && it is Inet4Address
            }?.let { return it.hostAddress }
        }
        return ""
    }

    fun getUserId() : String {
        return try {
            Hawk.get<String>("USER_ID")
        } catch (e: IllegalStateException) {
            return "5fcbaee40c6dc359fbbedcba"
        }
    }
}