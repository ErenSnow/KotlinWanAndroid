package com.snow.snowwanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navHostFragment = fragmentMain as NavHostFragment
//        val navController = navHostFragment.navController
//        bnvMain.setupWithNavController(navController)

        val navController = Navigation.findNavController(this, R.id.fragmentMain)
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(bnvMain.menu).build()
        NavigationUI.setupActionBarWithNavController(this, navController, configuration)
        NavigationUI.setupWithNavController(bnvMain, navController)
    }
}