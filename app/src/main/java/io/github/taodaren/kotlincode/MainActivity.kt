package io.github.taodaren.kotlincode

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logI(TAG, "onCreate")

        val mButton = findViewById<Button>(R.id.btn)
        mButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", "data from MainActivity")
            startActivityForResult(intent, 1)
        }
    }

    override fun onStart() {
        super.onStart()
        logI(TAG, "onStart")
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

    override fun onRestart() {
        super.onRestart()
        logI(TAG, "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        logI(TAG, "onSaveInstanceState")
        val saveData = "save data"
        outState!!.putString("key", saveData)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        logI(TAG, "onRestoreInstanceState")
        val getData = savedInstanceState!!.getString("key")
        logI(TAG, getData)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val extra = data!!.getStringExtra("return_data")
                logI("taodaren", extra)
            }
        }
    }

}

