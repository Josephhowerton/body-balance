package com.fitness.onboard.onboard.basic.view

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.component.properties.GuidelineProperties
import com.fitness.onboard.onboard.basic.viewmodel.BasicInformationEvent
import com.fitness.onboard.onboard.basic.viewmodel.BasicInformationState
import com.fitness.resources.R

@Composable
fun GenderAge(
    state: BasicInformationState,
    onTriggerEvent: (BasicInformationEvent) -> Unit = {}
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (maleImage, maleCircle, femaleImage, femaleCircle, sexPicker, agePicker, continueButton) = createRefs()


        val topGuide = createGuidelineFromTop(GuidelineProperties.SECOND_TOP)
        val midGuide = createGuidelineFromTop(.5f)
        val bottomGuide = createGuidelineFromBottom(GuidelineProperties.BOTTOM_100)
        val startGuide = createGuidelineFromStart(GuidelineProperties.START)
        val endGuide = createGuidelineFromEnd(GuidelineProperties.END)


        createHorizontalChain(maleImage, femaleImage, chainStyle = ChainStyle.Spread)

        var isChecked by remember { mutableStateOf(true) }


        val maleColor =
            if (!isChecked) Color.Transparent else MaterialTheme.colorScheme.secondaryContainer
        Box(modifier = Modifier
            .background(maleColor, CircleShape)
            .constrainAs(maleCircle) {
                start.linkTo(maleImage.start, 15.dp)
                end.linkTo(maleImage.end, 15.dp)
                top.linkTo(maleImage.top, 35.dp)
                bottom.linkTo(maleImage.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            })

        Image(
            painter = painterResource(id = R.drawable.icon_man),
            contentDescription = stringResource(id = R.string.content_description_sex_male),
            modifier = Modifier
                .size(120.dp)
                .constrainAs(maleImage) {
                    start.linkTo(startGuide)
                    end.linkTo(femaleImage.start)
                    top.linkTo(topGuide)
                }
        )

        val femaleColor =
            if (isChecked) Color.Transparent else MaterialTheme.colorScheme.secondaryContainer
        Box(modifier = Modifier
            .background(femaleColor, CircleShape)
            .constrainAs(femaleCircle) {
                start.linkTo(femaleImage.start, 15.dp)
                end.linkTo(femaleImage.end, 15.dp)
                top.linkTo(femaleImage.top, 35.dp)
                bottom.linkTo(femaleImage.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }
        )

        Image(
            painter = painterResource(id = R.drawable.icon_woman),
            contentDescription = stringResource(id = R.string.content_description_sex_female),
            modifier = Modifier
                .size(120.dp)
                .constrainAs(femaleImage) {
                    start.linkTo(maleImage.end)
                    end.linkTo(endGuide)
                    top.linkTo(topGuide)
                }
        )



        TextToggleSwitch(
            isChecked = isChecked,
            onCheckedChange = { isChecked = !isChecked },
            modifier = Modifier.constrainAs(sexPicker) {
                top.linkTo(maleImage.bottom)
                start.linkTo(maleImage.start)
                end.linkTo(femaleImage.end)
                bottom.linkTo(midGuide)
                width = Dimension.fillToConstraints
            }
        )

        CenteredLazyRow(modifier = Modifier.constrainAs(agePicker) {
            top.linkTo(midGuide)
            start.linkTo(startGuide)
            end.linkTo(endGuide)
            bottom.linkTo(continueButton.top)
        })

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(continueButton) {
                end.linkTo(endGuide)
                bottom.linkTo(bottomGuide)
            }
        ) {
            Text(text = stringResource(id = R.string.title_continue))
        }
    }
}

@Composable
fun TextToggleSwitch(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    // Define the base state for animation
    val transitionState = remember { MutableTransitionState(isChecked) }
    transitionState.targetState = isChecked

    BoxWithConstraints(modifier = modifier) {
        // Total width of the container
        val containerWidth = maxWidth

        // Size and padding of the toggle circle
        val toggleSize = 50.dp
        val togglePadding = 8.dp
        val toggleDiameterAndPadding = toggleSize + (togglePadding * 2)

        // Define the transition for the toggle animation
        val transition = updateTransition(transitionState, label = "ToggleSwitch")
        val toggleOffset by transition.animateDp(
            label = "ToggleOffset",
            transitionSpec = {
                if (targetState) {
                    spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                } else {
                    spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                }
            }
        ) { state ->
            if (state)
                0.dp
            else
                containerWidth - toggleDiameterAndPadding
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable { onCheckedChange(!isChecked) }
        ) {
            Box(
                modifier = Modifier
                    .padding(togglePadding)
                    .align(Alignment.CenterStart)
                    .offset(toggleOffset)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .size(toggleSize)
            )
            Text(
                text = if (isChecked) "Male" else "Female",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextToggleSwitchPreview() {
    var isChecked by remember { mutableStateOf(true) }
    TextToggleSwitch(
        modifier = Modifier.padding(16.dp),
        isChecked = isChecked,
        onCheckedChange = { isChecked = it }
    )
}

@Composable
fun CenteredLazyRow(modifier: Modifier = Modifier) {
    val numbers = (20..100).toList()
    val itemWidth = 100.dp // Width of each item
    val lazyRowWidth = itemWidth * 3 // Total width to show 3 items

    LazyRow(
        modifier = modifier.width(lazyRowWidth)
    ) {
        items(numbers) { number ->
            Box(
                modifier = Modifier
                    .width(itemWidth)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = number.toString())
            }
        }
    }
}