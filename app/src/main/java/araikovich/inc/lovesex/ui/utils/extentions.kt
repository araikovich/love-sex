package araikovich.inc.lovesex.ui.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.os.Parcelable
import android.util.Size
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import araikovich.inc.lovesex.App
import upgames.pokerup.android.presentation.fragment.FragmentArgumentDelegate
import upgames.pokerup.android.presentation.fragment.FragmentNullableArgumentDelegate
import java.io.Serializable
import kotlin.properties.ReadWriteProperty

fun Context.color(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)

fun Int.dpToPx(): Int = (this * App.instance.resources.displayMetrics.density).toInt()

fun View.setOnClickWithTouchImpact(withDebounced: Boolean = true, clickAction: () -> Unit) {
    this.setOnTouchListener(object : ScaleClickListener(withDebounced = withDebounced) {
        override fun onClick(p0: View?) {
            clickAction.invoke()
        }
    })
}

fun Int?.orZero() = this ?: 0

fun Activity.screenSize(): Size {
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return Size(size.x, size.y)
}

fun Context.drawable(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(this, resId)

fun AppCompatImageView.changeImageWithTransition(
    @DrawableRes drawableId: Int
) {
    val oldDrawable: Drawable? = this.drawable
    val oldBitmapDrawable = if (oldDrawable is TransitionDrawable) {
        oldDrawable.findDrawableByLayerId(-1) ?: oldDrawable
    } else {
        oldDrawable
    }
    if (oldBitmapDrawable != null) {
        val transitionDrawable =
            TransitionDrawable(arrayOf(oldBitmapDrawable, this.context.drawable(drawableId)))
        transitionDrawable.isCrossFadeEnabled = true
        this.setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(500)
    } else {
        this.setImageResource(drawableId)
    }
}

fun View.changeBackgroundDrawable(
    drawable: Drawable?,
    duration: Int = 500,
    isCrossFadeEnabled: Boolean = false
) {
    val oldDrawable = this.background
    val oldBitmapDrawable = if (oldDrawable is TransitionDrawable) {
        oldDrawable.findDrawableByLayerId(-1) ?: oldDrawable
    } else {
        oldDrawable
    }
    val transitionDrawable = TransitionDrawable(arrayOf(oldBitmapDrawable, drawable))
    transitionDrawable.isCrossFadeEnabled = isCrossFadeEnabled
    this.background = transitionDrawable
    transitionDrawable.startTransition(duration)
}

fun View.scale(scale: Float) {
    scaleX = scale
    scaleY = scale
}

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

fun <T> Bundle.put(key: String, value: T) {
    when (value) {
        is Boolean -> putBoolean(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Short -> putShort(key, value)
        is Long -> putLong(key, value)
        is Byte -> putByte(key, value)
        is ByteArray -> putByteArray(key, value)
        is Char -> putChar(key, value)
        is CharArray -> putCharArray(key, value)
        is CharSequence -> putCharSequence(key, value)
        is Float -> putFloat(key, value)
        is Bundle -> putBundle(key, value)
        is Parcelable -> putParcelable(key, value)
        is Serializable -> putSerializable(key, value)
        else -> throw IllegalStateException("Type of property $key is not supported")
    }
}

fun <T : Any> argument(): ReadWriteProperty<Fragment, T> =
    FragmentArgumentDelegate()

fun <T : Any> argumentNullable(): ReadWriteProperty<Fragment, T?> =
    FragmentNullableArgumentDelegate()