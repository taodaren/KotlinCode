package io.github.taodaren.kotlincode

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MgrTransactionActivity : AppCompatActivity(), View.OnClickListener {
    private var mAddBtn: Button? = null
    private var mRemoveBtn: Button? = null
    private var mReplaceBtn: Button? = null
    private var mHideBtn: Button? = null
    private var mShowBtn: Button? = null
    private var mDetachBtn: Button? = null
    private var mAttachBtn: Button? = null
    private var mSecondFragment: Fragment? = null
    private var mThirdFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mgr_transaction)

        mAddBtn = findViewById(R.id.add_btn)
        mRemoveBtn = findViewById(R.id.remove_btn)
        mReplaceBtn = findViewById(R.id.replace_btn)
        mHideBtn = findViewById(R.id.hide_btn)
        mShowBtn = findViewById(R.id.show_btn)
        mAttachBtn = findViewById(R.id.attach_btn)
        mDetachBtn = findViewById(R.id.detach_btn)

        // 创建和获取 Fragment 实例
        mSecondFragment = SecondFragment()
        mThirdFragment = ThirdFragment()

        // 设置监听事件
        mAddBtn!!.setOnClickListener(this)
        mRemoveBtn!!.setOnClickListener(this)
        mReplaceBtn!!.setOnClickListener(this)
        mHideBtn!!.setOnClickListener(this)
        mShowBtn!!.setOnClickListener(this)
        mAttachBtn!!.setOnClickListener(this)
        mDetachBtn!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // 获取到 FragmentManager 对象
        val fragmentManager = supportFragmentManager
        // 开启一个事务
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Fragment 操作
        when (v.id) {
            R.id.add_btn -> {
                // 向容器内加入 Fragment
                if (!mSecondFragment!!.isAdded && null == fragmentManager.findFragmentById(R.id.fragment_container1)) {
                    fragmentTransaction.add(R.id.fragment_container1, mSecondFragment!!)
                }
                if (!mThirdFragment!!.isAdded && null == fragmentManager.findFragmentById(R.id.fragment_container2)) {
                    fragmentTransaction.add(R.id.fragment_container2, mThirdFragment!!)
                }
            }
            R.id.remove_btn ->
                // 从容器类移除 Fragment
                fragmentTransaction.remove(this.mSecondFragment!!)
            R.id.replace_btn -> if (!mSecondFragment!!.isAdded) {
                fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment!!)
            }
            R.id.hide_btn -> if (!mSecondFragment!!.isHidden) {
                fragmentTransaction.hide(mSecondFragment!!)
            }
            R.id.show_btn -> if (mSecondFragment!!.isHidden) {
                fragmentTransaction.show(mSecondFragment!!)
            }
            R.id.attach_btn -> if (mSecondFragment!!.isDetached) {
                fragmentTransaction.attach(mSecondFragment!!)
            }
            R.id.detach_btn -> if (!mSecondFragment!!.isDetached) {
                fragmentTransaction.detach(mSecondFragment!!)
            }
            else -> {
            }
        }

        // 提交事务
        fragmentTransaction.commit()
    }
}
