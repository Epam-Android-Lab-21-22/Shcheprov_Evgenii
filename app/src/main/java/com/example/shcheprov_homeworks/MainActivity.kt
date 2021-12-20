package com.example.shcheprov_homeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val redFragment = Red()
    private val greenFragment = Green()
    private val blueFragment = Blue()
    private var currentFragmentState = TAGS.RED_FRAGMENT_TAG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainerView, redFragment)
                setReorderingAllowed(true)
                commit()
                setToolbarText(TAGS.RED_FRAGMENT_TAG)//СОХРАНЕНИЕ
            }
        }
        setListeners()
    }

    private fun replaceFragment(fragment: Fragment, currentKey: String, prevKey: String) {
        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(R.id.fragmentContainerView, fragment)
                setReorderingAllowed(true)
                commit()
            }
            saveBackStack(prevKey)
            restoreBackStack(currentKey)

        }
        currentFragmentState = currentKey
        setToolbarText(currentFragmentState)
    }

    private fun setToolbarText(status: String) {
        binding.toolBar.title =
            when (status) {
                TAGS.RED_FRAGMENT_TAG -> getString(R.string.red)
                TAGS.GREEN_FRAGMENT_TAG -> getString(R.string.green)
                else -> getString(R.string.blue)
            }
    }

    private fun setListeners() {
        supportFragmentManager.addOnBackStackChangedListener {
            binding.bottomNavigationView.getOrCreateBadge(
                when (currentFragmentState) {
                    TAGS.RED_FRAGMENT_TAG -> R.id.fragment_red
                    TAGS.GREEN_FRAGMENT_TAG -> R.id.fragment_green
                    else -> R.id.fragment_blue
                }
            ).apply {
                number = supportFragmentManager.backStackEntryCount
                isVisible = number != 0
            }

        }
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_red -> replaceFragment(
                    redFragment,
                    TAGS.RED_FRAGMENT_TAG,
                    currentFragmentState
                )
                R.id.fragment_green -> replaceFragment(
                    greenFragment,
                    TAGS.GREEN_FRAGMENT_TAG,
                    currentFragmentState
                )
                R.id.fragment_blue -> replaceFragment(
                    blueFragment,
                    TAGS.BLUE_FRAGMENT_TAG,
                    currentFragmentState
                )
            }
            true
        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentFragmentState =
            savedInstanceState.getString(TAGS.CURRENT_FRAGMENT_SAVING_KEY, TAGS.RED_FRAGMENT_TAG)
        setToolbarText(currentFragmentState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TAGS.CURRENT_FRAGMENT_SAVING_KEY, currentFragmentState)
    }


}
