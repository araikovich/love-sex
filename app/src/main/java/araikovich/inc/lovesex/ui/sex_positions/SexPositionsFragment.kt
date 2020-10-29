package araikovich.inc.lovesex.ui.sex_positions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.FragmentHomeBinding
import araikovich.inc.lovesex.ui.sex_position_detail.SexPositionDetailActivity
import araikovich.inc.lovesex.ui.sex_positions.dialog.AdsSexPositionDialog
import araikovich.inc.lovesex.ui.sex_positions.dialog.PurchaseSexPositionsPackDialog
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel
import araikovich.inc.lovesex.ui.utils.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class SexPositionsFragment : Fragment() {

    companion object {

        private const val PURCHASE_SEX_POSItiONS_DIALOG_TAG = "PURCHASE_SEX_POSItiONS_DIALOG_TAG"
        private const val ADS_SEX_POSITIONS_TAG = "ADS_SEX_POSITIONS_TAG"
    }

    private lateinit var binding: FragmentHomeBinding

    private val sexPositionsViewModel: SexPositionsViewModel by viewModel()

    private var sexPositionsCardsAdapter: PositionsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.bind(root)!!
        setupAdapter()
        observeSexPositions()
        setupListeners()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sexPositionsViewModel.getSexPositions()
        binding.root.postDelayed({
            showPurchaseDialog()
        }, 500)
    }

    private fun observeSexPositions() {
        sexPositionsViewModel.sexPositionsLiveData.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                ActionState.SUCCESS -> updateAdapter(it.data.orEmpty())
            }
        })
    }

    private fun setupAdapter() {
        context?.also {
            sexPositionsCardsAdapter = PositionsAdapter(it)
        }
        binding.rvItems.itemAnimator = null
        binding.rvItems.layoutManager =
            CenterZoomLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvItems.addItemDecoration(OffsetItemDecoration(requireContext()))
        binding.rvItems.adapter = sexPositionsCardsAdapter
        PagerSnapHelper().attachToRecyclerView(binding.rvItems)
        binding.rvItems.setItemViewCacheSize(20)
        binding.rvItems.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                loopUnlimitedRecyclerView()
            }
        })
    }

    private fun loopUnlimitedRecyclerView() {
        val currentItemPosition =
            (binding.rvItems.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        if (currentItemPosition == sexPositionsCardsAdapter?.itemsList?.size.orZero() - 10) {
            sexPositionsCardsAdapter?.itemsList?.addAll(sexPositionsCardsAdapter?.itemsList.orEmpty())
            sexPositionsCardsAdapter?.notifyDataSetChanged()
        }
    }

    private fun updateAdapter(items: List<SexPositionsCardModel>) {
        sexPositionsCardsAdapter?.updateItems(items)
    }

    private fun addItemsIfNeed(nextItemPosition: Int) {
        if (sexPositionsCardsAdapter?.itemsList?.size.orZero() < nextItemPosition + 2) {
            sexPositionsCardsAdapter?.updateItems(sexPositionsCardsAdapter?.itemsList.orEmpty())
        }
    }

    private fun setupListeners() {
        binding.btnStart.setOnClickWithTouchImpact {
            onStartClick()
        }
        binding.ivFullPack.setOnClickWithTouchImpact {
            showPurchaseDialog()
        }
    }

    private fun onStartClick() {
        if (sexPositionsCardsAdapter?.itemsList?.lastIndex.orZero() >= (binding.rvItems.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()) {
            val currentPos =
                sexPositionsCardsAdapter?.itemsList?.get((binding.rvItems.layoutManager as LinearLayoutManager).findLastVisibleItemPosition() - 1)
            currentPos?.also { pos ->
                if (pos.isLocked) {
                    showPurchaseDialog()
                } else {
                    SexPositionDetailActivity.start(requireActivity(), pos)
                }
            }
        }
    }

    private fun showPurchaseDialog() {
        val dialog = PurchaseSexPositionsPackDialog()
        dialog.onCloseCallback = {
            binding.root.postDelayed({ showAdsDialog() }, 500)
        }
        childFragmentManager.beginTransaction().add(dialog, PURCHASE_SEX_POSItiONS_DIALOG_TAG)
            .commitAllowingStateLoss()
    }

    private fun showAdsDialog() {
        val dialog = AdsSexPositionDialog()
        dialog.onCloseCallback = {}
        childFragmentManager.beginTransaction().add(dialog, ADS_SEX_POSITIONS_TAG)
            .commitAllowingStateLoss()
    }
}