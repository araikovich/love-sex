package araikovich.inc.lovesex.ui.sex_missions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import araikovich.inc.bekind.ui.base.BaseViewModel
import araikovich.inc.bekind.ui.livedata.ActionResource
import araikovich.inc.bekind.ui.livedata.setSuccess
import araikovich.inc.lovesex.domain.sex_missions.GetSexMissionsUseCase
import araikovich.inc.lovesex.ui.sex_missions.model.SexMissionPackModel
import kotlinx.coroutines.launch

class SexMissionsPacksViewModel(
    private val getSexMissionsUseCase: GetSexMissionsUseCase
) : BaseViewModel() {

    val sexMissionsPacks = MutableLiveData<ActionResource<List<SexMissionPackModel>>>()

    fun getSexMissionsPacks() {
        viewModelScope.launch(backgroundScope) {
            getSexMissionsUseCase.execute().also {
                sexMissionsPacks.setSuccess(it)
            }
        }
    }
}