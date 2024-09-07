package com.kel.k_todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter ( private val tasks: List<Task>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameLayoutTask)
        val descTextView: TextView = itemView.findViewById(R.id.descLayoutTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewTasks = LayoutInflater.from(parent.context).inflate(R.layout.tasks_layout_itens, parent, false)
        return ViewHolder(viewTasks)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]

        holder.nameTextView.text = task.name
        holder.descTextView.text =  task.description

    }

    override fun getItemCount(): Int {
        return tasks.size
    }


}


