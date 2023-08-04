package com.prof18.airalo.countrychooser

import android.app.Activity
import android.content.Intent
import com.prof18.airalo.countrychooser.contract.HomeContract
import com.prof18.airalo.countrychooser.presentation.HomeActivity
import org.koin.core.annotation.Factory

@Factory
class HomeContractImpl : HomeContract {
    override fun getIntent(currentActivity: Activity): Intent =
        Intent(currentActivity, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NO_ANIMATION
        }
}
