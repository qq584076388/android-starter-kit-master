package com.smartydroid.android.kit.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import com.smartydroid.android.kit.demo.ui.activity.LoginActivity;
import com.smartydroid.android.kit.demo.ui.activity.TabActivity;

/**
 * Created by YuGang Yang on February 20, 2016.
 * Copyright 20015-2016 qiji.tech. All rights reserved.
 */
public final class NavUtils {

  public static void startTab(Activity activity) {
    Intent intent = new Intent(activity, TabActivity.class);
    ActivityCompat.startActivity(activity, intent, null);
  }

  public static void startLogin(Activity activity) {
    Intent intent = new Intent(activity, LoginActivity.class);
    ActivityCompat.startActivity(activity, intent, null);
  }

  private NavUtils() {

  }
}
