package araikovich.inc.lovesex.di

import araikovich.inc.lovesex.data.DirtyScenesProvider
import araikovich.inc.lovesex.data.SexMissionsPacksProvider
import araikovich.inc.lovesex.data.SexPositionCardsProvider
import org.koin.dsl.module

val localProviderModule = module {
    factory { SexPositionCardsProvider() }
    factory { SexMissionsPacksProvider() }
    factory { DirtyScenesProvider() }
}