package com.fitness.onboard.onboard.basic.view

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.fitness.component.screens.ErrorScreen
import com.fitness.component.screens.LoadingScreen
import com.fitness.component.screens.MessageScreen
import com.fitness.onboard.onboard.basic.viewmodel.BasicInformationEvent
import com.fitness.onboard.onboard.basic.viewmodel.BasicInformationState
import com.fitness.onboard.onboard.basic.viewmodel.BasicInformationStep
import com.fitness.resources.R
import com.fitness.theme.ui.BodyBalanceTheme
import extensions.cast
import failure.Failure
import kotlinx.coroutines.flow.StateFlow
import state.BaseViewState

@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BasicInformationPreview() = BodyBalanceTheme {
    Surface {
        BasicInformationContent(state = BasicInformationState())
    }
}

@Composable
fun BasicInformationScreen(
    state: StateFlow<BaseViewState<BasicInformationState>>,
    onTriggerEvent: (BasicInformationEvent) -> Unit,
    onComplete: () -> Unit
) {
    val uiState by state.collectAsState()

    when (uiState) {
        is BaseViewState.Data -> {
            BasicInformationContent(
                state = uiState.cast<BaseViewState.Data<BasicInformationState>>().value,
                onTriggerEvent = onTriggerEvent,
                onComplete = onComplete
            )
        }

        is BaseViewState.Error -> {
            val failure = uiState.cast<BaseViewState.Error>().throwable as Failure

            ErrorScreen(title = failure.title, description = failure.description) {
                onComplete()
            }
        }

        is BaseViewState.Loading -> {
            LoadingScreen()
        }

        else -> {
            MessageScreen(message = R.string.unknown, onClick = onComplete)
        }
    }
}

@Composable
private fun BasicInformationContent(
    state: BasicInformationState,
    onTriggerEvent: (BasicInformationEvent) -> Unit = {},
    onComplete: () ->  Unit = {}
) {
    when(state.step){
        BasicInformationStep.GENDER_AGE -> {
            GenderAge(state = state, onTriggerEvent)
        }
        BasicInformationStep.WEIGHT -> {
            WeightMeasurement(state = state, onTriggerEvent)
        }
        BasicInformationStep.HEIGHT -> {
            HeightMeasurement(state = state, onTriggerEvent)
        }
        BasicInformationStep.HEALTH_CONCERNS -> {
            HealthConcerns(state = state, onTriggerEvent)
        }
        BasicInformationStep.DIETARY_PREFERENCES -> {
             DietaryPreferences(state = state, onTriggerEvent)
        }

        BasicInformationStep.SAVE_BASIC_INFORMATION -> onTriggerEvent(BasicInformationEvent.SaveBasicInformation)
        BasicInformationStep.COMPLETE -> onComplete()
    }
}