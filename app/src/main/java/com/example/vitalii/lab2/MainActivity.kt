package com.example.vitalii.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.vitalii.lab2.searchImage.SearchFragment
import com.example.vitalii.lab2.splash.SplashFragment
import com.example.vitalii.lab2.splash.SplashView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(SplashFragment())
    }

    fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment)
            commit()
        }
    }

    fun showToastMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }


}
