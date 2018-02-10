package com.codexalters.retrofitnewstructure.extra

import android.app.Activity
import android.app.ProgressDialog


/**
 * Created by codexalters on 20/9/17.
 */

object ProgressDialogUtils {

    internal var alertDialog: ProgressDialog? = null

    fun showProgressDialog(context: Activity, title: String?, message: String?, cancelable: Boolean) {
        if (alertDialog != null) {
            alertDialog!!.show()
        } else if (alertDialog!!.isShowing) {
            return
        } else {
            createProgressDialog(context, title, message, cancelable)
            showProgressDialog(context, title, message, cancelable)
        }
    }

    private fun createProgressDialog(context: Activity, title: String?, message: String?, cancelable: Boolean) {
        alertDialog = ProgressDialog(context/*, R.style.DialogTheme*/)

        alertDialog!!.setTitle(title)
        alertDialog!!.setMessage(message)

        if (cancelable) {
            alertDialog!!.setCancelable(true)
        } else {
            alertDialog!!.setCancelable(false)
        }
    }

    fun dismiss() {
        if (alertDialog != null) {
            alertDialog!!.dismiss()
        }
    }


}
