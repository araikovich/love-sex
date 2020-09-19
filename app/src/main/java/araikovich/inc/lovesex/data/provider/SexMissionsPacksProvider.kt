package araikovich.inc.lovesex.data.provider

import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.ui.sex_missions.model.SexMissionPackModel

class SexMissionsPacksProvider {

    suspend fun getSexMissionsPacks() = mutableListOf(
        SexMissionPackModel(
            0,
            R.string.sex_mission_pack_newbie_title,
            R.string.sex_mission_pack_newbie_description,
            R.drawable.sex_missions_newbie_logo,
            false,
            0
        ),
        SexMissionPackModel(
            0,
            R.string.sex_mission_pack_advanced_title,
            R.string.sex_mission_pack_advanced_description,
            R.drawable.sex_missions_experiance_logo,
            true,
            0
        ),
        SexMissionPackModel(
            0,
            R.string.sex_mission_pack_extreme_title,
            R.string.sex_mission_pack_extreme_description,
            R.drawable.sex_missions_extreme_logo,
            true,
            0
        )
    )
}