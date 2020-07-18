package araikovich.inc.lovesex.di

import araikovich.inc.lovesex.ui.dirty_scene_detail.DirtySceneDetailViewModel
import araikovich.inc.lovesex.ui.dirty_scenes.DirtyScenesViewModel
import araikovich.inc.lovesex.ui.sex_missions.SexMissionsPacksViewModel
import araikovich.inc.lovesex.ui.sex_positions.SexPositionsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { SexPositionsViewModel(get()) }
    factory { SexMissionsPacksViewModel(get()) }
    factory { DirtyScenesViewModel(get()) }
    factory { DirtySceneDetailViewModel(get()) }
}