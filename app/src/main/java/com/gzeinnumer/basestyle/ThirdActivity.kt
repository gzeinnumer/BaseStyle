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
import com.tiper.MaterialSpinner
import kotlinx.android.synthetic.main.activity_main.*


class ThirdActivity : AppCompatActivity() {

    private val listener by lazy {
        object : MaterialSpinner.OnItemSelectedListener {
            override fun onItemSelected(
                parent: MaterialSpinner,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v("MaterialSpinner", "onItemSelected parent=${parent.id}, position=$position")
                when (parent) {
                    material_spinner_1 -> {
                        Log.v("MaterialSpinner", "material_spinner_1")
                    }
                    material_spinner_2 -> {
                        Log.v("MaterialSpinner", "material_spinner_2")
                    }
                    material_spinner_3 -> {
                        Log.v("MaterialSpinner", "material_spinner_3")
                    }
                    material_spinner_4 -> {
                        Log.v("MaterialSpinner", "material_spinner_4")
                    }
                    material_spinner_5 -> {
                        Log.v("MaterialSpinner", "material_spinner_5")
                    }
                }
            }

            override fun onNothingSelected(parent: MaterialSpinner) {
                Log.v("MaterialSpinner", "onNothingSelected parent=${parent.id}")
            }
        }
    }

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
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            R.layout.mygzn_simple_spinner_item
        ).let {
            it.setDropDownViewResource(R.layout.mygzn_spinner_dropdown_item)
            material_spinner_1.apply {
                adapter = it
                onItemSelectedListener = listener
                onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                    Log.v("MaterialSpinner", "onFocusChange hasFocus=$hasFocus")
                }
            }
            material_spinner_2.apply {
                adapter = it
                onItemSelectedListener = listener
            }
            material_spinner_3.apply {
                adapter = it
                onItemSelectedListener = listener
                selection = 3
                setDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.mygzn_arrow_downward,
                        theme
                    )
                )
            }
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            R.layout.mygzn_simple_spinner_item
        ).let {
            it.setDropDownViewResource(R.layout.mygzn_spinner_dropdown_item)
            material_spinner_4.adapter = it
            material_spinner_5.adapter = it
        }
        material_spinner_1.let {

        }
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
