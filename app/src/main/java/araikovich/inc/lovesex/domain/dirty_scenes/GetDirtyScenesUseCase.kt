package araikovich.inc.lovesex.domain.dirty_scenes

import araikovich.inc.lovesex.data.DirtyScenesProvider
import araikovich.inc.lovesex.ui.dirty_scenes.DirtySceneItemModel

class GetDirtyScenesUseCase(val localProvider: DirtyScenesProvider) {

    suspend fun execute(): List<DirtySceneItemModel> {
        return localProvider.getDirtyScenes()
    }
}