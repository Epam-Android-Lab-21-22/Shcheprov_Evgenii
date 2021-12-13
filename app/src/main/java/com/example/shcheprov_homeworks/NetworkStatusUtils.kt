package com.example.shcheprov_homeworks

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi


class NetworkStatusReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val manager: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager
        val networkInfo = manager.activeNetworkInfo
        context.sendBroadcast(
            Intent(TAGS.INTENT_FILTER_ACTION).putExtra(
                TAGS.BUNDLE_EXTRAS_TAG,
                networkInfo?.isConnected ?: false
            )
        )
    }

}

@RequiresApi(Build.VERSION_CODES.M)
fun subscribeNetworkStatusApiN(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        context.getSystemService(ConnectivityManager::class.java)
            .registerDefaultNetworkCallback(object :
                ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    context.sendBroadcast(
                        Intent(TAGS.INTENT_FILTER_ACTION).putExtra(
                            TAGS.BUNDLE_EXTRAS_TAG,
                            true
                        )

                    )
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    context.sendBroadcast(
                        Intent(TAGS.INTENT_FILTER_ACTION).putExtra(
                            TAGS.BUNDLE_EXTRAS_TAG,
                            false
                        )
                    )
                }
            })
    }

}

object TAGS {
    const val INTENT_FILTER_ACTION = "CONNECTION"
    const val BUNDLE_EXTRAS_TAG = "CONNECTION_STATUS"
}