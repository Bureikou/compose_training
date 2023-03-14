package jp.co.faith.playlog_android.exception

import jp.co.faith.playlog_android.data.network.model.ErrorResponse
import java.lang.Exception

class ServerApiException (val errorResponse: ErrorResponse) : Exception()