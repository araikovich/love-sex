package araikovich.inc.lovesex.ui.sex_missions_detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import araikovich.inc.lovesex.ui.sex_missions_detail.SexMissionsDetailListFragment
import araikovich.inc.lovesex.ui.sex_missions_detail.model.SexMissionType

class SexMissionsDetailPagerAdapter(
    private val context: FragmentActivity
) : FragmentStateAdapter(context) {

    private val newbie =
        SexMissionsDetailListFragment.newInstance(
            SexMissionType.NEWBIE
        )
    private val advanced =
        SexMissionsDetailListFragment.newInstance(
            SexMissionType.ADVANCED
        )
    private val extreme =
        SexMissionsDetailListFragment.newInstance(
            SexMissionType.EXTREME
        )

    val items = mutableListOf(newbie, advanced, extreme)

    override fun getItemCount() = items.size

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

    fun getItemType(position: Int): SexMissionType {
        return items[position].type
    }
}