package com.cm.mvparchitecture.ui.home.contract

import com.cm.mvparchitecture.ui.base.contract.PresenterContract
import com.cm.mvparchitecture.ui.base.contract.ViewContract

sealed interface HomeContract {

    interface View: ViewContract {
        fun showAnimation()
        fun hideSoftKeyboard()
    }

    interface Presenter: PresenterContract<View> {
        fun login(username: String, password: String)
    }
}