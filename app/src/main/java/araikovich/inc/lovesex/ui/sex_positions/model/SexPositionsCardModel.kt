package araikovich.inc.lovesex.ui.sex_positions.model

data class SexPositionsCardModel(
    val itemId: Int,
    val imageSrc: Int,
    val title: String,
    val levelTitle: String,
    val isPremium: Boolean,
    val isLocked: Boolean
)