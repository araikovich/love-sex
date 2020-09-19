package araikovich.inc.lovesex.data.provider

import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel

class SexPositionCardsProvider {

    suspend fun getSexPositionCards(): List<SexPositionsCardModel> {
        return mutableListOf(
            SexPositionsCardModel(
                0,
                R.drawable.poses_69_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_69_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_clip_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_clip_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_column_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_column_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_dog_style,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_dog_style,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_fun_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_fun_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_imperator_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_imperator_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_kazanova_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_kazanova_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_king_of_the_world_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_king_of_the_world_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_locked_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_locked_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_perched_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_perched_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_rider_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_rider_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_roc_n_roll_pos,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_roc_n_roll_pos,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                0,
                R.drawable.poses_rwo_sory_pos,
                isPremium = false,
                isLocked = false
            ),SexPositionsCardModel(
                0,
                R.drawable.poses_roc_n_roll_pos,
                isPremium = true,
                isLocked = true
            )
        )
    }
}