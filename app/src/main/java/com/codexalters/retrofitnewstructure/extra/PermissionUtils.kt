package com.codexalters.retrofitnewstructure.extra

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import java.util.*

/**
 * Created by codexalters on 8/9/17.
 */

object PermissionUtils {
    private val TAG = "PermissionUtils"

    fun requestPermission(activity: Activity, requestCode: Int, vararg permissions: String): Boolean {

        var granted = true
        val permissionsNeeded = ArrayList<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            for (s in permissions) {
                val permissionCheck = ContextCompat.checkSelfPermission(activity, s)
                val hasPermission = permissionCheck == PackageManager.PERMISSION_GRANTED
                granted = granted and hasPermission
                if (!hasPermission) {
                    permissionsNeeded.add(s)
                }
            }

            if (granted) {
                return true
            } else {
                ActivityCompat.requestPermissions(activity,
                        permissionsNeeded.toTypedArray(),
                        requestCode)
                return false

            }
        } else {
            return true
            // do something for phones running an SDK before M
        }


    }


    fun permissionGranted(activity: Activity, requestCode: Int, permissions: Array<String>, grantResults: IntArray, permissionCode: Int): Boolean {
        if (requestCode == permissionCode) {

            for (permission in permissions) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    //denied
                    Log.w("denied", permission)

                    Toast.makeText(activity, "Required permission : " + permission + "", Toast.LENGTH_SHORT).show()
                    return false
                } else {
                    if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
                        //allowed
                        Log.w("allowed", permission)
                        return true
                    } else {
                        //set to never ask again
                        Log.w("set to never ask again", permission)
                        //do something here.
                        Toast.makeText(activity, "Enable permission in Settings :" + permission + "", Toast.LENGTH_LONG).show()
                        return false
                    }
                }
            }

        }
        return false
    }


}
