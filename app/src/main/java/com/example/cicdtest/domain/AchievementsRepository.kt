package com.example.cicdtest.domain

interface AchievementsRepository {

    fun getAchievementsCount(): Result<Int>
}