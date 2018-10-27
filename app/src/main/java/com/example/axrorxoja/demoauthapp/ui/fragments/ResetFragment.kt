package com.example.axrorxoja.demoauthapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.extension.changeVisibility
import com.example.axrorxoja.demoauthapp.extension.showSnackbar
import com.example.axrorxoja.demoauthapp.extension.text
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.presentation.reset.IPresenterReset
import com.example.axrorxoja.demoauthapp.presentation.reset.IViewReset
import com.example.axrorxoja.demoauthapp.ui.global.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_reset.*
import javax.inject.Inject

class ResetFragment : BaseDaggerFragment(),
    IViewReset {
    override val layoutRes: Int = R.layout.fragment_reset
    @Inject lateinit var presenter: IPresenterReset
    @Inject lateinit var activityView: IViewActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_reset.setOnClickListener { presenter.reset(ti_pass.text(), ti_pass_again.text()) }
    }

    override fun onSuccess() = activityView.exitToRoot()

    override fun onFail(stringRes: Int) = parent.showSnackbar(stringRes, Snackbar.LENGTH_SHORT)

    override fun onShowProgress(isShow: Boolean) = pb.changeVisibility(isHidden)

    override fun lifeCycle(): LifecycleOwner = this
}
