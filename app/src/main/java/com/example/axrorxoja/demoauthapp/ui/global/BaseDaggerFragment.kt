package com.example.axrorxoja.demoauthapp.ui.global

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseDaggerFragment :
    BaseFragment(),
    HasSupportFragmentInjector {

    @Inject lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector() = childFragmentInjector

}
