package araikovich.inc.lovesex.domain.sex_missions

import araikovich.inc.lovesex.ui.sex_missions.model.SexMissionPackModel
import araikovich.inc.lovesex.data.provider.SexMissionsPacksProvider

class GetSexMissionsUseCase(
    private val sexMissionsPackProvider: SexMissionsPacksProvider
) {

    suspend fun execute(): List<SexMissionPackModel>{
        return sexMissionsPackProvider.getSexMissionsPacks()
    }
}