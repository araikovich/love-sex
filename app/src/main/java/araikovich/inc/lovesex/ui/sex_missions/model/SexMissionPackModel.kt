package araikovich.inc.lovesex.ui.sex_missions.model

data class SexMissionPackModel(
    val packId: Int,
    val packTitleRes: Int,
    val packDescriptionRes: Int,
    val packImageSrc: Int,
    val isForPurchase: Boolean,
    val price: Int
)
