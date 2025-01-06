package com.example.cicdtest.domain

class GetAchievementsCountUseCase(
    private val achievementsRepository: AchievementsRepository,
) : UseCases.UnaryResult<Unit, Int> {

    override suspend fun execute(params: Unit): Result<Int> {
        return achievementsRepository.getAchievementsCount()
    }
}
