package hs.project.studycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import hs.project.studycompose.data.CardData
import hs.project.studycompose.ui.theme.StudyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyComposeTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//                        CardExam(cardData)
//                        CardExam(cardData)
//                    }
//                }
                CheckBoxExam()
            }
        }
    }

    companion object {
        val cardData = CardData(
            imgUri = "https://i.pravatar.cc/150?img=3",
            imgDescription = "설명",
            author = "작가",
            description = "소개소개소개"
        )
    }
}

@Composable
fun ButtonExam(onButtonClicked: () -> Unit) {
    Button(
        onClick = { onButtonClicked() },
        enabled = true,
        border = BorderStroke(4.dp, Color.Green),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}

@Composable
fun ModifierExam() {
    Button(
        onClick = {},
        modifier = Modifier
            .size(200.dp, 100.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green,
            contentColor = Color.Black
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            text = "Search",
            modifier = Modifier
                .offset(x = 10.dp, y = (-5).dp)
                .background(Color.Blue)
        )
//        Text(
//            text = "Search",
//            modifier = Modifier.clickable {  }
//        )
    }
}

@Composable
fun SurfaceExam(name: String) {
    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 10.dp,
        border = BorderStroke(width = 2.dp, color = Color.Green),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "Hello $name",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BoxExam() {
//    Box(
//        modifier = Modifier.size(100.dp).background(Color.Blue)) {
//        Text(text = "Hello",
//            modifier = Modifier.align(Alignment.TopCenter)
//        )
//        Text(text = "World",
//            modifier = Modifier.align(Alignment.BottomCenter)
//        )
//    }
    Box {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Red)
                .align(Alignment.BottomEnd)
        ) {

        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Green)
                .align(Alignment.Center)
        ) {

        }
    }
}

@Composable
fun RowExam() {
//    Row(
//        modifier = Modifier.height(40.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(text = "First", modifier = Modifier.align(Alignment.Top))
//        Text(text = "Second")
//        Text(text = "Third")
//    }

    Row(
        modifier = Modifier
            .height(40.dp)
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "First",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
        )
        Text(
            text = "Second",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(2f)
        )
        Text(
            text = "Third",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
        )
    }
}

@Composable
fun ColumExam() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(100.dp),
    ) {
        Text(
            text = "First",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Second"
        )
        Text(
            text = "Third",
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Composable
fun BoxWithConstraintExam() {
    Column {
        BoxWithExamInner(
            modifier = Modifier
                .width(200.dp)
                .height(160.dp)
//            .widthIn(min = 100.dp, max = 350.dp)
//            .heightIn(max = 160.dp)
        )
        BoxWithExamInner(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
//            .widthIn(min = 100.dp, max = 350.dp)
//            .heightIn(max = 160.dp)
        )
    }
}

@Composable
fun BoxWithExamInner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        if (maxHeight > 100.dp) {
            Text(
                text = "100DP 이상",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text(
            text = "maxWidth:$maxWidth, maxHeight:$maxHeight, minWidth:$minWidth, minHeight:$minHeight"
        )
    }
}

@Composable
fun ImageExam() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_ad),
            contentDescription = "배경"
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "벡터"
        )
//        Image(
//            bitmap = ,
//            contentDescription = "비트맵"
//        )
        val imgUrl = "https://i.pravatar.cc/150?img=3"
        val imgUrl2 = "https://i.pravatar.cc/150?img=6"
        // Coil 라이브러리
        val painter = rememberImagePainter(data = imgUrl)
        Image(painter = painter, contentDescription = "인터넷 이미지")
        AsyncImage(model = imgUrl2, contentDescription = "어싱크 인터넷 이미지")
    }
}

@Composable
fun CardExam(cardData: CardData) {
    val placeHolderColor = Color(0xFF5F5B5B)

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeHolderColor),
                model = cardData.imgUri,
                contentDescription = cardData.imgDescription
            )
            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}

@Composable
fun CheckBoxExam() {
    Row(verticalAlignment = Alignment.CenterVertically) {
//        var checked = remember { mutableStateOf(false) }

        // delegated properties 로 변경
//        var checked by remember { mutableStateOf(false) }
//        Checkbox(checked = checked, onCheckedChange = { checked = it })


        // destruction 으로 상태 받아서 처리
        val (getter, setChecked) = remember { mutableStateOf(false) }
        Checkbox(checked = getter, onCheckedChange = { setChecked(it) })
        Text(
            text = "사람입니까?",
            modifier = Modifier.clickable {
                setChecked(!getter)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    StudyComposeTheme {
        CheckBoxExam()
    }
}