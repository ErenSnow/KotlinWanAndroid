package com.snow.snowwanandroid.http

/**
 * 响应结果
 */
//sealed class Result<out T : Any> {
//
//    /**
//     * 响应成功
//     */
//    data class Success<out T : Any>(val data: T) : Result<T>()
//
//    /**
//     * 响应失败
//     */
//    data class Error(val error: Exception) : Result<Nothing>()
//
//    override fun toString(): String {
//        return when (this) {
//            is Success -> "Success[data=$data]"
//            is Error -> "Error[exception=$error]"
//        }
//    }
//}