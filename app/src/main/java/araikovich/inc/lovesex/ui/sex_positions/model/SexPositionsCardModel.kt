package araikovich.inc.lovesex.ui.sex_positions.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SexPositionsCardModel(
    val itemId: Int,
    val imageSrc: Int,
    val titleRes: Int,
    val notificationMessageRes: Int,
    val descriptionRes: Int,
    val levelTitleRes: Int,
    val isPremium: Boolean,
    val isLocked: Boolean
) : Parcelable