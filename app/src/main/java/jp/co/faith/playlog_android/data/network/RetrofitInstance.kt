package jp.co.faith.playlog_android.data.network

import jp.co.faith.playlog_android.App
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.co.faith.playlog_android.data.network.model.ErrorResponse
import jp.co.faith.playlog_android.exception.ServerApiException
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {

        const val DEVTOKEN = "Authorization"

        private var retrofit: Retrofit? = null
        private var moshi: Moshi? = null
        private var okHttpClient: OkHttpClient? = null

        fun instance(): Retrofit {
            return retrofit ?: let {
                RetrofitInstance().provide("https://api.music.apple.com/v1" + "/").apply {
                    retrofit = this
                }
            }
        }
    }

    private fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private fun okHttpClient(moshi: Moshi): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ApiInterceptor())
            .addInterceptor(ErrorInterceptor(moshi))
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    fun provide(baseUrl: String = "https://api.music.apple.com/v1" + "/"): Retrofit {
        if (moshi == null) {
            moshi = provideMoshi()
        }
        if (okHttpClient == null) {
            okHttpClient = okHttpClient(moshi!!)
        }
        okHttpClient?.interceptors
        return Retrofit.Builder()
            .client(okHttpClient!!)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi!!))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    inner class ApiInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain
                .request()
                .newBuilder()
                .addHeader(DEVTOKEN, "Bearer eyJhbGciOiJFUzI1NiIsImtpZCI6Ik43V0s0MjNBWVEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJLM1hTUExYWDZDIiwiZXhwIjoxNjkwNzAyMzg4LCJpYXQiOjE2Nzc3NDIzODh9.r5xzEEtEIfoijUNTRJy3tv2d1N9bLsBrPU6tcAiM3MWql55biEapTcVSCKQ0gsDPPgyo5LXt5MrAwuTaHcnrPw")
                .build()

            //  Token保存処理
            val response = chain.proceed(newRequest)
            if (response.code == 200) {

            }

            return response
        }
    }

    inner class ErrorInterceptor(private val moshi: Moshi) : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            Log.d("response", "response:" + response)
            if (response.code >= 400) {
                val error = response.body?.source()?.let {
                    moshi.adapter(ErrorResponse::class.java).fromJson(it)
                }
            }

            return response
        }
    }

    inner class TokenAuthenticator() : Authenticator {

        private val retryCounter: Int = 0

        override fun authenticate(route: Route?, response: Response): Request? {
            return if (response.code == 400) {
                val token = ""
                response.request.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build();
            } else {
                null
            }
        }
    }
}