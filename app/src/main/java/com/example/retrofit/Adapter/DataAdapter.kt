package com.example.retrofit.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Model.Data
import com.example.retrofit.R

class DataAdapter(private val dataList : ArrayList<Data>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_list, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class DataViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val user_id : TextView = view.findViewById(R.id.user_id)
        private val id : TextView = view.findViewById(R.id.id)
        private val title : TextView = view.findViewById(R.id.title)
        private val body : TextView = view.findViewById(R.id.body)


        @SuppressLint("SetTextI18n")
        fun bind(dataList: Data){
            user_id.text ="User id : ${dataList.userId}"
            id.text  = "Id : ${dataList.id}"
            title.text = "Text: ${dataList.title}"
            body.text = "Body: ${dataList.body}"

        }
    }
}