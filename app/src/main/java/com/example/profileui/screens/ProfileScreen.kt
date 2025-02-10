package com.example.profileui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileui.R

@Composable
fun ProfileScreen(){

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        TopBar(name = "krramones", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(6.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonActionSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(12.dp))
        HighlightSection(
            highlights = listOf(
                ImageAndText(image = painterResource(R.drawable.youtube), text = "YouTube"),
                ImageAndText(image = painterResource(R.drawable.qa), text = "Programing"),
                ImageAndText(image = painterResource(R.drawable.discord), text = "Discord"),
                ImageAndText(image = painterResource(R.drawable.telegram), text = "Telegram")
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        PostTabView(
            imageAndTexts = listOf(
                ImageAndText(image = painterResource(id = R.drawable.ic_grid), text = "Posts"),
                ImageAndText(image = painterResource(id = R.drawable.ic_reels), text = "Reels"),
                ImageAndText(image = painterResource(id = R.drawable.ic_igtv), text = "Posts"),
                ImageAndText(image = painterResource(id = R.drawable.profile), text = "Profile")
            )
        ) {

        }

    }

}

@Composable
fun TopBar(
    name : String,
    modifier: Modifier = Modifier
){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }

}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column (modifier = modifier.fillMaxWidth()){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){
            RoundImage(image = painterResource(id = R.drawable.profile_user),
                modifier = Modifier.size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Android Software Engineer",
            description = "With 3+ years of experience working on great Apps\n" +
                    "I can help you with exceptional software solutions\n" +
                "Let's build the incredible Apps & Projects.",
            url = "www.twenty20.com",
            followedBy = listOf("cr7", "marcelotwelve", "vinijr"),
            otherCount = 8
        )
    }
}


@Composable
fun RoundImage(
    image : Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = "profile",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ){
        ProfileStat(numberText = "32", text = "Post")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "35k", text = "Following")


    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text : String,
    modifier: Modifier = Modifier
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ProfileDescription(
    displayName : String,
    description : String,
    url : String,
    followedBy : List<String>,
    otherCount: Int,
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = url,
            color = Color.Blue,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()){
            Text (
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")

                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size-1){
                            append(",")
                        }
                    }
                    if (otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }

    }
}

@Composable
fun ButtonActionSection(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.ArrowDropDown,
            modifier = Modifier.defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier.defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier.defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.ArrowDropDown,
            modifier = Modifier.defaultMinSize(minWidth = 5.dp)
                .height(height)
        )
    }

}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon : ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text != null){
            Text(text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp)
        }
        if (icon != null){
            Icon(imageVector = icon,
                contentDescription = null,
                tint = Color.Black)
        }

    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageAndText>
){

    LazyRow(modifier = modifier) {
        items(highlights.size){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                    )
                Text (
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageAndTexts : List<ImageAndText>,
    onTabSelected : (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inactiveColor = Color.LightGray
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier
        ) {
        imageAndTexts.forEachIndexed { index, item ->

            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )

            }
        }


    }

}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {

        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                        )
            )
        }

    }
}