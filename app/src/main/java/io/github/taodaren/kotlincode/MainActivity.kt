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

        onClickBtn()
        // 动态添加 Fragment
        fragmentDynamicAdd()
    }

    private fun onClickBtn() {
        val mButton = findViewById<Button>(R.id.btn)
        val btnFragLife = findViewById<Button>(R.id.btn_fragment_life)
        val btnMgrTransaction = findViewById<Button>(R.id.btn_fragment_mgr)
        mButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", "data from MainActivity")
            startActivityForResult(intent, 1)
        }
        btnFragLife.setOnClickListener { startActivity(Intent(this, LifeCycleActivity::class.java)) }
        btnMgrTransaction.setOnClickListener { startActivity(Intent(this, MgrTransactionActivity::class.java)) }
    }

    /** 动态添加 Fragment */
    private fun fragmentDynamicAdd() {
        // 1. 获取到 FragmentManager 对象
        val fragmentManager = supportFragmentManager
        // 2. 开启一个事务
        val fragmentTransaction = fragmentManager.beginTransaction()
        // 3. 向容器内加入 Fragment
        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.fragment_container, firstFragment)
        // 4. 提交事务
        fragmentTransaction.commit()
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

