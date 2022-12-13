package com.devpass.spaceapp.models

import android.content.Context
import com.devpass.spaceapp.R
import java.text.SimpleDateFormat

fun Launch.formatDate(): String {
    //Informa o formato da data que está vindo da api
    val formatterApi = SimpleDateFormat("yyyy-MM-dd")
    //Transforma em um long
    val dateLong = formatterApi.parse(date.substringBefore("T"))?.time

    //Informa o formato da data que queremos
    val formated = SimpleDateFormat("MMMM dd, yyyy")
    //Formata a data como um string
    return formated.format(dateLong)
}

fun Launch.getImgLink() =
    image.banner ?: "https://dummyimage.com/400x400/000/fff"

fun Launch.getStatus(context: Context) =
    status?.let {
        if (it) context.getString(R.string.success)
        else context.getString(R.string.fail)
    } ?: context.getString(R.string.uknown)