package araikovich.inc.lovesex.domain.dirty_scenes

import araikovich.inc.lovesex.data.provider.DirtyScenesProvider
import araikovich.inc.lovesex.ui.dirty_scene_detail.DirtySceneDetailModel

class GetDirtySceneByIdUseCase(private val dirtyScenesProvider: DirtyScenesProvider) {

    suspend fun execute(sceneId: Int): DirtySceneDetailModel? {
        return dirtyScenesProvider.getDirtySceneDetailById(sceneId)
    }
}