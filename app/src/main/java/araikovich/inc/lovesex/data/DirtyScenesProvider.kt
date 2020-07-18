package araikovich.inc.lovesex.data

import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.ui.dirty_scene_detail.DirtySceneDetailModel
import araikovich.inc.lovesex.ui.dirty_scenes.DirtySceneItemModel

class DirtyScenesProvider {

    suspend fun getDirtyScenes() = mutableListOf(
        DirtySceneItemModel(
            0,
            R.string.dirty_scene_airplane,
            R.drawable.stewardess,
            isLocked = false,
            isPremium = false
        ),
        DirtySceneItemModel(
            1,
            R.string.dirty_scene_police,
            R.drawable.police,
            isLocked = false,
            isPremium = false
        ),
        DirtySceneItemModel(
            2,
            R.string.dirty_scene_first_date,
            R.drawable.first_date,
            isLocked = false,
            isPremium = false
        ),
        DirtySceneItemModel(
            3,
            R.string.dirty_scene_robber,
            R.drawable.robber,
            isLocked = false,
            isPremium = true
        ),
        DirtySceneItemModel(
            4,
            R.string.dirty_scene_school,
            R.drawable.teacher,
            isLocked = false,
            isPremium = true
        ),
        DirtySceneItemModel(
            5,
            R.string.dirty_scene_office,
            R.drawable.office,
            isLocked = false,
            isPremium = true
        ),
        DirtySceneItemModel(
            6,
            R.string.dirty_scene_nurse,
            R.drawable.medical,
            isLocked = false,
            isPremium = true
        ),
        DirtySceneItemModel(
            7,
            R.string.dirty_scene_maid,
            R.drawable.maid,
            isLocked = false,
            isPremium = true
        )
    )

    suspend fun getDirtySceneDetailById(sceneId: Int): DirtySceneDetailModel? {
        val items = mutableListOf(
            DirtySceneDetailModel(
                0,
                R.drawable.stewardess,
                R.string.dirty_scene_detail_title_airplane,
                R.string.dirty_scene_detail_description_airplane,
                isPremium = false
            ),
            DirtySceneDetailModel(
                1,
                R.drawable.police,
                R.string.dirty_scene_detail_title_police,
                R.string.dirty_scene_detail_description_police,
                isPremium = false
            ),
            DirtySceneDetailModel(
                2,
                R.drawable.first_date,
                R.string.dirty_scene_detail_title_first_date,
                R.string.dirty_scene_detail_description_first_date,
                isPremium = false
            ),
            DirtySceneDetailModel(
                3,
                R.drawable.robber,
                R.string.dirty_scene_detail_title_robber,
                R.string.dirty_scene_detail_description_robber,
                isPremium = true
            ),
            DirtySceneDetailModel(
                4,
                R.drawable.teacher,
                R.string.dirty_scene_detail_title_school,
                R.string.dirty_scene_detail_description_school,
                isPremium = true
            ),
            DirtySceneDetailModel(
                5,
                R.drawable.office,
                R.string.dirty_scene_detail_title_office,
                R.string.dirty_scene_detail_description_office,
                isPremium = true
            ),
            DirtySceneDetailModel(
                6,
                R.drawable.medical,
                R.string.dirty_scene_detail_title_nurse,
                R.string.dirty_scene_detail_description_nurse,
                isPremium = true
            ),
            DirtySceneDetailModel(
                7,
                R.drawable.maid,
                R.string.dirty_scene_detail_title_maid,
                R.string.dirty_scene_detail_description_maid,
                isPremium = true
            )
        )
        return items.firstOrNull { it.id == sceneId }
    }
}