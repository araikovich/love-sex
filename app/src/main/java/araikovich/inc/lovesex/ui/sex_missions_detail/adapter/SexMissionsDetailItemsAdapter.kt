package araikovich.inc.lovesex.ui.sex_missions_detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ViewHolderMissionItemBinding
import araikovich.inc.lovesex.ui.sex_missions_detail.model.SexMissionModel

class SexMissionsDetailItemsAdapter(val context: Context, onItemClick: (SexMissionModel) -> Unit) :
    RecyclerView.Adapter<SexMissionItemViewHolder>() {

    val items = mutableListOf<SexMissionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SexMissionItemViewHolder {
        return SexMissionItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.view_holder_mission_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SexMissionItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class SexMissionItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DataBindingUtil.bind<ViewHolderMissionItemBinding>(view)!!

    fun bind(item: SexMissionModel) {
        binding.tvTitle.text = item.itemTitle
    }
}