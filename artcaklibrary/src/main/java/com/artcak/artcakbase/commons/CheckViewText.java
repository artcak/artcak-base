package com.artcak.artcakbase.commons;

import android.util.Patterns;
import android.widget.EditText;

public class CheckViewText {
    public static boolean isEmpty(EditText editText, String errorMessage) {
        if (editText.getText().toString().length() == 0) {
            editText.setError(errorMessage);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEqual(EditText editText1, EditText editText2, String errorMessage) {
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();

        if (str1.equals(str2)) {
            return true;
        }
        editText1.setError(errorMessage);
        editText1.setFocusable(true);
        editText1.setFocusableInTouchMode(true);
        editText2.setError(errorMessage);
        editText2.setFocusable(true);
        editText2.setFocusableInTouchMode(true);
        return false;
    }

    public static boolean isEmailInvalid(EditText editText, String errorMessage) {
        if (!Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString()).matches()) {
            editText.setError(errorMessage);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            return true;
        }else {
            return false;
        }
    }

    public static boolean isPhoneInvalid(EditText editText, String errorMessage) {
        if (!Patterns.PHONE.matcher(editText.getText().toString()).matches()) {
            editText.setError(errorMessage);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            return true;
        }else {
            return false;
        }
    }
}
