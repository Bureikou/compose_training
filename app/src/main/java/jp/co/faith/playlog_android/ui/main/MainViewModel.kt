package jp.co.faith.playlog_android.ui.main
import android.util.Log
import androidx.databinding.ObservableField
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import jp.co.faith.playlog_android.common.BaseViewModel
import jp.co.faith.playlog_android.data.ext.io
import jp.co.faith.playlog_android.data.ext.mainThread
import jp.co.faith.playlog_android.data.ext.subscribeWithErrorMessage
import jp.co.faith.playlog_android.data.network.search.AppleMusicRemote

class MainViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    val searchText: ObservableField<String> = ObservableField("")

    private fun hasText(vararg fields: ObservableField<String>): Boolean {
        return fields.any { it.get().isNullOrBlank() }.not()
    }

    fun clickSearch()
    {
        if (hasText(searchText)) {
            appleContents(searchText.get().toString())
        }
    }

    private val appleMusicRemote = AppleMusicRemote()
    private var eventDetail: jp.co.faith.playlog_android.data.network.search.Result? = null

    val getAppleContents: PublishSubject<Int> = PublishSubject.create()

    fun appleContents(searchWord: String) {
        appleMusicRemote.execGetAppleMusicLibrary(searchWord)
            .subscribeOn(io())
            .observeOn(mainThread())
            .doOnSubscribe { isLoading.set(true) }
            .doFinally { isLoading.set(false) }
            .subscribeWithErrorMessage(errorEvent) { response ->
//                eventDetail = response.results
                getAppleContents.onNext(1)
            }.addTo(disposable)
    }
}