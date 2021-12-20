package com.example.shcheprov_homeworks

import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.OnBackStackChangedListener

interface ColorFragmentInterface {
    fun setRootOnClickListener(
        root: View,
        parentFragmentManager: FragmentManager,
        backStackName: String,
        fragmentClass: Class<out Fragment>
    ) {
        root.setOnClickListener {
            parentFragmentManager.beginTransaction().add(
                R.id.fragmentContainerView, fragmentClass,
                bundleOf()
            ).setReorderingAllowed(true)
                .addToBackStack(backStackName).commit()
        }
    }

    fun initCounter(
        counterTextView: TextView,
        parentFragmentManager: FragmentManager,
        backStackChangedListener: OnBackStackChangedListener
    ) {
        counterTextView.text = parentFragmentManager.backStackEntryCount.toString()
        parentFragmentManager.addOnBackStackChangedListener(backStackChangedListener)
    }

    fun removeCounterListener(
        parentFragmentManager: FragmentManager,
        backStackChangedListener: OnBackStackChangedListener
    ) {
        parentFragmentManager.removeOnBackStackChangedListener(backStackChangedListener)
    }
}