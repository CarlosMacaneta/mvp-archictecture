package com.cm.mvparchitecture.ui.welcome.contract

import com.cm.mvparchitecture.ui.base.contract.PresenterContract
import com.cm.mvparchitecture.ui.base.contract.ViewContract

sealed interface WelcomeViewContract {

    interface View : ViewContract {}

    interface Presenter : PresenterContract<View> {
        fun message(msg: String)
    }
}