package com.papillionotelandspa.spash_screen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_diger.*
import kotlinx.android.synthetic.main.activity_diger.view.*

class DigerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diger)

        toolbar.setBackgroundColor(Color.LTGRAY)
        toolbar.title="Personel İşlemleri"
        toolbar.setTitleTextColor(Color.rgb(82,26,1))

        val nav_host_fragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(navigation_view,nav_host_fragment.navController)

        val toggle=ActionBarDrawerToggle(this,drawer,toolbar,0,0)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val baslik=navigation_view.inflateHeaderView(R.layout.yan_menu_baslik)

    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

}