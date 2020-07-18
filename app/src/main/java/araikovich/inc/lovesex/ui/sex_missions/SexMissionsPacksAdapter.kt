package araikovich.inc.lovesex.ui.sex_missions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ViewHolderSexMissionsPackBinding
import araikovich.inc.lovesex.ui.sex_missions.model.SexMissionPackModel
import araikovich.inc.lovesex.ui.utils.setOnClickWithTouchImpact

class SexMissionsPacksAdapter(
    private val context: Context,
    private val onItemClick: (SexMissionPackModel) -> Unit
) :
    RecyclerView.Adapter<SexMissionPackViewHolder>() {

    val items: MutableList<SexMissionPackModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SexMissionPackViewHolder {
        return SexMissionPackViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.view_holder_sex_missions_pack, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SexMissionPackViewHolder, position: Int) {
        holder.bindView(items[position])
        holder.onItemClick = onItemClick
    }
}

class SexMissionPackViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var onItemClick: ((SexMissionPackModel) -> Unit)? = null

    private val binding = DataBindingUtil.bind<ViewHolderSexMissionsPackBinding>(view)!!

    fun bindView(model: SexMissionPackModel) {
        binding.parentContainer.setBackgroundResource(
            if (model.isForPurchase) {
                R.drawable.item_premium_background
            } else {
                R.drawable.item_default_background
            }
        )
        binding.ivPackImage.setImageResource(model.packImageSrc)
        binding.tvPackTitle.setText(model.packTitleRes)
        binding.tvDescription.setText(model.packDescriptionRes)
        binding.parentContainer.setOnClickWithTouchImpact {
            onItemClick?.invoke(model)
        }
    }
}