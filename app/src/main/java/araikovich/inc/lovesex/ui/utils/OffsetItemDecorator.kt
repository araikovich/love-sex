package araikovich.inc.lovesex.ui.utils

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class OffsetItemDecoration(private val ctx: Context) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val offset: Int =
            (screenWidth / 2.toFloat()).toInt() - view.layoutParams.width / 2
        if (parent.getChildAdapterPosition(view) == 0) {
            (view.layoutParams as MarginLayoutParams).leftMargin = 0
            setupOutRect(outRect, offset, true)
        } else if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            (view.layoutParams as MarginLayoutParams).rightMargin = 0
            setupOutRect(outRect, offset, false)
        }
    }

    private fun setupOutRect(rect: Rect, offset: Int, start: Boolean) {
        if (start) {
            rect.left = offset
        } else {
            rect.right = offset
        }
    }

    private val screenWidth: Int
        get() {
            val wm = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.x
        }
}