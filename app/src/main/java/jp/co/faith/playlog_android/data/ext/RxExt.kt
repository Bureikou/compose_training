package jp.co.faith.playlog_android.data.ext

import com.google.gson.JsonParseException
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import jp.co.faith.playlog_android.data.network.model.ErrorResponse
import jp.co.faith.playlog_android.exception.ServerApiException

/**
 * サーバーからのエラーをハンドリングして、エラーレスポンスを受け取る
 * 但し、非サーバーエラーはキャッチしない。
 */
fun <T> Single<T>.onErrorResponse(handler: (ErrorResponse?, Exception) -> Unit) : Single<T> {

    return this.doOnError {
        when (it) {
            is ServerApiException -> handler.invoke(null, it)
        }
    }
}

fun <T> Single<T>.subscribeErrorComplete(onSuccess: ((T) -> Unit)) : Disposable {

    return subscribe(onSuccess, {
        when (it) {
            is ServerApiException -> {}
        }
    })
}

fun <T> PublishSubject<T>.subscribeWithDisposable(disposable: CompositeDisposable, action: ((t: T) -> Unit)) {

    val d = this
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(action)
    disposable.add(d)
}

fun <T> Observable<T>.onErrorResponse(handler: (ErrorResponse?, Exception) -> Unit) : Observable<T> {

    return this.doOnError {
        when (it) {
            is ServerApiException -> handler.invoke(null, it)
        }
    }
}

fun <T> Observable<T>.subscribeIgnoreError(onSuccess: ((T) -> Unit)) : Disposable {

    return subscribe(onSuccess, {
        when (it) {
            is ServerApiException -> {}
        }
    })
}

fun <T> Observable<T>.subscribeWithErrorMessage(subject: PublishSubject<ErrorResponse>, onSuccess: ((T) -> Unit)) : Disposable {
    return subscribe(onSuccess, { errorHandle(it, subject) })
}

fun <T> Single<T>.subscribeWithErrorMessage(subject: PublishSubject<ErrorResponse>, onSuccess: ((T) -> Unit)) : Disposable {
    return subscribe(onSuccess, { errorHandle(it, subject) })
}

private fun errorHandle(t: Throwable, subject: PublishSubject<ErrorResponse>) {
    when (t) {
        is ServerApiException -> { subject.onNext(t.errorResponse) }
        is JsonParseException -> { throw JsonParseException(t) }
    }
}

fun newThread(): Scheduler = Schedulers.newThread()
fun io(): Scheduler = Schedulers.io()
fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
