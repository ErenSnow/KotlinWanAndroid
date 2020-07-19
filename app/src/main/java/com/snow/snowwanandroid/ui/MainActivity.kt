package com.snow.snowwanandroid.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.snow.snowwanandroid.R
import com.snow.snowwanandroid.base.BaseActivity
import com.snow.snowwanandroid.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主界面
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        // 初始化底部导航栏
        initBottomNavigation()
    }

    /**
     * 初始化底部导航栏
     */
    private fun initBottomNavigation() {
        // NavHostFragment对象
        val navHostFragment = fragmentMain as NavHostFragment
        // Nav控制器
        val navController = navHostFragment.navController
        // 应用栏对象
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(bnvMain.menu).build()
        // 通过Nav底部导航栏与Nav控制器相互关联
        bnvMain.setupWithNavController(navController)
        // 通过Nav设置操作栏
        setupActionBarWithNavController(navController, configuration)
        // 控制更改监听
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            // 弹出返回栈，防止出现点击返回键回退到默认Fragment
            controller.popBackStack()
        }
    }

    override fun createObserver() {
    }

    override fun getLayoutId(): Int =
        R.layout.activity_main
}