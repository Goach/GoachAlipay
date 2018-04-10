package com.goach.alipay

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import com.common.alipaystandard.IAliPay
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException

/**
 * Goach All Rights Reserved
 * User: Goach
 * Date: 2018/4/9 0009
 * Time: 10:49
 * 这里暂时不知道怎么兼容AppCompatActivity 23333
 * 貌似RePlugin里面的AppCompatActivity也是替换成了RepluginAppCompatActivity，日后有待研究
 */
class ProxyActivity : Activity() {
    private var className: String? = null
    private var aliPayInterface: IAliPay? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        className = intent.getStringExtra("className")
        try {
            val activityClass = classLoader.loadClass(className)
            val constructor = activityClass.getConstructor(*arrayOf())
            val instance = constructor.newInstance(*arrayOf())
            aliPayInterface = instance as IAliPay
            aliPayInterface!!.attach(this)
            val bundle = Bundle()
            aliPayInterface!!.onCreate(bundle)

        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

    }

    override fun onStart() {
        super.onStart()
        aliPayInterface!!.onStart()
    }

    override fun onResume() {
        super.onResume()
        aliPayInterface!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        aliPayInterface!!.onPause()
    }

    override fun onStop() {
        super.onStop()
        aliPayInterface!!.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        aliPayInterface!!.onDestroy()
    }

    override fun getClassLoader(): ClassLoader {
        return PluginManager.getClassLoader()
    }

    override fun getResources(): Resources {
        return PluginManager.getResource()
    }

    override fun startActivity(intent: Intent) {
        val classNameFromTaoPiaoPiao = intent.getStringExtra("className")
        val newIntent = Intent(this, ProxyActivity::class.java)
        newIntent.putExtra("className", classNameFromTaoPiaoPiao)
        startActivity(newIntent)
    }
}
