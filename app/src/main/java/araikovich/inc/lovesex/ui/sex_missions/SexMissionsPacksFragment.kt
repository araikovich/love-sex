package araikovich.inc.lovesex.ui.sex_missions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.FragmentSexMissionsPacksBinding
import araikovich.inc.lovesex.ui.sex_missions.model.SexMissionPackModel
import araikovich.inc.lovesex.ui.sex_missions_detail.SexMissionsDetailActivity
import araikovich.inc.lovesex.ui.utils.VerticalItemsMarginDecorator
import araikovich.inc.lovesex.ui.utils.dpToPx
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class SexMissionsPacksFragment : Fragment() {

    private lateinit var binding: FragmentSexMissionsPacksBinding

    private val sexMissionsPacksViewModel: SexMissionsPacksViewModel by viewModel()
    private var adapter: SexMissionsPacksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sex_missions_packs, container, false)
        binding = DataBindingUtil.bind(root)!!
        observeMissionPacks()
        setupAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sexMissionsPacksViewModel.getSexMissionsPacks()
    }

    private fun setupAdapter() {
        context?.also {
            adapter = SexMissionsPacksAdapter(it) {
                activity?.also { activity ->
                    SexMissionsDetailActivity.start(activity)
                }
            }
            binding.rvMissionsPacks.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvMissionsPacks.adapter = adapter
            binding.rvMissionsPacks.addItemDecoration(VerticalItemsMarginDecorator(33.dpToPx()))
        }
    }

    private fun observeMissionPacks() {
        sexMissionsPacksViewModel.sexMissionsPacks.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                ActionState.SUCCESS -> {
                    provideMissionsPacks(it.data.orEmpty())
                }
            }
        })
    }

    private fun provideMissionsPacks(items: List<SexMissionPackModel>) {
        adapter?.apply {
            this.items.clear()
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }
}