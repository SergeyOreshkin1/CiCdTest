package com.example.cicdtest.domain

import kotlinx.coroutines.flow.Flow

sealed interface UseCases {

    /** Операция, которая не может завершиться ошибкой */
    interface Unary<Params, Result> : UseCases {
        suspend fun execute(params: Params): Result
    }

    /** Операция, которая может завершиться какой-либо ошибкой. Если имеются особые ошибки, на которые МП должно особым
     * образом реагировать, то в документации к юзкейсу в разделе return нужно прикладывать, какие ошибки бывают.
     * Ошибки должны наследоваться от [Throwable] */
    interface UnaryResult<Params, Result : Any> : UseCases {
        suspend fun execute(params: Params): kotlin.Result<Result>
    }

    /** Юзкейс, который поставляет данные в виде [Flow] и не кидает ошибку */
    interface Stream<Params, Result> : UseCases {
        fun execute(params: Params): Flow<Result>
    }

    /** Юзкейс, который поставляет данные в виде [Flow], но при этом может кинуть ошибку.
     * Если имеются особые ошибки, на которые МП должно особым образом реагировать, то в документации к юзкейсу в
     * разделе return нужно прикладывать, какие ошибки бывают.
     * Ошибки должны наследоваться от [Throwable]  */
    interface StreamResult<Params, Result> : UseCases {
        fun execute(params: Params): Flow<kotlin.Result<Result>>
    }
}