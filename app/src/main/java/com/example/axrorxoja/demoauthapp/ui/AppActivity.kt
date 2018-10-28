package com.example.axrorxoja.demoauthapp.ui

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.extension.transAction
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.ui.fragments.*
import com.example.axrorxoja.demoauthapp.ui.global.BaseFragment
import dagger.android.support.DaggerAppCompatActivity

class AppActivity :
    DaggerAppCompatActivity(),
    IViewActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        if (savedInstanceState == null) onSignIn()
    }

    override fun onSignIn() = supportFragmentManager.transAction({ add(this, SignInFragment()) })

    override fun onMain() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.transAction({ add(this, MainFragment()) })
    }

    override fun onSignUp() = supportFragmentManager.transAction({ add(this, SignUpFragment()) })

    override fun onReset() = supportFragmentManager.transAction({ add(this, ResetFragment()) })

    override fun onForgot() = supportFragmentManager.transAction({ add(this, ForgotFragment()) })

    override fun exitToRoot() {
        val entryCount = supportFragmentManager.backStackEntryCount
        if (entryCount > 1) {
            val entry = supportFragmentManager.getBackStackEntryAt(1)
            supportFragmentManager.popBackStack(entry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }

    override fun exit() = supportFragmentManager.popBackStack()

    private fun add(ft: FragmentTransaction, fr: BaseFragment) {
        ft.add(R.id.container, fr, fr.fragmentTag)
            .addToBackStack(fr.fragmentTag)
    }


    private fun replace(ft: FragmentTransaction, fr: BaseFragment) =
        ft.replace(R.id.container, fr, fr.fragmentTag)
            .addToBackStack(fr.fragmentTag)

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

}
