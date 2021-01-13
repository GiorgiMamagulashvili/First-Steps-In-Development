package com.example.roomdatabase.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_tv.text = currentItem.id.toString()
        holder.itemView.name_tv.text = currentItem.firstName
        holder.itemView.last_name_tv.text = currentItem.lastName
        holder.itemView.age_tv.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}