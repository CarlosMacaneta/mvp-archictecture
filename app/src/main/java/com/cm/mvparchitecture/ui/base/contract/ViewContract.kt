package com.cm.mvparchitecture.ui.base.contract

interface ViewContract: NavigationContract {
    fun showLoading()
    fun hideLoading()
    fun showError(error: String)
    fun showSuccess(message: String)
}