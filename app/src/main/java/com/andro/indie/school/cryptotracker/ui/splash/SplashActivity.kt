package com.andro.indie.school.cryptotracker.ui.splash

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import com.andro.indie.school.cryptotracker.CryptoTrackerApp
import com.andro.indie.school.cryptotracker.R
import com.andro.indie.school.cryptotracker.base.BaseActivity
import com.andro.indie.school.cryptotracker.extensions.showSnackbar
import com.andro.indie.school.cryptotracker.network.NetworkUtils
import com.andro.indie.school.cryptotracker.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.act
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var networkUtils: NetworkUtils

    private val splashPresenter by lazy { SplashPresenter(this, networkUtils) }

    override fun initInjection() {
        (application as CryptoTrackerApp).cryptoDeps.inject(this)
    }

    override fun setUpLayout() {
        setContentView(R.layout.activity_splash)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        splashPresenter.checkRequirement()
    }

    override fun navigateToHome() {
        Handler().postDelayed({
            startActivity<HomeActivity>()
            this@SplashActivity.finish()
        }, 3000)
    }

    override fun showInternetError() {
        rootSplash.showSnackbar(R.string.error_no_internet, timeLength = Snackbar.LENGTH_INDEFINITE) {
            this.setAction(resources.getString(R.string.text_check)) {
                this.dismiss()
                act.recreate()
            }
        }
    }

    private fun loadVersionNumber(): String =
            try {
                val info = packageManager.getPackageInfo(packageName, 0)
                "v." + info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }

    override fun onResume() {
        super.onResume()
        tvVersion?.text = loadVersionNumber()
    }
}
