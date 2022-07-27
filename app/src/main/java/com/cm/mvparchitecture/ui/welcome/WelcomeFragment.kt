package com.cm.mvparchitecture.ui.welcome

import com.cm.mvparchitecture.databinding.FragmentWelcomeBinding
import com.cm.mvparchitecture.ui.base.BaseFragment
import com.cm.mvparchitecture.ui.base.contract.PresenterContract
import com.cm.mvparchitecture.ui.base.contract.ViewContract
import com.cm.mvparchitecture.ui.welcome.contract.WelcomeViewContract
import com.cm.mvparchitecture.utils.Common.goBack

class WelcomeFragment: BaseFragment<FragmentWelcomeBinding, WelcomeViewContract.Presenter>(
    FragmentWelcomeBinding::inflate
) {
    override fun getPresenter(): PresenterContract<ViewContract> {
        TODO("Not yet implemented")
    }
    override fun showLoading() = Unit
    override fun hideLoading() = Unit
    override fun showError(error: String) = Unit
    override fun showSuccess(message: String) = Unit
    override fun close(animated: Boolean) = Unit

    override fun back(animated: Boolean) {
        goBack(requireActivity(), viewLifecycleOwner)
    }
}