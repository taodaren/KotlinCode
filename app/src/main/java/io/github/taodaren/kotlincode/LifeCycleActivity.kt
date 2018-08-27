package io.github.taodaren.kotlincode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LifeCycleActivity : AppCompatActivity() {
    private val TAG = LifeCycleActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logI(TAG, "onCreate")
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onStart() {
        super.onStart()
        logI(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        logI(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        logI(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        logI(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        logI(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logI(TAG, "onDestroy")
    }
}
