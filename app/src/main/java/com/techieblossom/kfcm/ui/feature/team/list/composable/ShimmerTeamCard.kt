package com.techieblossom.kfcm.ui.feature.team.list.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.modifier.shimmerEffect
import com.techieblossom.kfcm.ui.previewMocks.teamForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun ShimmerTeamCard(modifier: Modifier = Modifier) {
    OutlinedCard(
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.height(180.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(60.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
                .shimmerEffect(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(20.dp)
                .align(Alignment.CenterHorizontally)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(80.dp)
                .height(16.dp)
                .align(Alignment.CenterHorizontally)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(16.dp)
                .align(Alignment.CenterHorizontally)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(8.dp))
//        Divider()
//        Spacer(modifier = Modifier.height(8.dp))
//        Box(
//            modifier = Modifier
//                .padding(horizontal = 8.dp)
//                .clip(RoundedCornerShape(25.dp))
//                .fillMaxWidth()
//                .height(50.dp)
//                .align(Alignment.CenterHorizontally)
//                .shimmerEffect()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .height(16.dp)
                .shimmerEffect()
        )
    }
}

@Preview
@Composable
fun Preview_ShimmerTeamCard() {
    FCMTheme {
        Surface {
            ShimmerTeamCard()
        }
    }
}