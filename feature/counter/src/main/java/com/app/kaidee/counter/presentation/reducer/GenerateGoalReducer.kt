package com.app.kaidee.counter.presentation.reducer

import com.app.kaidee.arch.mvi.MviReducer
import com.app.kaidee.counter.presentation.CounterResult.GenerateGoalResult
import com.app.kaidee.counter.presentation.CounterResult.GenerateGoalResult.*
import com.app.kaidee.counter.presentation.CounterViewState
import javax.inject.Inject

class GenerateGoalReducer @Inject constructor() : MviReducer<GenerateGoalResult, CounterViewState> {

    override fun reduce(result: GenerateGoalResult, previousState: CounterViewState): CounterViewState {
        return when (result) {
            is Loading -> {
                previousState.copy(
                    isWin = false,
                    isLoading = true,
                    error = null
                )
            }
            is Success -> {
                previousState.copy(
                    goal = result.goal,
                    count = result.startNumber,
                    isWin = false,
                    isLoading = false,
                    error = null
                )
            }
            is Failure -> {
                previousState.copy(
                    isWin = false,
                    isLoading = false,
                    error = result.throwable
                )
            }
        }
    }

}