package com.cm.mvparchitecture.ui.home

import android.os.Bundle
import android.view.View
import com.cm.mvparchitecture.databinding.FragmentHomeBinding
import com.cm.mvparchitecture.ui.base.BaseFragment
import com.cm.mvparchitecture.ui.base.contract.PresenterContract
import com.cm.mvparchitecture.ui.base.contract.ViewContract
import com.cm.mvparchitecture.ui.home.contract.HomeContract
import com.cm.mvparchitecture.utils.Common.goBack
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
@AndroidEntryPoint
class HomeFragment
@Inject constructor(): BaseFragment<FragmentHomeBinding, HomeContract.Presenter>(
    FragmentHomeBinding::inflate
), HomeContract.View {

    @Inject lateinit var homePresenter: HomePresenter

    override fun getPresenter(): PresenterContract<ViewContract> =
        homePresenter as PresenterContract<ViewContract>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            homePresenter.login(binding.username.text.toString(), binding.password.text.toString())
        }
    }

    override fun showAnimation() {
        TODO("Not yet implemented")
    }

    override fun hideSoftKeyboard() {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progress.visibility = View.GONE
    }

    override fun showError(error: String) {
        Snackbar.make(binding.root, error, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun showSuccess(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun close(animated: Boolean) {
        TODO("Not yet implemented")
    }

    override fun back(animated: Boolean) {
        goBack(requireActivity(), viewLifecycleOwner)
    }
}