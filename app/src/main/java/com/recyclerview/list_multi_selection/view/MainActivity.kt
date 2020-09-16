package com.recyclerview.list_multi_selection.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.recyclerview.list_multi_selection.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        single_selection.setOnClickListener(onClickListener)
        multi_selection.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.single_selection -> {
                Intent(this, SingleSelectionActivity::class.java).run {
                    startActivity(this)
                }
            }

            R.id.multi_selection -> {
                Intent(this, MultiSelectionActivity::class.java).run {
                    startActivity(this)
                }
            }

        }

    }
}
