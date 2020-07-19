package com.snow.snowwanandroid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.snow.snowwanandroid.R
import com.snow.snowwanandroid.base.BaseFragment
import com.snow.snowwanandroid.databinding.FragmentMainBinding
import com.snow.snowwanandroid.ui.blog.BlogFragment
import com.snow.snowwanandroid.ui.home.HomeFragment
import com.snow.snowwanandroid.ui.mine.MineFragment
import com.snow.snowwanandroid.ui.project.ProjectFragment
import com.snow.snowwanandroid.ui.system.SystemFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        // 初始化ViewPager
        initViewPager()
        // 初始化BottomNavigation
        initBottomNavigation()
    }

    /**
     * 初始化ViewPager
     */
    private fun initViewPager() {
        vpMain.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeFragment()
                    1 -> SystemFragment()
                    2 -> BlogFragment()
                    3 -> ProjectFragment()
                    4 -> MineFragment()
                    else -> HomeFragment()
                }
            }

            override fun getItemCount() = 5
        }
    }

    /**
     * 初始化BottomNavigation
     */
    private fun initBottomNavigation() {
        bnvMain.enableAnimation(true)
        bnvMain.enableShiftingMode(false)
        bnvMain.enableItemShiftingMode(true)
        bnvMain.setTextSize(12F)
        bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> vpMain.setCurrentItem(0, false)
                R.id.menu_system -> vpMain.setCurrentItem(1, false)
                R.id.menu_blog -> vpMain.setCurrentItem(2, false)
                R.id.menu_project -> vpMain.setCurrentItem(3, false)
                R.id.menu_mine -> vpMain.setCurrentItem(4, false)
            }
            true
        }
    }

    fun BottomNavigationViewEx.init(navigationItemSelectedAction: (Int) -> Unit): BottomNavigationViewEx {
        enableAnimation(true)
//        enableShiftingMode(false)
//        enableItemShiftingMode(true)
        setTextSize(12F)
        setOnNavigationItemSelectedListener {
            navigationItemSelectedAction.invoke(it.itemId)
            true
        }
        return this
    }

    override fun createObserver() {

    }

    override fun lazyLoadData() {

    }

}