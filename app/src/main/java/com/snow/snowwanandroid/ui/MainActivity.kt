package com.snow.snowwanandroid.ui

import android.os.Bundle
import com.snow.snowwanandroid.R
import com.snow.snowwanandroid.base.BaseActivity
import com.snow.snowwanandroid.databinding.ActivityMainBinding

/**
 * 主界面
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

    override fun getLayoutId(): Int = R.layout.activity_main
}