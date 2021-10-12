package com.example.lotusapp.recadapters

import com.example.lotusapp.R

data class state(val title:String, val text_state:String, val image_state:Int)
{
    class MyState{val list = arrayListOf(
        state("Заголовок статьи","Краткое описание", R.drawable.state_img_1),
        state("Заголовок статьи","Краткое описание", R.drawable.state_img_2),
        state("Заголовок статьи","Краткое описание", R.drawable.state_img_3))
    }
}


