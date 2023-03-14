package com.example.playlog_android.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.playlog_android.R
import com.example.playlog_android.databinding.FragmentMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import jp.co.faith.playlog_android.data.ext.mainThread
import jp.co.faith.playlog_android.ui.main.MainViewModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import jp.co.faith.playlog_android.data.ext.toast

class MainFragment : Fragment() {

    private lateinit var bind: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        bind.vm = viewModel

        viewModel.errorEvent
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy {
                requireContext().toast(it.fullMessage)
            }.addTo(viewModel.disposable)

        viewModel.getAppleContents
            .observeOn(mainThread())
            .subscribeBy {
                Log.d("test","getAppleContents done")
            }.addTo(viewModel.disposable)

        return bind.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}