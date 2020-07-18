package araikovich.inc.lovesex.ui.splash_screen

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.ui.MainActivity
import araikovich.inc.lovesex.ui.utils.color

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusBarAndNavigationColor()
        setContentView(R.layout.activity_splash_screen)
        MainActivity.start(this)
    }

    private fun setupStatusBarAndNavigationColor() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color(R.color.premium_gradient_start_color)
    }
}