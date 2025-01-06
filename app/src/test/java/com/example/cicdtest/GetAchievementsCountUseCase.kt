package com.example.cicdtest

import com.example.cicdtest.domain.AchievementsRepository
import com.example.cicdtest.domain.GetAchievementsCountUseCase
import org.junit.Assert
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAchievementsCountUseCase {

    @Mock lateinit var achievementsRepository: AchievementsRepository

    @InjectMocks lateinit var useCase: GetAchievementsCountUseCase

    @Test
    fun `Should reset meal value from storage`() = runTest {
        whenever(achievementsRepository.getAchievementsCount()).thenReturn(Result.success(5))
        val expected = useCase.execute(Unit)
        Assert.assertEquals(expected, Result.success(5))
    }
}
