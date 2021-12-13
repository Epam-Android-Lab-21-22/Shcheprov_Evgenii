package com.example.shcheprov_homeworks

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val externalNetworkStatusReceiver = NetworkStatusReceiver()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setConnectionListeners()
        binding.switchToFeatureActivityButton.setOnClickListener {
            startActivity(Intent(this, FeatureActivity::class.java))
        }
    }

    private fun setConnectionListeners() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //callback is not called if there is no internet during launch
            binding.switchToFeatureActivityButton.isEnabled = false//enabled = false in xml looks bad on api < 24
            subscribeNetworkStatusApiN(context = applicationContext)
        } else {
            registerReceiver(externalNetworkStatusReceiver, IntentFilter(CONNECTIVITY_ACTION))
        }
        registerReceiver(
            mainActivityNetworkStatusReceiver,
            IntentFilter(TAGS.INTENT_FILTER_ACTION)
        )
    }
    fun setClickableToButton(status: Boolean) {
        runOnUiThread {
            if (status) {
                binding.switchToFeatureActivityButton.apply {
                    isEnabled=true
                    text=getString(R.string.let_s_take_pictures)
                }


            } else {
                binding.switchToFeatureActivityButton.apply {
                    isEnabled=false
                    text=getString(R.string.no_internet_connection)
                }
                Snackbar.make(binding.root, getString(R.string.no_internet_connection), LENGTH_LONG).show()
            }
        }
    }

    private val mainActivityNetworkStatusReceiver: BroadcastReceiver =
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                setClickableToButton(
                    intent?.getBooleanExtra(TAGS.BUNDLE_EXTRAS_TAG, false) ?: false
                )
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            unregisterReceiver(externalNetworkStatusReceiver)
        }
        unregisterReceiver(mainActivityNetworkStatusReceiver)
    }
}