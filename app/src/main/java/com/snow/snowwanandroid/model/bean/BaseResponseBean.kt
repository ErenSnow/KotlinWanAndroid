package com.snow.snowwanandroid.model.bean

/**
 * 响应数据基类
 */
data class BaseResponseBean<out T>(val errorCode: Int, val errorMsg: String, val data: T)