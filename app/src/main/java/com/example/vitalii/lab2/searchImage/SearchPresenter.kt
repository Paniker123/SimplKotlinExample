package com.example.vitalii.lab2.searchImage

import android.content.Context
import com.example.vitalii.lab2.model.Image
import com.example.vitalii.lab2.util.AlreadyLocalDB

class SearchPresenter(
        private val mSearchView:SearchView
){
    lateinit var mListOfImages:List<Image>

    fun loadData(context: Context){
        mListOfImages=AlreadyLocalDB.getImagesFromLocalDb(context)
        mSearchView.setDataToAdapter(mListOfImages)
    }

    fun searchImage(name:String){
        for(item in mListOfImages){
            if (item.imageName==name){
                mSearchView.goToItemPosition(item.imageId -1)
            }
        }
    }
}