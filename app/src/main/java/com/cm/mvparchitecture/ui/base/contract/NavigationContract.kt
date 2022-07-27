package com.cm.mvparchitecture.ui.base.contract

interface NavigationContract {
    fun close(animated: Boolean = true)
    fun back(animated: Boolean = true)
}