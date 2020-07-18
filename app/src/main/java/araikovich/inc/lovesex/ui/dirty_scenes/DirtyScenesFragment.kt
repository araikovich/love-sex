package araikovich.inc.lovesex.ui.dirty_scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.FragmentDirtyScenesBinding
import araikovich.inc.lovesex.ui.dirty_scene_detail.DirtySceneDetailActivity
import araikovich.inc.lovesex.ui.utils.GridRecyclerItemDecorator
import araikovich.inc.lovesex.ui.utils.dpToPx
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class DirtyScenesFragment : Fragment() {

    private val dirtyScenesViewModel: DirtyScenesViewModel by viewModel()

    private lateinit var binding: FragmentDirtyScenesBinding
    private var adapter: DirtyScenesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dirty_scenes, container, false)
        binding = DataBindingUtil.bind(root)!!
        observeDirtyScenes()
        setupAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dirtyScenesViewModel.getDirtyScenes()
    }

    private fun observeDirtyScenes() {
        dirtyScenesViewModel.dirtyScenes.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                ActionState.SUCCESS -> {
                    provideItems(it.data.orEmpty())
                }
            }
        })
    }

    private fun setupAdapter() {
        context?.also {
            adapter = DirtyScenesAdapter(it) { model ->
                DirtySceneDetailActivity.start(requireActivity(), model.id)
            }
            binding.rvDirtyScenes.layoutManager =
                GridLayoutManager(it, 2, GridLayoutManager.VERTICAL, false)
            binding.rvDirtyScenes.addItemDecoration(
                GridRecyclerItemDecorator(
                    20.dpToPx(),
                    20.dpToPx()
                )
            )
            binding.rvDirtyScenes.itemAnimator = null
            binding.rvDirtyScenes.adapter = adapter
        }
    }

    private fun provideItems(items: List<DirtySceneItemModel>) {
        adapter?.items?.clear()
        adapter?.items?.addAll(items)
        adapter?.notifyDataSetChanged()
    }
}