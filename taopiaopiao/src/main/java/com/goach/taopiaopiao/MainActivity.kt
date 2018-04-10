package com.goach.taopiaopiao

import android.os.Bundle

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2018/4/8 0008
 *Time: 11:00
 * 没有安装在手机上，所以上下文不能使用
 */
class MainActivity : BaseActivity() {
    override fun onCreate(saveInstance: Bundle?) {
        super.onCreate(saveInstance)
        setContentView(R.layout.activity_main)
    }
}
