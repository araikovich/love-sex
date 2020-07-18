package araikovich.inc.lovesex.ui.dirty_scene_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import araikovich.inc.bekind.ui.base.BaseViewModel
import araikovich.inc.bekind.ui.livedata.ActionResource
import araikovich.inc.bekind.ui.livedata.setError
import araikovich.inc.bekind.ui.livedata.setSuccess
import araikovich.inc.lovesex.domain.dirty_scenes.GetDirtySceneByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DirtySceneDetailViewModel(private val getDirtySceneByIdUseCase: GetDirtySceneByIdUseCase) :
    BaseViewModel() {

    val dirtySceneModel = MutableLiveData<ActionResource<DirtySceneDetailModel>>()

    fun getDirtyScene(dirtySceneId: Int) {
        viewModelScope.launch {
            val scene = getDirtySceneByIdUseCase.execute(dirtySceneId)
            withContext(Dispatchers.Main) {
                if (scene != null) {
                    dirtySceneModel.setSuccess(scene)
                } else {
                    dirtySceneModel.setError("no scene with id = $dirtySceneId")
                }
            }
        }
    }
}