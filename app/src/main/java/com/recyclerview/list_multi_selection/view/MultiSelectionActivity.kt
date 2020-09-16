package com.recyclerview.list_multi_selection.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerview.list_multi_selection.adapter.MultiAdapter
import com.recyclerview.list_multi_selection.R
import com.recyclerview.list_multi_selection.model.Model
import kotlinx.android.synthetic.main.activity_list.*

class MultiSelectionActivity : AppCompatActivity() {

    var datas = mutableListOf<Model>()
    val selectDatas = mutableListOf<Model>()
    private var multipleAdapter: MultiAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        loadData()

        rv_list.setHasFixedSize(true)
        rv_list.layoutManager = LinearLayoutManager(this)
        multipleAdapter = MultiAdapter(this, datas)
        rv_list.adapter = multipleAdapter


        multipleAdapter!!.setOnItemClickLitener(object : MultiAdapter.OnItemClickListener {
            override fun onItemClick(model: Model) {
                if (model.isSelect) {
                    selectDatas.add(model)
                } else {
                    selectDatas.remove(model)
                }
            }

        })
    }


    private fun loadData() {
        datas = ArrayList()
        for (i in 0..19) {
            datas.add(Model("Multi selection item $i"))
        }
    }
}