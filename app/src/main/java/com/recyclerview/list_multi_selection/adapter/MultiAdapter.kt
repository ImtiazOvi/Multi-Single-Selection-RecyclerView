package com.recyclerview.list_multi_selection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.list_multi_selection.R
import com.recyclerview.list_multi_selection.model.Model

class MultiAdapter(context: Context, private var datas: List<Model>) :
    RecyclerView.Adapter<MultiAdapter.MultiViewHolder>() {

    var onClick: OnItemClickListener? = null

    fun setOnItemClickLitener(mOnItemClickLitener: OnItemClickListener?) {
        this.onClick = mOnItemClickLitener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MultiViewHolder(view)
    }


    override fun getItemCount(): Int {
        return datas.size
    }


    override fun onBindViewHolder(holder: MultiViewHolder, position: Int) {
        val viewHolder: MultiViewHolder = holder
        val model = datas[position]
        val name = model.title
        viewHolder.txtItemName.text = name

        viewHolder.itemView.isSelected = model.isSelect
        if (onClick != null) viewHolder.itemView.setOnClickListener {
            model.isSelect = !model.isSelect
            notifyDataSetChanged()
            onClick!!.onItemClick(model)
        }
    }


    interface OnItemClickListener {
        fun onItemClick(model: Model)
    }


    inner class MultiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtItemName: TextView = itemView.findViewById(R.id.txt_item_name)
    }


}