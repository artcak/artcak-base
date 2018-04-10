package com.artcak.artcakbase.tools;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    private Activity activity;
    public Tools(Activity activity){
        this.activity = activity;
    }

    public boolean isEmailValid(String stringValue) {
        return isPatternMatches(Patterns.EMAIL_ADDRESS.pattern(),stringValue);
    }
    public boolean isPhoneValid(String stringValue) {
        return isPatternMatches(Patterns.PHONE.pattern(),stringValue);
    }
    public boolean isPatternMatches(String stringPattern, String stringValue){
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(stringValue).matches();
    }
    public boolean isTextViewEmpty(TextView textView){
        return textView.getText().toString().equals("");
    }
    public void toastShort(String stringMessage){
        Toast.makeText(activity, stringMessage, Toast.LENGTH_SHORT).show();
    }
    public void toastLong(String stringMessage){
        Toast.makeText(activity, stringMessage, Toast.LENGTH_LONG).show();
    }

    public static String getCurrencyFormat(String val) {
        NumberFormat myformat = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.valueOf(myformat.format(val)).replace(".00", "").replace(",", ".").replace("$", "");
        result = result.replace(",-", "");
        return result.replace(",00", "");
    }
    public static String getCurrencyFormat(int val) {
        return getCurrencyFormat(String.valueOf(val));
    }
    public static String getCurrencyFormat(Double val) {
        return getCurrencyFormat(String.valueOf(val));
    }

    public static int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
    public void log(String stringMessage){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String callerMethodName = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String tempString = "";
        for (StackTraceElement stackTraceElement: stackTraceElements){
            if (tempString.equals(methodName)){
                callerMethodName = stackTraceElement.getMethodName();
                break;
            }
            if (stackTraceElement.getMethodName().equals(methodName)){
                tempString = methodName;
            }
        }
        Log.i(Var.TAG,activity.getLocalClassName()+"->"+callerMethodName+"() "+stringMessage);
    }

    public static Gson gsonFormater() {
        return new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }

    public Object getObject(Class pojo, String stringValue) {
        return gsonFormater().fromJson(stringValue,pojo);
    }

    public void closeKeyboard(){
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
