package com.goach.taopiaopiao

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.common.alipaystandard.IAliPay

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2018/4/8 0008
 *Time: 11:00
 */
abstract class BaseActivity :AppCompatActivity(),IAliPay {
    private var that:Activity? = null
    override fun attach(activity: Activity) {
        that = activity
    }

    override fun onCreate(@Nullable saveInstance: Bundle?) {
        if(that==null)
        super.onCreate(saveInstance)
    }
    override fun onStart() {
        if(that==null)
        super.onStart()
    }

    override fun onResume() {
        if(that==null)
        super.onResume()
    }

    override fun onPause() {
        if(that==null)
        super.onPause()
    }

    override fun onStop() {
        if(that==null)
        super.onStop()
    }

    override fun onDestroy() {
        if(that==null)
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if(that==null)
        super.onSaveInstanceState(outState)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if(that==null){
            return super.onTouchEvent(ev)
        }
        return that!!.onTouchEvent(ev)
    }

    override fun onBackPressed() {
        if(that==null)
        super.onBackPressed()
    }

    override fun setContentView(layoutResID: Int) {
        if(that==null){
            super.setContentView(layoutResID)
            return
        }
        that!!.setContentView(layoutResID)
    }

    override fun <T : View> findViewById(id: Int): T {
        if(that==null){
            return super.findViewById(id)
        }
        return that!!.findViewById(id)
    }

    override fun getClassLoader(): ClassLoader {
        if(that==null){
            return super.getClassLoader()
        }
        return that!!.classLoader
    }

    override fun getResources(): Resources {
        if(that==null){
            return super.getResources()
        }
        return that!!.resources
    }

    override fun getLayoutInflater(): LayoutInflater {
        if(that==null){
            return super.getLayoutInflater()
        }
        return that!!.layoutInflater
    }

    override fun getWindow(): Window {
        if(that==null){
            return super.getWindow()
        }
        return that!!.window
    }

    override fun getWindowManager(): WindowManager {
        if(that==null){
            return super.getWindowManager()
        }
        return that!!.windowManager
    }

    override fun startActivity(intent: Intent) {
        if(that==null){
            return super.startActivity(intent)
        }
        val newIntent = Intent()
        newIntent.putExtra("className",intent.component.className)
        that!!.startActivity(newIntent)
    }
}