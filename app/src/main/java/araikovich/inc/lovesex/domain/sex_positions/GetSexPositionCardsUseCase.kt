package araikovich.inc.lovesex.domain.sex_positions

import araikovich.inc.lovesex.data.SexPositionCardsProvider
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel

class GetSexPositionCardsUseCase(
    private val sexPositionCardsProvider: SexPositionCardsProvider
) {

    suspend fun execute(): List<SexPositionsCardModel> {
        return sexPositionCardsProvider.getSexPositionCards()
    }
}