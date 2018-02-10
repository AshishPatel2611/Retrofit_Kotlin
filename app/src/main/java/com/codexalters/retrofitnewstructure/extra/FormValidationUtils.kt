package com.codexalters.retrofitnewstructure.extra

import android.text.TextUtils

/**
 * Created by codexalters on 6/2/18.
 */
object FormValidationUtils {

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun isValidText(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && target.length >= 1
    }

    fun isValidPhone(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.PHONE.matcher(target).matches() && target.length > 6
    }

    fun isValidPassword(password: String?): Boolean {

        /*  Pattern pattern;
        Matcher matcher;
//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,15}$";
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,15}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();*/


        var flag = false
        if (password != null && !password.equals("", false)
                && !password.equals(" ", false)
                && password.trim().length >= 8) {
            flag = true
        }
        return flag
    }

    fun isStringValid(value: String?): Boolean {
        var flag = false
        if (value != null && !value.equals("", false)
                && value.trim().isNotEmpty()) {
            flag = true
        }
        return flag
    }


    fun isValidRePassword(pass1: String, pass2: String): Boolean {
        return pass1.equals(pass2)
    }
}