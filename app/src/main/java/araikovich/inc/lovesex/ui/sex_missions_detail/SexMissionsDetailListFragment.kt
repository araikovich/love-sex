package araikovich.inc.lovesex.ui.sex_missions_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.FragmentSexMissionsDetailListBinding
import araikovich.inc.lovesex.ui.sex_missions_detail.adapter.SexMissionsDetailItemsAdapter
import araikovich.inc.lovesex.ui.sex_missions_detail.model.SexMissionModel
import araikovich.inc.lovesex.ui.sex_missions_detail.model.SexMissionType
import araikovich.inc.lovesex.ui.utils.VerticalItemsMarginDecorator
import araikovich.inc.lovesex.ui.utils.argument
import araikovich.inc.lovesex.ui.utils.dpToPx

class SexMissionsDetailListFragment : Fragment() {

    companion object {

        fun newInstance(type: SexMissionType): SexMissionsDetailListFragment {
            return SexMissionsDetailListFragment().apply {
                this.type = type
            }
        }
    }

    var type by argument<SexMissionType>()

    private lateinit var binding: FragmentSexMissionsDetailListBinding

    private var adapter: SexMissionsDetailItemsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sex_missions_detail_list, container, false)
        binding = DataBindingUtil.bind(view)!!
        initAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fakeItemsProvide()
    }

    private fun initAdapter() {
        context?.also {
            adapter =
                SexMissionsDetailItemsAdapter(
                    it
                ) {}
            binding.rvItems.layoutManager =
                LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
            binding.rvItems.adapter = adapter
            binding.rvItems.itemAnimator = null
            binding.rvItems.addItemDecoration(VerticalItemsMarginDecorator(13.dpToPx()))
        }
    }

    private fun fakeItemsProvide() {
        val items = mutableListOf(
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            ),
            SexMissionModel(
                0,
                "Секс в раздевалке",
                false
            )
        )
        adapter?.items?.clear()
        adapter?.items?.addAll(items)
        adapter?.notifyDataSetChanged()
    }
}