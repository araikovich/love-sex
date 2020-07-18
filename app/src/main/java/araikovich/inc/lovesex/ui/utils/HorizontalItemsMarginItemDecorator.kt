package araikovich.inc.lovesex.ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalItemsMarginItemDecorator(private val rightPadding: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0, 0, rightPadding, 0)
    }
}