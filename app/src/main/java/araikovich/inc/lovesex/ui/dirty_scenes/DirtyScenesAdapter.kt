package araikovich.inc.lovesex.ui.dirty_scenes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.ViewHolderDirtySceneItemBinding
import araikovich.inc.lovesex.ui.utils.setOnClickWithTouchImpact

class DirtyScenesAdapter(val context: Context, private val onItemClick: (DirtySceneItemModel) -> Unit) :
    RecyclerView.Adapter<DirtySceneViewHolder>() {

    val items = mutableListOf<DirtySceneItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirtySceneViewHolder {
        return DirtySceneViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.view_holder_dirty_scene_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DirtySceneViewHolder, position: Int) {
        holder.bindView(items[position], onItemClick)
    }
}

class DirtySceneViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DataBindingUtil.bind<ViewHolderDirtySceneItemBinding>(view)!!

    fun bindView(item: DirtySceneItemModel, onItemClick: (DirtySceneItemModel) -> Unit) {
        binding.parentContainer.setBackgroundResource(
            if (item.isPremium) {
                R.drawable.item_premium_background
            } else {
                R.drawable.item_default_background
            }
        )
        binding.ivIcon.setImageResource(item.imageSrc)
        binding.tvTitle.setText(item.titleRes)
        binding.parentContainer.setOnClickWithTouchImpact {
            onItemClick.invoke(item)
        }
    }
}