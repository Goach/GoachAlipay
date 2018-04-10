package com.common.alipaystandard

import android.app.Activity
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2018/4/8 0008
 *Time: 10:32
 * 制定插件化的标准，实现Activity的生命周期
 */
interface IAliPay {
    fun onCreate(@Nullable saveInstance: Bundle?)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    fun onSaveInstanceState(outState:Bundle)
    fun onTouchEvent(ev:MotionEvent):Boolean
    fun onBackPressed()
    fun attach(activity: Activity)
}