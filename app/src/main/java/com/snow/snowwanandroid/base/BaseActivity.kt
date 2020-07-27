package com.snow.snowwanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Activity基类
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * 绑定的ViewDataBinding
     */
    protected lateinit var mDataBinging: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 初始化DataBinding
        initDataBind()
        // 初始化布局
        initView(savedInstanceState)
        // 创建LiveData数据观察者
        createObserver()
    }

    /**
     * 初始化DataBinding
     */
    private fun initDataBind() {
        mDataBinging = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBinging.lifecycleOwner = this
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
}