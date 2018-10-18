package com.example.vitalii.lab2.util

import android.content.Context
import com.example.vitalii.lab2.model.Image

object AlreadyLocalDB{


       private val IMAGE_PREFERENCE="image_preference"
        private val IMAGE_URL_KEY_1="image_url_key_1"
        private val IMAGE_URL_KEY_2="image_url_key_2"
        private val IMAGE_URL_KEY_3="image_url_key_3"
        private val IMAGE_URL_KEY_4="image_url_key_4"


    fun insertToPreferenceImages(context:Context){
       val preference   = context.getSharedPreferences(IMAGE_PREFERENCE,Context.MODE_PRIVATE).edit()
        preference.putString(IMAGE_URL_KEY_1,"https://cdn.psychologytoday.com/sites/default/files/styles/article-inline-half/public/field_blog_entry_images/2018-02/vicious_dog_0.png?itok=nsghKOHs")
        preference.putString(IMAGE_URL_KEY_2,"https://i.kinja-img.com/gawker-media/image/upload/s--U2teUaC1--/c_fill,f_auto,fl_progressive,g_north,h_264,q_80,w_470/ffyyaurvt86ws4r4bpzu.jpg")
        preference.putString(IMAGE_URL_KEY_3,"https://www.postbeeld.nl/media/catalog/category/pinguin.png")
        preference.putString(IMAGE_URL_KEY_4,"https://codigooculto.com/wp-content/uploads/2018/07/leones-devoran-a-tres-cazadores-furtivos-que-iban-a-matar-rinocerontes-portada.jpg")
        preference.apply()
    }

    fun getImagesFromLocalDb(context: Context):List<Image>{
        val imagesList= mutableListOf<Image>()
        val preferences=context.getSharedPreferences(IMAGE_PREFERENCE,Context.MODE_PRIVATE)
        imagesList.add(Image(1,"dog",preferences.getString(IMAGE_URL_KEY_1,""),false))
        imagesList.add(Image(2,"cat",preferences.getString(IMAGE_URL_KEY_2,""),false))
        imagesList.add(Image(3,"penguin",preferences.getString(IMAGE_URL_KEY_3,""),false))
        imagesList.add(Image(4,"lion",preferences.getString(IMAGE_URL_KEY_4,""),false))
        return imagesList
    }
}