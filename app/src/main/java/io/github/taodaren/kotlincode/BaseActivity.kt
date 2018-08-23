package io.github.taodaren.kotlincode

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStack.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        activityStack.remove(this)
    }

    companion object {
        // 存放 Activity 的栈
        val activityStack = Stack<Activity>()

        fun put(a: Activity) {
            activityStack.add(a)
        }

        /** 结束所有的 Activity */
        fun finishAll() {
            while (!activityStack.empty()) {
                activityStack.pop().finish()
            }
        }
    }

    /** 销毁特定 Activity */
    fun finishActivity(simpleName: String) {
        // 通过变量栈中的 Activity，找到对应名称的 Activity，然后销毁
        for (activity in activityStack) {
            if (activity.javaClass.simpleName == simpleName) {
                activity.finish()
                activityStack.remove(activity)
                break
            }
        }
    }

}