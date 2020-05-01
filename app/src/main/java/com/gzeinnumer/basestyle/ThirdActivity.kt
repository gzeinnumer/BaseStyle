package com.gzeinnumer.basestyle

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*


class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor =
                ResourcesCompat.getColor(resources, android.R.color.transparent, null);
        }

        btn_nav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.id_next -> startActivity(Intent(applicationContext, MainActivity::class.java))
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

    fun showPopup(v: View?) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.mygzn_bottom_nav, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.id_next -> startActivity(Intent(applicationContext, MainActivity::class.java))
            }
            false
        }
        popup.show()
    }
}
