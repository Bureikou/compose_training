package jp.co.faith.playlog_android.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelLazy
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(classVM: KClass<VM>) : Fragment() {

    protected lateinit var bind: VB
    protected abstract val layoutID: Int
    open val viewModel by ViewModelLazy(classVM, { viewModelStore }, { defaultViewModelProviderFactory })
    open val loading by lazy { LoadingDialog(requireContext()).apply { setCancelable(false) } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, layoutID, container, false)
        bindViewModel()
        observeViewModel()
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView(savedInstanceState)
        initializeAction()
    }

    open fun bindViewModel() {}

    abstract fun initializeView(savedInstanceState: Bundle?)

    abstract fun observeViewModel()

    abstract fun initializeAction()

    open fun showLoading() {
        loading.apply { if (!isShowing) show() }
    }

    open fun hideLoading() {
        loading.dismiss()
    }
}
