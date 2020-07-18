package araikovich.inc.lovesex.ui.dirty_scenes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import araikovich.inc.bekind.ui.base.BaseViewModel
import araikovich.inc.bekind.ui.livedata.ActionResource
import araikovich.inc.bekind.ui.livedata.setSuccess
import araikovich.inc.lovesex.domain.dirty_scenes.GetDirtyScenesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DirtyScenesViewModel(private val getDirtyScenesUseCase: GetDirtyScenesUseCase) : BaseViewModel() {

    val dirtyScenes = MutableLiveData<ActionResource<List<DirtySceneItemModel>>>()

    fun getDirtyScenes() {
        viewModelScope.launch {
            val items = getDirtyScenesUseCase.execute()
            withContext(Dispatchers.Main) {
                dirtyScenes.setSuccess(getDirtyScenesUseCase.execute())
            }
        }
    }
}