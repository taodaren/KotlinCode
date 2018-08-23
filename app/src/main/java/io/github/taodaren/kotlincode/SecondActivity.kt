package io.github.taodaren.kotlincode

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : BaseActivity() {
    companion object {
        fun start(activity: Activity, data: Int) {
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("data", data)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.getStringExtra("data")
        logI("taodaren", data)

        val intent = Intent()
        intent.putExtra("return_data", "data from SecondActivity")
        setResult(Activity.RESULT_OK, intent)
    }
}
