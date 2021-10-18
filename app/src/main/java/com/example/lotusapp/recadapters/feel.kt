package com.example.lotusapp.recadapters

import com.example.lotusapp.R

data class feel(val image:Int, val name_feel:String)
{
    class MyFeel{val list = arrayListOf(
        feel(R.drawable.calm,"Спокойным"),
        feel(R.drawable.relax,"Расслабленным"),
        feel(R.drawable.focus,"Сосредоточенным"),
        feel(R.drawable.anxious,"Взволнованным")
    )}
}


