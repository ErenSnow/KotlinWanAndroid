package com.snow.snowwanandroid.ui.blog

import android.os.Bundle
import com.snow.snowwanandroid.R
import com.snow.snowwanandroid.base.BaseFragment
import com.snow.snowwanandroid.databinding.FragmentBlogBinding

class BlogFragment : BaseFragment<FragmentBlogBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_blog

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
    }

}