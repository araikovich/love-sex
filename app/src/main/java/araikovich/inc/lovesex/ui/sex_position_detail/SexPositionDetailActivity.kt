package araikovich.inc.lovesex.ui.sex_position_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ActivitySexMissionsDetailBinding
import araikovich.inc.lovesex.databinding.ActivitySexPositionDetailBinding
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel
import araikovich.inc.lovesex.ui.utils.color
import araikovich.inc.lovesex.ui.utils.put

class SexPositionDetailActivity : AppCompatActivity() {

    companion object {

        const val SEX_POSITION_ITEM_KEY = "SEX_POSITION_ITEM_KEY"

        fun start(context: Context, positionModel: SexPositionsCardModel) {
            val intent = Intent(context, SexPositionDetailActivity::class.java)
            intent.putExtra(SEX_POSITION_ITEM_KEY, positionModel)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySexPositionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusBarAndNavigationColor()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sex_position_detail)
        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        val model = intent.getParcelableExtra<SexPositionsCardModel>(SEX_POSITION_ITEM_KEY)
        model?.also {
            binding.ivPosition.setImageResource(model.imageSrc)
            binding.tvPosTitle.setText(model.titleRes)
            binding.tvTextDescription.setText(model.descriptionRes)
            binding.tvNotification.setText(model.notificationMessageRes)
        }
        intent.removeExtra(SEX_POSITION_ITEM_KEY)
    }

    private fun setupStatusBarAndNavigationColor() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color(R.color.main_top_color)
        window.navigationBarColor =
            color(R.color.main_bottom_color)
    }

    private fun setupListeners() {
        binding.btnStart.setOnClickListener {
            finish()
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}