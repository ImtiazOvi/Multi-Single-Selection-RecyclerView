package com.recyclerview.list_multi_selection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.list_multi_selection.R

class SingleAdapter(context: Context, private var datas: List<String>) :
    RecyclerView.Adapter<SingleAdapter.SingleViewHolder>() {

    private var selected = -1

    var onClick: OnItemClickListener? = null

    fun setOnItemClickLitener(mOnItemClickListener: OnItemClickListener) {
        this.onClick = mOnItemClickListener
    }

    fun setSelection(position: Int) {
        selected = position
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return SingleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {
        val name = datas[position]
        holder.txtItemName.text = name
        holder.itemView.isSelected = selected == position
        if (onClick != null) {
            holder.itemView.setOnClickListener {
                onClick!!.onItemClick(
                    holder.itemView,
                    holder.adapterPosition
                )
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }


    inner class SingleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtItemName: TextView = itemView.findViewById(R.id.txt_item_name)
    }

}
