package com.example.vitalii.lab2.splash

import android.content.Context
import com.example.vitalii.lab2.util.AlreadyLocalDB
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashPresenter(
        private val mSplashView:SplashView
){
    companion object {
        val TIME_WAIT=1000L
    }
    fun preload(context: Context){

                Single.timer(TIME_WAIT,TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {AlreadyLocalDB.insertToPreferenceImages(context)
                                mSplashView.moveToNext()},
                                {
                                    mSplashView.showToastMessage("Some problem with app!!! Restart App!!!")
                        })


    }
}