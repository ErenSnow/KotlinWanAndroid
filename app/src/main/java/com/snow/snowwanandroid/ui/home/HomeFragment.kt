package com.snow.snowwanandroid.ui.home

import android.os.Bundle
import com.snow.snowwanandroid.R
import com.snow.snowwanandroid.base.BaseFragment
import com.snow.snowwanandroid.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
    }

}