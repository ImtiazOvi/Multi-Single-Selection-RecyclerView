package com.recyclerview.list_multi_selection.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerview.list_multi_selection.R
import com.recyclerview.list_multi_selection.adapter.SingleAdapter
import kotlinx.android.synthetic.main.activity_list.*

class SingleSelectionActivity : AppCompatActivity() {

    private val datas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        loadData()

        rv_list.layoutManager = LinearLayoutManager(this)
        val singleAdapter = SingleAdapter(this, datas)
        rv_list.adapter = singleAdapter

        singleAdapter.setOnItemClickLitener(object : SingleAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                singleAdapter.setSelection(position)
            }

        })
    }

    private fun loadData() {
        for (i in 0..19) {
            datas.add("Single selection item $i")
        }
    }

}