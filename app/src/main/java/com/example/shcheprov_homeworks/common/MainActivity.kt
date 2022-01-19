package com.example.shcheprov_homeworks.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding
import com.example.shcheprov_homeworks.sightsScreen.view.SightsFragment
import com.example.shcheprov_homeworks.districtScreen.view.DistrictFragment

class MainActivity : FragmentActivity() {
    private var leftFragment = SightsFragment()
    private val rightFragment = DistrictFragment()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container, leftFragment)
                setReorderingAllowed(true)
            }
        }
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_left -> setFragment(leftFragment)
                R.id.fragment_right -> setFragment(rightFragment)
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, fragment)
        }
    }

}