package com.techieblossom.kfcm.ui.features.team.detail.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun TeamRecommendation(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { },
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
    ) {
        Text(
            stringResource(R.string.team_recommendations),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "")
    }
}

@Preview
@Composable
fun Preview_TeamRecommendation() {
    FCMTheme {
        TeamRecommendation(modifier = Modifier.padding(8.dp))
    }
}