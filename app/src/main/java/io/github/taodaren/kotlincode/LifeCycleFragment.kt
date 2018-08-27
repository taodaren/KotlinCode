package io.github.taodaren.kotlincode

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LifeCycleFragment : Fragment() {
    private val TAG = LifeCycleFragment::class.java.simpleName

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        logI(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logI(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        logI(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logI(TAG, "onActivityCreated")
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

    override fun onDestroyView() {
        super.onDestroyView()
        logI(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logI(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logI(TAG, "onDetach")
    }

}
