package io.github.taodaren.kotlincode

import android.util.Log

var isStartLog = true

fun logD(tag: String, msg: String) {
    if (isStartLog) {
        Log.d(tag, msg)
    }
}

fun logE(tag: String, msg: String) {
    if (isStartLog) {
        Log.e(tag, msg)
    }
}

fun logI(tag: String, msg: String) {
    if (isStartLog) {
        Log.i(tag, msg)
    }
}

fun logW(tag: String, msg: String) {
    if (isStartLog) {
        Log.w(tag, msg)
    }
}

fun logV(tag: String, msg: String) {
    if (isStartLog) {
        Log.v(tag, msg)
    }
}