package jp.co.faith.playlog_android.data.remote.spotify.token

import retrofit2.http.Field

data class TokenRequest(
    @Field("grant_type") val grantType: String,
    @Field("client_id") val clientId: String,
    @Field("client_secret") val clientSecret: String
)