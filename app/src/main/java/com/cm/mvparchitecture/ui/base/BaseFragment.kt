package com.cm.mvparchitecture.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cm.mvparchitecture.ui.base.contract.PresenterContract
import com.cm.mvparchitecture.ui.base.contract.ViewContract

abstract class BaseFragment<VB : ViewBinding, P: PresenterContract<*>>(
    private val inflate: (
        inflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ) -> VB
): Fragment(), ViewContract {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding as VB

    abstract fun getPresenter(): PresenterContract<ViewContract>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getPresenter().attachView(this)
    }

    override fun onStop() {
        super.onStop()
        getPresenter().detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}