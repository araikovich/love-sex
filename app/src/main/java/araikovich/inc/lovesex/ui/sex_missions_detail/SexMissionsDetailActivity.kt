package araikovich.inc.lovesex.ui.sex_missions_detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ActivitySexMissionsDetailBinding
import araikovich.inc.lovesex.ui.sex_missions_detail.adapter.SexMissionsDetailPagerAdapter
import araikovich.inc.lovesex.ui.sex_missions_detail.model.SexMissionType
import araikovich.inc.lovesex.ui.utils.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

class SexMissionsDetailActivity : FragmentActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, SexMissionsDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySexMissionsDetailBinding
    private var adapter: SexMissionsDetailPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_sex_missions_detail
        )
        initAdapter()
        setupTabViews()
        setupListeners()
        changeColorsAndIcons(SexMissionType.NEWBIE, false)
    }

    private fun initAdapter() {
        adapter =
            SexMissionsDetailPagerAdapter(
                this
            )
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.sex_missions_tab_newbie_title)
                1 -> getString(R.string.sex_missions_tab_advanced_title)
                else -> getString(R.string.sex_missions_tab_extreme_title)
            }
        }.attach()

        binding.appbar.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                binding.viewBackground.isSelected = binding.appbar.canScrollVertically(-1)
                val index =
                    1f - Math.abs(verticalOffset.toFloat()).div(appBarLayout.totalScrollRange.toFloat()) * 1.6f
                val changeValue = if (index < 0) 0f else index

                binding.ivPackImage.alpha = changeValue * 2
                if (binding.ivPackImage.scaleX > 0.4f && changeValue > 0.4f) {
                    binding.ivPackImage.scale(changeValue)
                }
            }
        )
    }

    private fun setupTabViews() {
        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapter?.also {
                    changeColorsAndIcons(it.getItemType(position))
                }
            }
        })
    }

    private fun changeColorsAndIcons(type: SexMissionType, withAnimation: Boolean = true) {
        fun changeMainImage(type: SexMissionType) {
            binding.ivPackImage.changeImageWithTransition(
                when (type) {
                    SexMissionType.NEWBIE -> R.drawable.sex_missions_newbie_logo
                    SexMissionType.ADVANCED -> R.drawable.sex_missions_experiance_logo
                    SexMissionType.EXTREME -> R.drawable.sex_missions_extreme_logo
                }
            )
        }

        fun changeHeaderColor(type: SexMissionType) {
            val res = when (type) {
                SexMissionType.NEWBIE -> R.color.main_top_color
                SexMissionType.ADVANCED -> R.color.premium_gradient_start_color
                SexMissionType.EXTREME -> R.color.premium_gradient_start_color
            }
            if (withAnimation) {
                binding.toolbar.changeBackgroundDrawable(drawable(res), 300)
            } else {
                binding.toolbar.setBackgroundResource(res)
            }
        }

        fun changeBackground(type: SexMissionType, withAnimation: Boolean = true) {
            val res = when (type) {
                SexMissionType.NEWBIE -> R.drawable.missions_detail_background_default
                SexMissionType.ADVANCED -> R.drawable.missions_detail_background_premium_gradient
                SexMissionType.EXTREME -> R.drawable.missions_detail_background_premium_gradient
            }
            if (withAnimation) {
                binding.viewBackground.changeBackgroundDrawable(drawable(res), 300)
            } else {
                binding.viewBackground.setBackgroundResource(res)
            }
        }

        fun changeNavigationColor(type: SexMissionType) {
            val res = when (type) {
                SexMissionType.NEWBIE -> R.color.main_bottom_color
                SexMissionType.ADVANCED -> R.color.premium_gradient_end_color
                SexMissionType.EXTREME -> R.color.premium_gradient_end_color
            }
            window.navigationBarColor = color(res)
        }

        fun changeStatusBarColor(type: SexMissionType) {
            val res = when (type) {
                SexMissionType.NEWBIE -> R.color.main_top_color
                SexMissionType.ADVANCED -> R.color.premium_gradient_start_color
                SexMissionType.EXTREME -> R.color.premium_gradient_start_color
            }
            window.statusBarColor = color(res)
        }

        changeHeaderColor(type)
        changeMainImage(type)
        changeStatusBarColor(type)
        changeBackground(type, withAnimation)
        changeNavigationColor(type)
    }

    private fun setupListeners(){
        binding.ivBack.setOnClickWithTouchImpact {
            finish()
        }
    }
}