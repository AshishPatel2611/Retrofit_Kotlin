package com.codexalters.retrofitnewstructure.extra

import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Created by codexalters on 6/2/18.
 */
object ToastUtils {

    fun showSnackBar(view: View, message: String, isUndoButtonRequired: Boolean) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        if (isUndoButtonRequired) {
            snackbar.setAction("Undo", View.OnClickListener {
                val snackbar1 = Snackbar.make(view, "Message is restored!", Snackbar.LENGTH_SHORT)
                snackbar1.show()
            }).setActionTextColor(Color.WHITE)
        }
        snackbar.show()
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


}