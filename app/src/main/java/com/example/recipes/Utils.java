package com.example.recipes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

public class Utils
{
    //Задаем цвет шапки, такой же как фон приложения

    @SuppressLint("NewApi")
    public static void changeStatusBarAndNavigationBarColor(Activity activity, int statusBarColor, int navigationColor)
    {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity, statusBarColor));
        window.setNavigationBarColor(ContextCompat.getColor(activity, navigationColor));

    }
}
