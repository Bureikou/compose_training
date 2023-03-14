package jp.co.faith.playlog_android.common

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableBoolean
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import jp.co.faith.playlog_android.data.network.model.ErrorResponse

open class BaseViewModel : ViewModel() {

    val isLoading = ObservableBoolean(false)
    val isLoadingDialog = PublishSubject.create<Boolean>()
    val errorEvent = PublishSubject.create<ErrorResponse>()
    val errorMessage = PublishSubject.create<String>()
    val disposable = CompositeDisposable()
    val clickable = ObservableBoolean(true)

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
