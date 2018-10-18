package com.example.vitalii.lab2.searchImage

import com.example.vitalii.lab2.model.Image

interface SearchView {

    fun goToItemPosition(position:Int)

    fun showToastMessage(message:String)

    fun setDataToAdapter(listOfImages:List<Image>)

}