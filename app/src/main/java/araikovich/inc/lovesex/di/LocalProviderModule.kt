package araikovich.inc.lovesex.di

import araikovich.inc.lovesex.data.provider.DirtyScenesProvider
import araikovich.inc.lovesex.data.provider.SexMissionsPacksProvider
import araikovich.inc.lovesex.data.provider.SexPositionCardsProvider
import org.koin.dsl.module

val localProviderModule = module {
    factory { SexPositionCardsProvider() }
    factory { SexMissionsPacksProvider() }
    factory { DirtyScenesProvider() }
}