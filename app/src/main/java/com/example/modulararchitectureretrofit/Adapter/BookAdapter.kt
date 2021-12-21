package com.example.modulararchitectureretrofit.Adapter

import android.content.Context
import android.content.Intent
import com.example.retrofitmodule.MainActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modulararchitectureretrofit.R
import com.example.modulararchitectureretrofit.newmodels.Data
import com.example.modulararchitectureretrofit.newmodels.Support
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookHolder>() {

    var dataAll: List<Data> = ArrayList<Data>()

    lateinit var context:Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {

        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        context = parent.context;
        return BookHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val currentData: Data = dataAll.get(position)
   //     val currentSupport: Support = supportAll.get(position)
        holder.emailTv.text = ("Email : "+currentData.email)
    //    holder.supportTv.text = ("Support : "+currentSupport.text)
        holder.firstName.text = ("Name : "+currentData.first_name +" "+currentData.last_name)

        holder.rv_layout.setOnClickListener {
            //Log.i("TAG", "onBindViewHolder: ")


           context.startActivity(Intent(context, MainActivity::class.java))


        }

        val uri: String = currentData.avatar
        Glide
            .with(holder.itemView.context)
            .load(uri)
            .centerCrop()
            .placeholder(R.drawable.loader)
            .into(holder.circularIv);
        // holder.authorTv.setText(currentBook.getAuthor())
    }

    override fun getItemCount(): Int {
        return dataAll.size
    }

    fun setdataList(data: List<Data>) {
        this.dataAll = data.toMutableList()
        notifyDataSetChanged()
    }


    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val emailTv = itemView.findViewById<TextView>(R.id.email_tv)
        val firstName = itemView.findViewById<TextView>(R.id.firstname_tv)
        val circularIv = itemView.findViewById<CircleImageView>(R.id.circulariv)
        val rv_layout = itemView.findViewById<RelativeLayout>(R.id.rv_layout)
      //  val supportTv = itemView.findViewById<TextView>(R.id.support_tv)

    }

}