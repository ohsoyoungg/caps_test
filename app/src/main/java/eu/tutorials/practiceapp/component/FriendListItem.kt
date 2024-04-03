package eu.tutorials.practiceapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.practiceapp.R
import eu.tutorials.practiceapp.friends.UserEntity
import eu.tutorials.practiceapp.ui.theme.Black3A
import eu.tutorials.practiceapp.ui.theme.BtnGreen
import eu.tutorials.practiceapp.ui.theme.TextBlack
import eu.tutorials.practiceapp.ui.theme.TextGray
import eu.tutorials.practiceapp.ui.theme.TextGreen

@Composable
fun FriendListItem(
    selected: Boolean,
    user: UserEntity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = if(selected) R.drawable.account_circle_selected else R.drawable.account_circle
            ),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.padding(top = 6.dp))

        Text(
            text = user.userName,
            style = TextStyle(
                color = TextBlack,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )

        if(selected) {
            Spacer(modifier = Modifier.padding(top = 7.dp))
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(3.dp)
                    .background(color = TextGreen)
            )
        }
    }
}