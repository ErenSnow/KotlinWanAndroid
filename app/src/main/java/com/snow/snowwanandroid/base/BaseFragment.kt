package com.snow.snowwanandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

/**
 * Fragment基类
 */
abstract class BaseFragment : Fragment() {

    /**
     * 绑定的ViewDataBinding
     */
    protected lateinit var mDataBinging: ViewDataBinding

    /**
     * Fragment对应的Activity的上下文
     */
    lateinit var mContext: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinging = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mDataBinging.lifecycleOwner = this
        return mDataBinging.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 初始化布局
        initView(savedInstanceState)
        // 创建LiveData数据观察者
        createObserver()
        // 懒加载
        if (lifecycle.currentState == Lifecycle.State.STARTED) {
            lazyLoadData()
        }
    }

    /**
     * 绑定的视图布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 创建LiveData数据观察者
     */
    abstract fun createObserver()

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()
}