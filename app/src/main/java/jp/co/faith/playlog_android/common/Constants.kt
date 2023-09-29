package jp.co.faith.playlog_android.common

object Constants {
    const val API_KEY = "uK1OPHoOg4EXsiI9zmQuK7V3ptPRHV6smeu54wcL6c8"
    const val BASE_URL = "https://api.unsplash.com"
    const val SHOPIFY_BASE_URL = "https://accounts.spotify.com"

    const val BASE_URL_APPLE = "https://api.music.apple.com"
    internal object Search {
        const val API_APPLE: String = "https://api.music.apple.com/v1/catalog/jp/search"
    }
    internal object Token {
        const val APPLE_DEV_TOKEN: String = "Bearer eyJhbGciOiJFUzI1NiIsImtpZCI6IllCUTNSNzhZTEgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJLM1hTUExYWDZDIiwiZXhwIjoxNjk1OTcyNjAwLCJpYXQiOjE2OTU3OTk4MDB9.mzIZQL26KJV3YKZurZuE08dq_6vyej3bUq7yUzPipEsZjEtkEX0bBFC_HBWTIRG_BFeDChY5-5zVNJk4g-KGyQ"
    }
    internal object Spotify {
        const val API_SPOTIFY_OAUTH: String = "https://accounts.spotify.com/authorize"
        const val SPOTIFY_SCOPES: String = "https://accounts.spotify.com/authorize"
        const val SPOTIFY_REDIRECT_URI: String = "playlog-test://callback"
        const val CLIENT_ID: String = "55999ef0a2394963bccbc8fea5452685"
        const val CLIENT_SECRET: String = "46d1967d01ce4654ba3a1a4558f0035d"
    }
}