package com.example.cicdtest.domain

class AchievementsRepositoryImpl: AchievementsRepository {

    override fun getAchievementsCount() = Result.success(5)
}