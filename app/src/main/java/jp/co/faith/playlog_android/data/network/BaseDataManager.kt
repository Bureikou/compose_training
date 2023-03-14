package jp.co.faith.playlog_android.data.network

import retrofit2.Retrofit

open class BaseDataManager() {

    val retrofit: Retrofit = RetrofitInstance.instance()

    protected inline fun <reified T> connector(): T {
        return retrofit.create(T::class.java)
    }
}