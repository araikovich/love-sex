package araikovich.inc.percent_views.model

import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.databinding.BindingAdapter
import araikovich.inc.percent_views.storage.PSizeStorageImpl

private val View.sizeManager get() = PSizeStorageImpl(context).run {
    PercentSizeManager(screenParams)
}

fun Int.percent(percent: Float): Int = (this * (percent / 100)).toInt()


@BindingAdapter(
    "percent_width",
    "percent_height",
    "percent_heightLong",
    "percent_textSize",
    "percent_textSizeLong",
    "percent_marginTop",
    "percent_marginTopLong",
    "percent_marginBottom",
    "percent_marginBottomLong",
    "percent_marginStart",
    "percent_marginEnd"
)
fun View.setPercentValues(
    percentWidth: Int = 0,
    percentHeight: Int = 0,
    percentHeightLong: Int = 0,
    percentTextSize: Int = 0,
    percentTextSizeLong: Int = 0,
    percentMarginTop: Int = 0,
    percentMarginTopLong: Int = 0,
    percentMarginBottom: Int = 0,
    percentMarginBottomLong: Int = 0,
    percentMarginStart: Int = 0,
    percentMarginEnd: Int = 0
){
    doOnAttach {
        if (!isInEditMode) {
            (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                if (percentHeight != 0) height = percentHeight
                if (percentWidth != 0) width = percentWidth
                setMargins(
                    if (percentMarginStart != 0) percentMarginStart else marginStart,
                    if (percentMarginTop != 0) percentMarginTop else marginTop,
                    if (percentMarginEnd != 0) percentMarginEnd else marginEnd,
                    if (percentMarginBottom != 0) percentMarginBottom else marginBottom
                )
            }
            requestLayout()
        }
    }
}