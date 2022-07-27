package com.cm.mvparchitecture.utils

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object Common {

    fun goBack(
        fragmentActivity: FragmentActivity,
        lifecycleOwner: LifecycleOwner
    ) {
        fragmentActivity.onBackPressedDispatcher.addCallback(lifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    MaterialAlertDialogBuilder(fragmentActivity)
                        .setTitle("Exit?")
                        .setMessage("Are you sure you want to exit?")
                        .setNegativeButton("No") { _, _ -> }
                        .setPositiveButton("Yes") { _, _ -> fragmentActivity.finish() }
                        .show()
                }
            })
    }
}