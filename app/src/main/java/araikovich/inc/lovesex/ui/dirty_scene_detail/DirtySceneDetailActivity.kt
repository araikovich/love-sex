package araikovich.inc.lovesex.ui.dirty_scene_detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ActivityDirtySceneDetailBinding
import araikovich.inc.lovesex.ui.utils.color
import araikovich.inc.lovesex.ui.utils.orFalse
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class DirtySceneDetailActivity : AppCompatActivity() {

    companion object {

        private const val DIRTY_SCENE_ID = "DIRTY_SCENE_ID"

        fun start(activity: Activity, sceneId: Int) {
            val intent = Intent(activity, DirtySceneDetailActivity::class.java)
            intent.putExtra(DIRTY_SCENE_ID, sceneId)
            activity.startActivity(intent)
        }
    }

    private val dirtyScenesDetailViewModel: DirtySceneDetailViewModel by viewModel()

    private lateinit var binding: ActivityDirtySceneDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dirty_scene_detail)
        observeSceneDetail()
        getDirtyScene()
    }

    private fun observeSceneDetail() {
        dirtyScenesDetailViewModel.dirtySceneModel.observe(this, Observer {
            when (it.state) {
                ActionState.SUCCESS -> {
                    it.data?.also { model -> setupData(model) }
                }
            }
        })
    }

    private fun getDirtyScene() {
        if (intent.extras?.containsKey(DIRTY_SCENE_ID).orFalse()) {
            dirtyScenesDetailViewModel.getDirtyScene(intent.getIntExtra(DIRTY_SCENE_ID, -1))
            intent.removeExtra(DIRTY_SCENE_ID)
        }
    }

    private fun setupData(model: DirtySceneDetailModel) {
        setupColors(model.isPremium)
        binding.ivIcon.setImageResource(model.imageSrc)
        binding.tvTextDescription.setText(model.descriptionSrc)
        binding.tvTitle.setText(model.titleSrc)
    }

    private fun setupColors(isPremium: Boolean) {
        binding.headerContainer.setBackgroundResource(
            if (isPremium) {
                R.color.premium_gradient_start_color
            } else {
                R.color.main_top_color
            }
        )
        binding.scroll.setBackgroundResource(
            if (isPremium) {
                R.drawable.missions_detail_background_premium_gradient
            } else {
                R.drawable.missions_detail_background_default
            }
        )
        window.navigationBarColor = color(
            if (isPremium) {
                R.color.premium_gradient_end_color
            } else {
                R.color.main_bottom_color
            }
        )
        window.statusBarColor = color(
            if (isPremium) {
                R.color.premium_gradient_start_color
            } else {
                R.color.main_top_color
            }
        )
    }
}