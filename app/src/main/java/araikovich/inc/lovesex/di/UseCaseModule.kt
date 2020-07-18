package araikovich.inc.lovesex.di

import araikovich.inc.lovesex.domain.dirty_scenes.GetDirtySceneByIdUseCase
import araikovich.inc.lovesex.domain.dirty_scenes.GetDirtyScenesUseCase
import araikovich.inc.lovesex.domain.sex_missions.GetSexMissionsUseCase
import araikovich.inc.lovesex.domain.sex_positions.GetSexPositionCardsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetSexPositionCardsUseCase(get()) }
    factory { GetSexMissionsUseCase(get()) }
    factory { GetDirtyScenesUseCase(get()) }
    factory { GetDirtySceneByIdUseCase(get()) }
}