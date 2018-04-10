package com.goach.alipay

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoad.setOnClickListener {
           val file = File(Environment.getExternalStorageDirectory(),"plugin.apk")
            PluginManager.loadPath(applicationContext,file.absolutePath)
        }
        btnClick.setOnClickListener {
            val intent = Intent(this,ProxyActivity::class.java)
            intent.putExtra("className",PluginManager.getEntryActivityName())
            startActivity(intent)
        }
    }
}
