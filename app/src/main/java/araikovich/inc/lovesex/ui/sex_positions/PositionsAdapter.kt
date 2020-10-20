package araikovich.inc.lovesex.ui.sex_positions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ViewHolderPositionCardBinding
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel

class PositionsAdapter(private val context: Context) : RecyclerView.Adapter<PositionViewHolder>() {

    val itemsList: MutableList<SexPositionsCardModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.view_holder_position_card, parent, false)
        )
    }

    override fun getItemCount() = itemsList.size

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.bindView(itemsList[position])
    }

    fun updateItems(newList: List<SexPositionsCardModel>) {
        val lastItem = itemsList.lastIndex
        itemsList.addAll(newList)
        notifyItemRangeInserted(lastItem, itemsList.size)
    }
}

class PositionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DataBindingUtil.bind<ViewHolderPositionCardBinding>(view)!!

    fun bindView(model: SexPositionsCardModel) {
        binding.parentContainer.setBackgroundResource(
            if (model.isLocked) {
                R.drawable.item_premium_background
            } else {
                R.drawable.item_default_background
            }
        )
        binding.ivPosition.setImageResource(
            if (model.isLocked) {
                R.drawable.ic_sex_card_locked
            } else {
                model.imageSrc
            }
        )
        if (!model.isLocked) {
            binding.tvTitle.text = model.title
            binding.tvLevel.text = model.levelTitle
        }
    }
}