package com.example.shcheprov_homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding
import com.example.shcheprov_homeworks.entities.Lists
import com.example.shcheprov_homeworks.fragments.LeftFragment
import com.example.shcheprov_homeworks.fragments.RightFragment

class MainActivity : AppCompatActivity() {
    private val leftFragment = LeftFragment()
    private val rightFragment = RightFragment()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container,leftFragment)
            }
        }
        binding.bottomNavigationView.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.fragment_left->setFragment(leftFragment)
                R.id.fragment_right->setFragment(rightFragment)
            }
            true

        }
        leftFragment.recyclerViewAdapter.updateList(Lists.listLeft)

    }
    private fun setFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container,fragment)
        }
    }
}