package araikovich.inc.lovesex.ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridRecyclerItemDecorator(
    private val marginBetweenItems: Int,
    private val marginTopBottom: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        if (position % 2 == 0) {
            outRect.set(0, 0, marginBetweenItems / 2, marginTopBottom)
        } else {
            outRect.set(marginBetweenItems / 2, 0, 0, marginTopBottom)
        }
    }
}