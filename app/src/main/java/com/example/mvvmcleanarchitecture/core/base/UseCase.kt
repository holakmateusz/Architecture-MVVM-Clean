package com.example.mvvmcleanarchitecture.core.base

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> {

    abstract suspend fun action(params: Params): Type

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (result: Result<Type>) -> Unit = {}
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                runCatching {
                    action(params)
                }
            }
            onResult(result)
        }
    }
}