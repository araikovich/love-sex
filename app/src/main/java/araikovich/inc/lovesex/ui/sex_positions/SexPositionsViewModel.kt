package araikovich.inc.lovesex.ui.sex_positions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import araikovich.inc.bekind.ui.base.BaseViewModel
import araikovich.inc.bekind.ui.livedata.ActionResource
import araikovich.inc.bekind.ui.livedata.setSuccess
import araikovich.inc.lovesex.domain.sex_positions.GetSexPositionCardsUseCase
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel
import kotlinx.coroutines.launch

class SexPositionsViewModel(
    private val getSexPositionCardsUseCase: GetSexPositionCardsUseCase
) : BaseViewModel() {

    val sexPositionsLiveData = MutableLiveData<ActionResource<List<SexPositionsCardModel>>>()

    fun getSexPositions() {
        viewModelScope.launch(backgroundScope) {
            getSexPositionCardsUseCase.execute().also {
                sexPositionsLiveData.setSuccess(it)
            }
        }
    }
}