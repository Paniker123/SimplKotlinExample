package com.example.vitalii.lab2.splash

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitalii.lab2.MainActivity
import com.example.vitalii.lab2.R
import com.example.vitalii.lab2.searchImage.SearchFragment

class SplashFragment:Fragment(),SplashView{

    lateinit var mPresenter:SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter= SplashPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.preload(context!!)
    }

    override fun showToastMessage(message: String) {
        (activity as MainActivity).showToastMessage(message)
    }

    override fun moveToNext() {
        (activity as MainActivity).showFragment(SearchFragment())
    }


}