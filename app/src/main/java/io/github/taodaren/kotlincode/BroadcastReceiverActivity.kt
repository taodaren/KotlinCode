package io.github.taodaren.kotlincode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class BroadcastReceiverActivity : AppCompatActivity() {
    private var mReceiver: MyBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)
        // 动态注册广播
        mReceiver = MyBroadcastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(mReceiver,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 取消广播
        unregisterReceiver(mReceiver)
    }

    class MyBroadcastReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "音量发生改变", Toast.LENGTH_SHORT).show()
        }
    }
}
