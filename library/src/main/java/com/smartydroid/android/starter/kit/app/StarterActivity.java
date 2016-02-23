/**
 * Created by YuGang Yang on October 30, 2015.
 * Copyright 2007-2015 Laputapp.com. All rights reserved.
 */
package com.smartydroid.android.starter.kit.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.smartydroid.android.starter.kit.utilities.StarterCommon;

/**
 * 所有 Activity 都继承此基类
 */
public abstract class StarterActivity extends AppCompatActivity {

  private StarterCommon starterCommon;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    starterCommon = new StarterCommon(this);
  }

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
  }

  @Override public void finish() {
    hideSoftInputMethod();
    super.finish();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
    starterCommon.onDestroy();
    starterCommon = null;
  }

  public boolean isProgressShow() {
    return starterCommon != null && starterCommon.isProgressShow();
  }

  public void showProgressLoading(int resId) {
    if (starterCommon == null) {
      return;
    }
    showProgressLoading(getString(resId));
  }

  public void showProgressLoading(String text) {
    if (starterCommon == null) {
      return;
    }
    starterCommon.showProgressLoading(text);
  }

  public void dismissProgressLoading() {
    if (starterCommon == null) {
      return;
    }
    starterCommon.dismissProgressLoading();
  }

  public void showUnBackProgressLoading(int resId) {
    if (starterCommon == null) {
      return;
    }
    showUnBackProgressLoading(getString(resId));
  }

  public void showUnBackProgressLoading(String text) {
    if (starterCommon == null) {
      return;
    }
    starterCommon.showUnBackProgressLoading(text);
  }

  public void dismissUnBackProgressLoading() {
    if (starterCommon == null) {
      return;
    }
    starterCommon.dismissUnBackProgressLoading();
  }

  public void hideSoftInputMethod() {
    if (starterCommon == null) {
      return;
    }
    starterCommon.hideSoftInputMethod();
  }

  public void showSoftInputMethod() {
    if (starterCommon == null) {
      return;
    }
    starterCommon.showSoftInputMethod();
  }

  public boolean isImmActive() {
    return starterCommon != null && starterCommon.isImmActive();
  }

  /**
   * Converts an intent into a {@link android.os.Bundle} suitable for use as fragment arguments.
   */
  public static Bundle intentToFragmentArguments(Intent intent) {
    Bundle arguments = new Bundle();
    if (intent == null) {
      return arguments;
    }

    final Uri data = intent.getData();
    if (data != null) {
      arguments.putParcelable("_uri", data);
    }

    final Bundle extras = intent.getExtras();
    if (extras != null) {
      arguments.putAll(intent.getExtras());
    }

    return arguments;
  }

  /**
   * Converts a fragment arguments bundle into an intent.
   */
  public static Intent fragmentArgumentsToIntent(Bundle arguments) {
    Intent intent = new Intent();
    if (arguments == null) {
      return intent;
    }

    final Uri data = arguments.getParcelable("_uri");
    if (data != null) {
      intent.setData(data);
    }

    intent.putExtras(arguments);
    intent.removeExtra("_uri");
    return intent;
  }

}
