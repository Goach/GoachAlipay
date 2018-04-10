package com.goach.alipay

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Resources
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.File

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2018/4/8 0008
 *Time: 11:47
 */
object PluginManager {
    private lateinit var dexClassLoader:DexClassLoader
    private lateinit var resource:Resources
    private var entryActivityName:String = ""
    fun loadPath(context:Context,path: String){
        val dexOutFile = context.getDir("dex",Context.MODE_PRIVATE)
        dexClassLoader = DexClassLoader(path,dexOutFile.absolutePath,null,context.classLoader)

        val packageManager = context.packageManager
        val packageInfo = packageManager.getPackageArchiveInfo(path,PackageManager.GET_ACTIVITIES)
        entryActivityName =  packageInfo.activities[0].name
        //实例化Resource
        val assetManager = AssetManager::class.java.newInstance()
        AssetManager::class.java.getDeclaredMethod("addAssetPath",String::class.java).invoke(assetManager,path)
        resource = Resources(assetManager,context.resources.displayMetrics,context.resources.configuration)
    }
    fun getClassLoader() = dexClassLoader
    fun getResource() = resource
    fun getEntryActivityName() = entryActivityName
}