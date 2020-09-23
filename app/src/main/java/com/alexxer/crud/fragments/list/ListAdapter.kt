package com.alexxer.crud.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexxer.crud.R
import com.alexxer.crud.data.User
import kotlinx.android.synthetic.main.custom_rv_item.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.itemView.id_tv.text = currentUser.id.toString()
        holder.itemView.firstName_tv.text = currentUser.firstName
        holder.itemView.lastName_tv.text = currentUser.lastName
        holder.itemView.age_tv.text = currentUser.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size

    }

    fun setData(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }
}