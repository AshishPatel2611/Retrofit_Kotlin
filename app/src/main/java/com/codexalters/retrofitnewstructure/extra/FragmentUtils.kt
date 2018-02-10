package com.codexalters.retrofitnewstructure.extra

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by codexalters on 4/12/17.
 */
object FragmentUtils {

    fun addFragment(activity: AppCompatActivity, fragment: Fragment, container: Int) {

        Log.i("FragmentUtils", "addFragment BackStackEntryCount :" + activity.supportFragmentManager.backStackEntryCount)
        val currentFragment = activity.supportFragmentManager.findFragmentById(container)
        Log.d("Companion", "addFragment : $currentFragment ")
        if (currentFragment != null && fragment.javaClass.simpleName == currentFragment.javaClass.simpleName)
            return
        val fragmentPopped = activity.supportFragmentManager
                .popBackStackImmediate(fragment.javaClass.simpleName, 0)
        if (!fragmentPopped && activity.supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction.add(container, fragment, fragment.javaClass.simpleName)
            transaction.addToBackStack(fragment.javaClass.simpleName)
            transaction.commit()
//                activity.findViewById<TextView>(R.id.main_toolbar_title).setText(title)
        }
    }

    fun replaceFragment(activity: AppCompatActivity, fragment: Fragment, container: Int) {

        Log.i("FragmentUtils", "addFragment BackStackEntryCount :" + activity.supportFragmentManager.backStackEntryCount)
        val currentFragment = activity.supportFragmentManager.findFragmentById(container)
        Log.d("Companion", "addFragment : $currentFragment ")
        if (currentFragment != null && fragment.javaClass.simpleName == currentFragment.javaClass.simpleName)
            return
        val fragmentPopped = activity.supportFragmentManager.popBackStackImmediate(fragment.javaClass.simpleName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        if (activity.supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction.replace(container, fragment, fragment.javaClass.simpleName)
            transaction.addToBackStack(fragment.javaClass.simpleName)
            transaction.commit()
//                activity.findViewById<TextView>(R.id.main_toolbar_title).setText(title)
        }
    }

// if animation required 

/* transaction.setCustomAnimations(R.animator.fragment_slide_left_enter,
                    R.animator.fragment_slide_left_exit,
                    R.animator.fragment_slide_right_enter,
                    R.animator.fragment_slide_right_exit)
 */


}