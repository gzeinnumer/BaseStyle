package com.gzeinnumer.basestyle

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor =
                ResourcesCompat.getColor(resources, android.R.color.transparent, null);
        }

        btn_nav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.id_next -> startActivity(Intent(applicationContext, ThirdActivity::class.java))
            }
            false
        }

//        val items = listOf("Material", "Design", "Components", "Android")
        val items = resources.getStringArray(R.array.planets_array)
        val myAdapter = ArrayAdapter(applicationContext, R.layout.mygzn_list_item, items)
        material_spinner_1.setAdapter(myAdapter)
        material_spinner_2.setAdapter(myAdapter)
        material_spinner_4.adapter = myAdapter
        material_spinner_5.adapter = myAdapter
    }
}
