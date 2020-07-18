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
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.FragmentHomeBinding
import araikovich.inc.lovesex.ui.sex_positions.dialog.PurchaseSexPositionsPackDialog
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel
import araikovich.inc.lovesex.ui.utils.HorizontalItemsMarginItemDecorator
import araikovich.inc.lovesex.ui.utils.dpToPx
import araikovich.inc.lovesex.ui.utils.screenSize
import araikovich.inc.lovesex.ui.utils.setOnClickWithTouchImpact
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class SexPositionsFragment : Fragment() {

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
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvItems.adapter = sexPositionsCardsAdapter
        binding.rvItems.addItemDecoration(
            HorizontalItemsMarginItemDecorator(
                18.dpToPx()
            )
        )
        PagerSnapHelper().attachToRecyclerView(binding.rvItems)
    }

    private fun updateAdapter(items: List<SexPositionsCardModel>) {
        sexPositionsCardsAdapter?.apply {
            itemsList.clear()
            itemsList.addAll(items)
            notifyDataSetChanged()
        }
    }

    private fun setupListeners() {
        binding.btnStart.setOnClickWithTouchImpact {
            binding.rvItems.smoothScrollBy(
                requireActivity().screenSize().width * 20 + 67.dpToPx(),
                0,
                DecelerateInterpolator(),
                2000
            )
        }
        binding.ivFullPack.setOnClickWithTouchImpact {
            val dialog = PurchaseSexPositionsPackDialog()
            childFragmentManager.beginTransaction().add(dialog, "TAG").commitAllowingStateLoss()
        }
    }
}