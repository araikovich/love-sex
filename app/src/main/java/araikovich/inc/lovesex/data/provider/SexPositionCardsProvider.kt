package araikovich.inc.lovesex.data.provider

import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.ui.sex_positions.model.SexPositionsCardModel

class SexPositionCardsProvider {

    suspend fun getSexPositionCards(): List<SexPositionsCardModel> {
        return mutableListOf(
            SexPositionsCardModel(
                1,
                R.drawable.poses_69_pos,
                R.string.sex_positions_pose_69_title,
                R.string.sex_positions_pose_69_notification,
                R.string.sex_positions_pose_69_description,
                R.string.sex_positions_pose_69_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                2,
                R.drawable.poses_69_pos,
                R.string.sex_positions_pose_69_title,
                R.string.sex_positions_pose_69_notification,
                R.string.sex_positions_pose_69_description,
                R.string.sex_positions_pose_69_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                3,
                R.drawable.poses_clip_pos,
                R.string.sex_positions_clip_pose_title,
                R.string.sex_positions_clip_pose_notification,
                R.string.sex_positions_clip_pose_description,
                R.string.sex_positions_clip_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                4,
                R.drawable.poses_clip_pos,
                R.string.sex_positions_clip_pose_title,
                R.string.sex_positions_clip_pose_notification,
                R.string.sex_positions_clip_pose_description,
                R.string.sex_positions_clip_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                5,
                R.drawable.poses_column_pos,
                R.string.sex_positions_column_pose_title,
                R.string.sex_positions_column_pose_notification,
                R.string.sex_positions_column_pose_description,
                R.string.sex_positions_column_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                6,
                R.drawable.poses_column_pos,
                R.string.sex_positions_column_pose_title,
                R.string.sex_positions_column_pose_notification,
                R.string.sex_positions_column_pose_description,
                R.string.sex_positions_column_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                7,
                R.drawable.poses_dog_style,
                R.string.sex_positions_dog_style_pose_title,
                R.string.sex_positions_dog_style_pose_notification,
                R.string.sex_positions_dog_style_pose_description,
                R.string.sex_positions_dog_style_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                8,
                R.drawable.poses_dog_style,
                R.string.sex_positions_dog_style_pose_title,
                R.string.sex_positions_dog_style_pose_notification,
                R.string.sex_positions_dog_style_pose_description,
                R.string.sex_positions_dog_style_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                9,
                R.drawable.poses_fun_pos,
                R.string.sex_positions_fun_pose_title,
                R.string.sex_positions_fun_pose_notification,
                R.string.sex_positions_fun_pose_description,
                R.string.sex_positions_fun_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                10,
                R.drawable.poses_fun_pos,
                R.string.sex_positions_fun_pose_title,
                R.string.sex_positions_fun_pose_notification,
                R.string.sex_positions_fun_pose_description,
                R.string.sex_positions_fun_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                11,
                R.drawable.poses_imperator_pos,
                R.string.sex_positions_imperator_pose_title,
                R.string.sex_positions_imperator_pose_notification,
                R.string.sex_positions_imperator_pose_description,
                R.string.sex_positions_imperator_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                12,
                R.drawable.poses_imperator_pos,
                R.string.sex_positions_imperator_pose_title,
                R.string.sex_positions_imperator_pose_notification,
                R.string.sex_positions_imperator_pose_description,
                R.string.sex_positions_imperator_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                13,
                R.drawable.poses_kazanova_pos,
                R.string.sex_positions_kazanova_pose_title,
                R.string.sex_positions_kazanova_pose_notification,
                R.string.sex_positions_kazanova_pose_description,
                R.string.sex_positions_kazanova_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                14,
                R.drawable.poses_kazanova_pos,
                R.string.sex_positions_kazanova_pose_title,
                R.string.sex_positions_kazanova_pose_notification,
                R.string.sex_positions_kazanova_pose_description,
                R.string.sex_positions_kazanova_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                15,
                R.drawable.poses_king_of_the_world_pos,
                R.string.sex_positions_king_of_the_world_pose_title,
                R.string.sex_positions_king_of_the_world_pose_notification,
                R.string.sex_positions_king_of_the_world_pose_description,
                R.string.sex_positions_king_of_the_world_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                16,
                R.drawable.poses_king_of_the_world_pos,
                R.string.sex_positions_king_of_the_world_pose_title,
                R.string.sex_positions_king_of_the_world_pose_notification,
                R.string.sex_positions_king_of_the_world_pose_description,
                R.string.sex_positions_king_of_the_world_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                17,
                R.drawable.poses_locked_pos,
                R.string.sex_positions_locked_pose_title,
                R.string.sex_positions_locked_pose_notification,
                R.string.sex_positions_locked_pose_description,
                R.string.sex_positions_locked_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                18,
                R.drawable.poses_locked_pos,
                R.string.sex_positions_locked_pose_title,
                R.string.sex_positions_locked_pose_notification,
                R.string.sex_positions_locked_pose_description,
                R.string.sex_positions_locked_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                19,
                R.drawable.poses_perched_pos,
                R.string.sex_positions_perched_pose_title,
                R.string.sex_positions_perched_pose_notification,
                R.string.sex_positions_perched_pose_description,
                R.string.sex_positions_perched_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                20,
                R.drawable.poses_perched_pos,
                R.string.sex_positions_perched_pose_title,
                R.string.sex_positions_perched_pose_notification,
                R.string.sex_positions_perched_pose_description,
                R.string.sex_positions_perched_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                21,
                R.drawable.poses_rider_pos,
                R.string.sex_positions_rider_pose_title,
                R.string.sex_positions_rider_pose_notification,
                R.string.sex_positions_rider_pose_description,
                R.string.sex_positions_rider_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                22,
                R.drawable.poses_rider_pos,
                R.string.sex_positions_rider_pose_title,
                R.string.sex_positions_rider_pose_notification,
                R.string.sex_positions_rider_pose_description,
                R.string.sex_positions_rider_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                23,
                R.drawable.poses_roc_n_roll_pos,
                R.string.sex_positions_roc_n_roll_pose_title,
                R.string.sex_positions_roc_n_roll_pose_notification,
                R.string.sex_positions_roc_n_roll_pose_description,
                R.string.sex_positions_roc_n_roll_pose_level,
                isPremium = false,
                isLocked = false
            ), SexPositionsCardModel(
                24,
                R.drawable.poses_roc_n_roll_pos,
                R.string.sex_positions_roc_n_roll_pose_title,
                R.string.sex_positions_roc_n_roll_pose_notification,
                R.string.sex_positions_roc_n_roll_pose_description,
                R.string.sex_positions_roc_n_roll_pose_level,
                isPremium = true,
                isLocked = true
            ), SexPositionsCardModel(
                25,
                R.drawable.poses_rwo_sory_pos,
                R.string.sex_positions_two_story_pose_title,
                R.string.sex_positions_two_story_pose_notification,
                R.string.sex_positions_two_story_pose_description,
                R.string.sex_positions_two_story_pose_level,
                isPremium = false,
                isLocked = false
            ),SexPositionsCardModel(
                26,
                R.drawable.poses_rwo_sory_pos,
                R.string.sex_positions_two_story_pose_title,
                R.string.sex_positions_two_story_pose_notification,
                R.string.sex_positions_two_story_pose_description,
                R.string.sex_positions_two_story_pose_level,
                isPremium = true,
                isLocked = true
            )
        )
    }
}