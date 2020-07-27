package com.snow.snowwanandroid.http

import androidx.lifecycle.liveData
import kotlin.coroutines.CoroutineContext

open class BaseRepository {

    suspend fun <T : Any> fire(
        context: CoroutineContext,
//        response: BaseResponseBean<T>,
        block: suspend () -> Result<T>
    ) =
        liveData(context) {
            val result = try {
//                if (response.errorCode == -1) {
//                    Result.failure<T>(
//                        Exception(
//                            "程序异常!错误码为: ${response.errorCode}, 错误信息为: ${response.errorMsg}"
//                        )
//                    )
//                } else {
//                }
                block()
            } catch (e: Exception) {
                Result.failure<T>(
                    Exception(
                        "程序异常!错误信息为: ${e.message}}"
                    )
                )
            }
            emit(result)
        }
}