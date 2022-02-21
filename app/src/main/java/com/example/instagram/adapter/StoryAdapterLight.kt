package com.example.facebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.facebook.model.Story
import com.example.instagram.R
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapterLight(var context: Context, var items:ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view_light, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder){
            var iv_profile =holder.iv_profile
            var tv_fullname =holder.tv_fullname

//            Glide.with(context).load(feed.profile)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .into(iv_profile);
            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname
        }
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
         var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
}