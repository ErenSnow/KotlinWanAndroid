package com.snow.snowwanandroid.http

import com.snow.snowwanandroid.model.bean.BannerResponse
import com.snow.snowwanandroid.model.bean.BaseResponseBean
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    /**
     * 获取banner数据
     */
    @GET("banner/json")
    fun getBanner(): BaseResponseBean<List<BannerResponse>>
}