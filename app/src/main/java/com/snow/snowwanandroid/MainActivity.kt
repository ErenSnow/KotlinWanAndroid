package com.snow.snowwanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主界面
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}