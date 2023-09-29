package jp.co.faith.playlog_android.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.faith.playlog_android.common.Constants.BASE_URL
import jp.co.faith.playlog_android.common.Constants.BASE_URL_APPLE
import jp.co.faith.playlog_android.common.Constants.SHOPIFY_BASE_URL
import jp.co.faith.playlog_android.data.remote.apple.AppleApi
import jp.co.faith.playlog_android.data.remote.spotify.token.ShopifyTokenApi
import jp.co.faith.playlog_android.data.repository.AppleRepositoryImpl
import jp.co.faith.playlog_android.data.repository.ShopifyRepositoryImpl
import jp.co.faith.playlog_android.domain.repository.AppleRepository
import jp.co.faith.playlog_android.domain.repository.ShopifyRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppleApi(): AppleApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_APPLE)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(AppleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppleRepository(api: AppleApi): AppleRepository {
        return AppleRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideShopifyTokenApi(): ShopifyTokenApi {
        return Retrofit.Builder()
            .baseUrl(SHOPIFY_BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(ShopifyTokenApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShopifyTokenRepository(api: ShopifyTokenApi): ShopifyRepository {
        return ShopifyRepositoryImpl(api)
    }
}