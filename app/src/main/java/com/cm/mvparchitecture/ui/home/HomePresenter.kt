package com.cm.mvparchitecture.ui.home

import com.cm.mvparchitecture.domain.usecase.AppUseCase
import com.cm.mvparchitecture.ui.home.contract.HomeContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter
@Inject constructor (
    private val useCase: AppUseCase
): HomeContract.Presenter {

    private var contractView: HomeContract.View? = null

    override fun login(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = useCase.getUserByUsername(username)
            with(Dispatchers.Main) {
                if (user != null && user.password == password) {
                    contractView?.showLoading()
                    contractView?.showSuccess("Logged in successfully.")
                } else {
                    contractView?.hideLoading()
                    contractView?.showError("Your username/password is incorrect")
                }
            }
        }
    }

    override fun attachView(view: HomeContract.View) {
        contractView = view
    }

    override fun detachView() {
        contractView = null
    }

    override fun onAttached() = Unit
    override fun onDetached() = Unit
    override fun onDestroy() = Unit
}