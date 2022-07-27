package com.cm.mvparchitecture.ui.base.contract

interface PresenterContract<T: ViewContract> {
    fun attachView(view: T)
    fun detachView()
    fun onAttached()
    fun onDetached()
    fun onDestroy()
}