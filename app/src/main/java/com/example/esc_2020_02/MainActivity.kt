package com.example.esc_2020_02

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        transparentStatusAndNavigation();

        button_sunny.setOnClickListener { window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
            sunny() }
        button_cloudy.setOnClickListener { window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
            cloudy() }
        button_rainy.setOnClickListener { window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
            rainy() }

    }

    private fun transparentStatusAndNavigation() {
        //make full transparent statusBar
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        setWindowFlag(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false
        )
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun sunny(){
        currunt_weather.text = "맑은 날"
        val pic = Random.nextInt(4)
        when (pic) {
            0 -> {
                background.setImageResource(R.drawable.sunny01)
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
            }
            1 -> background.setImageResource(R.drawable.sunny02)
            2 -> background.setImageResource(R.drawable.sunny03)
            else -> background.setImageResource(R.drawable.sunny04)
        }
    }

    public fun cloudy(){
        currunt_weather.text = "흐린 날"
        val pic = Random.nextInt(3)
        when (pic) {
            0 -> {
                background.setImageResource(R.drawable.cloudy01)
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
            }
            1 -> background.setImageResource(R.drawable.cloudy02)
            2 -> background.setImageResource(R.drawable.cloudy03)
        }
    }

    public fun rainy(){
        currunt_weather.text = "비오는 날"
        val pic = Random.nextInt(5)
        when (pic) {
            0 -> background.setImageResource(R.drawable.rainy01)
            1 -> background.setImageResource(R.drawable.rainy02)
            2 -> background.setImageResource(R.drawable.rainy03)
            3 -> background.setImageResource(R.drawable.rainy04)
            4 -> background.setImageResource(R.drawable.rainy05)
        }
    }
}