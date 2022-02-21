package com.example.facebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.facebook.model.Feed
import com.example.facebook.model.Story
import com.example.instagram.R
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapterLight (var context: Context, var items:ArrayList<Feed>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
            return if (feed.stories.size >0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      if (viewType == TYPE_ITEM_STORY){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story_light, parent, false)
        return StoryViewHolder(context,view)
      }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_light, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder){
            var recyclerView =holder.recyclerView
           refreshAdapter(feed.stories, recyclerView)
        }
        if (holder is PostViewHolder){
            var iv_profile =holder.iv_profile
            var photo =holder.photo
            var tv_fullname =holder.tv_fullname

//            Glide.with(context).load(feed.post?.profile)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .into(iv_profile);
//            Glide.with(context).load(feed.post?.photo)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .into(photo);

            iv_profile.setImageResource(feed.post!!.profile)
            photo.setImageResource(feed.post!!.photo)
            tv_fullname.text = feed.post!!.fullname
        }

    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView:RecyclerView) {
        val adapter = StoryAdapterLight(context, stories)
        recyclerView.adapter = adapter
    }

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view){
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false )
        }

    }
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var photo: ImageView = view.findViewById(R.id.iv_photo)
        var iv_comment: ImageView = view.findViewById(R.id.iv_comment)
        var iv_like: ImageView = view.findViewById(R.id.iv_like)
        var iv_save: ImageView = view.findViewById(R.id.iv_save)
        var iv_send: ImageView = view.findViewById(R.id.iv_send)
        var tv_caption: TextView = view.findViewById(R.id.tv_caption)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
}