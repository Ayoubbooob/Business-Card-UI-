package com.bosseurs.businesscard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BusinessCard(
                        pic_Id = R.drawable.my_pic,
                        person_name_Id = R.string.ayoub_name,
                        person_role_id = R.string.ayoub_role,
                        phone_number_Id = R.string.phone_number,
                        mail_Id = R.string.mail,
                        github_Id = R.string.github
                    )
                }
            }
        }
    }
}


@Composable
fun Avatar(
    imageId : Int,
    size : Dp = 120.dp,
){
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50))
            .size(size)
    )
}
@Composable
fun CardHighlightedInfo(
    imageId : Int,
    person_name_Id : Int,
    person_role_Id : Int,
){
    val titleFontFamily = FontFamily(Font(R.font.shantell_sans_regular))
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Avatar(imageId = imageId)
        Text(stringResource(id = person_name_Id), fontFamily = titleFontFamily, fontSize = 34.sp,color = colorResource(id = R.color.white) , modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
        Text(stringResource(id = person_role_Id), fontSize = 22.sp, color = colorResource(id = R.color.custom_green))
    }
}

@Composable
fun Info(
    leadingIcon_Id : Int,
    text_Id : Int,
){
    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 40.dp, end = 40.dp)){
        Icon(painter = painterResource(id = leadingIcon_Id),
            contentDescription = null,
        tint = colorResource(id = R.color.custom_green)
            )
        Spacer(modifier = Modifier.width(30.dp))
        Text(stringResource(id = text_Id), fontSize = 20.sp, color =  colorResource(id = R.color.white))
        Column() {}
    }

}
@Composable
fun CardDetailsInfo(
    phone_number_Id : Int,
    github_Id: Int,
    mail_Id : Int,
    modifier: Modifier

) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxWidth().padding(bottom = 70.dp)
    ) {
        Divider(color = colorResource(id = R.color.custom_white), thickness = 1.dp)
        Info(leadingIcon_Id = R.drawable.baseline_local_phone_24, text_Id = phone_number_Id)
        Divider(color = colorResource(id = R.color.custom_white), thickness = 1.dp)
        Info(leadingIcon_Id = R.drawable.baseline_insert_link_24, text_Id = github_Id)
        Divider(color = colorResource(id = R.color.custom_white), thickness = 1.dp)
        Info(leadingIcon_Id = R.drawable.baseline_mail_24, text_Id = mail_Id)

    }
}

@Composable
fun BusinessCard(
    pic_Id : Int,
    person_name_Id: Int,
    person_role_id : Int,
    phone_number_Id : Int,
    mail_Id : Int,
    github_Id : Int,
){
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.custom_background_color)),
        verticalArrangement = Arrangement.SpaceBetween
        ) {
        Column() {}
        CardHighlightedInfo(imageId = pic_Id, person_name_Id = person_name_Id, person_role_Id = person_role_id)
        CardDetailsInfo(phone_number_Id = phone_number_Id, github_Id = github_Id, mail_Id = mail_Id,
            modifier = Modifier.weight(1f, false )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview(){
    BusinessCardTheme() {
        BusinessCard(
            pic_Id = R.drawable.my_pic,
            person_name_Id = R.string.ayoub_name,
            person_role_id = R.string.ayoub_role,
            phone_number_Id = R.string.phone_number,
            mail_Id = R.string.mail,
            github_Id = R.string.github
        )
    }
}

//CardHighlightedInfo(imageId = R.drawable.mapic, person_name_Id = R.string.ayoub_name, person_role_Id = R.string.ayoub_role)
//CardDetailsInfo(phone_number_Id = R.string.phone_number, github_Id = R.string.github, mail_Id = R.string.mail)