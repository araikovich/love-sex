package araikovich.inc.percent_views.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import araikovich.inc.percent_views.R
import araikovich.inc.percent_views.model.PercentSizeManager
import araikovich.inc.percent_views.storage.PSizeStorageImpl

class PImageView : AppCompatImageView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initSizes(attrs)
    }

    private val sizeManager get() = PSizeStorageImpl(context).run { PercentSizeManager(screenParams) }

    private var percentMarginTop = 0
    private var percentMarginBottom = 0
    private var percentMarginStart = 0
    private var percentMarginEnd = 0
    private var percentHeight = 0
    private var percentWidth = 0

    private fun initSizes(attrs: AttributeSet?) {
        if (isInEditMode) return
        attrs?.also {
            if (isInEditMode) return
            val ta = context.obtainStyledAttributes(attrs, R.styleable.PImageView)

            percentMarginStart =
                sizeManager.width(ta.getFloat(R.styleable.PImageView_p_marginStart, 0f))
            percentMarginEnd =
                sizeManager.width(ta.getFloat(R.styleable.PImageView_p_marginEnd, 0f))

            percentWidth = sizeManager.width(
                ta.getFloat(R.styleable.PImageView_p_width, 0f),
                ta.getFloat(R.styleable.PImageView_p_widthLong, 0f)
            )

            percentHeight = sizeManager.height(
                ta.getFloat(R.styleable.PImageView_p_height, 0f),
                ta.getFloat(R.styleable.PImageView_p_heightLong, 0f)
            )

            percentMarginTop = sizeManager.height(
                ta.getFloat(R.styleable.PImageView_p_marginTop, 0f),
                ta.getFloat(R.styleable.PImageView_p_marginTopLong, 0f)
            )

            percentMarginBottom = sizeManager.height(
                ta.getFloat(R.styleable.PImageView_p_marginBottom, 0f),
                ta.getFloat(R.styleable.PImageView_p_marginBottomLong, 0f)
            )

            ta.recycle()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isInEditMode) return
        (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
            if (percentHeight != 0) height = percentHeight
            if (width != ViewGroup.LayoutParams.MATCH_PARENT) if (percentWidth != 0) width =
                percentWidth
            setMargins(
                if (percentMarginStart != 0) percentMarginStart else marginStart,
                if (percentMarginTop != 0) percentMarginTop else marginTop,
                if (percentMarginEnd != 0) percentMarginEnd else marginEnd,
                if (percentMarginBottom != 0) percentMarginBottom else marginBottom
            )
        }

        requestLayout()
    }

    fun setPHeight(dpHeight: Float, longDpHeight: Float) {
        percentHeight = sizeManager.height(
            dpHeight,
            longDpHeight
        )
        (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
            if (percentHeight != 0) height = percentHeight
        }
        requestLayout()
    }
}