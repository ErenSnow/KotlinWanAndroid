package com.snow.snowwanandroid.model.repository

import com.snow.snowwanandroid.http.BaseRepository
import com.snow.snowwanandroid.http.apiService
import kotlinx.coroutines.Dispatchers

/**
 * Created by luyao
 * on 2019/4/10 14:09
 */
class HomeRepository : BaseRepository() {

    suspend fun refreshWeather() = fire(Dispatchers.IO) {
        val bannerResponse = apiService.getBanner()
        if (bannerResponse.errorCode != -1) {
            val bannerList = bannerResponse.data
            Result.success(bannerList)
        } else {
            Result.failure(RuntimeException("response status is ${bannerResponse.errorMsg}"))
        }
    }



//        coroutineScope {
//            val deferredRealtime = async {
//                apiService.getBanner()
//            }
//            val realtimeResponse = deferredRealtime.await()
//            if (realtimeResponse.errorCode!=-1) {
//                Result.success()
//            }else{
//
//            }
//        }
}