package araikovich.inc.lovesex.ui.sex_missions_detail.model

data class SexMissionsPackDetailModel(
    val items: List<SexMissionModel>
)

enum class SexMissionType {
    NEWBIE, ADVANCED, EXTREME
}

