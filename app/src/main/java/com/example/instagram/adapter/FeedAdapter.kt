package com.example.facebook.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.facebook.model.Feed
import com.example.facebook.model.Story
import com.example.instagram.R
import com.example.instagram.adapter.ViewPagerAdapter
import com.example.instagram.model.Photo
import com.google.android.material.imageview.ShapeableImageView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class FeedAdapter(var context: Context, var items:ArrayList<Feed>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_POST_ADD = 3
    private val TYPE_ITEM_POST_MULTI = 4
    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
            if (feed.stories.size >0)
                return TYPE_ITEM_STORY
            else if (feed.post!!.isVideo)
                return TYPE_ITEM_POST_ADD
            else if (feed.post!!.isMulti)
                return TYPE_ITEM_POST_MULTI
        return TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      if (viewType == TYPE_ITEM_STORY){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
        return StoryViewHolder(context,view)
      }else if (viewType == TYPE_ITEM_POST_ADD) {
          val view = LayoutInflater.from(parent.context)
              .inflate(R.layout.item_feed_post_advertisement, parent, false)
          return PostViewHolderADD(view)
      }else if (viewType == TYPE_ITEM_POST_MULTI){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_multi, parent, false)
        return PostViewHolderMulti(context,view)
      }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
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

            iv_profile.setImageResource(feed.post!!.profile)
            photo.setImageResource(feed.post!!.photo)
            tv_fullname.text = feed.post!!.fullname
        }
        if (holder is PostViewHolderMulti){
            var iv_profile =holder.iv_profile
            var dotsIndicator =holder.dotsIndicator
            var viewPager =holder.viewPager
            var tv_fullname =holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            tv_fullname.text = feed.post!!.fullname
            // Adding the Adapter to the ViewPager
            refreshAdapterPost(feed!!.post!!.viewPager, viewPager)
            // set adapter
            dotsIndicator.setViewPager(viewPager)
        }
        if (holder is PostViewHolderADD){
            var iv_profile =holder.iv_profile
            var videoView =holder.videoView
            var tv_fullname =holder.tv_fullname


            val uri: Uri = Uri.parse(feed.post!!.video)
            videoView.setVideoURI(uri)
            val mediaController = MediaController(context)
            mediaController.setAnchorView(videoView)
            mediaController.setMediaPlayer(videoView)
//            videoView.setMediaController(mediaController)
            videoView.clipToOutline = true
            videoView.start()

            iv_profile.setImageResource(feed.post!!.profile)
            videoView.setVideoPath(feed.post!!.video)
            tv_fullname.text = feed.post!!.fullname
        }

    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView:RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }
    private fun refreshAdapterPost(photo: ArrayList<Photo>, viewPager:ViewPager) {
        val adapter = ViewPagerAdapter(context, photo)
        viewPager.adapter = adapter
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
    class PostViewHolderMulti(context: Context,view: View) : RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var viewPager: ViewPager = view.findViewById(R.id.viewPager)
        var dotsIndicator: WormDotsIndicator = view.findViewById(R.id.dots_indicator)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
    class PostViewHolderADD(view: View) : RecyclerView.ViewHolder(view){

        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var videoView: VideoView = view.findViewById(R.id.videoView)
        var iv_comment: ImageView = view.findViewById(R.id.iv_comment)
        var iv_like: ImageView = view.findViewById(R.id.iv_like)
        var iv_save: ImageView = view.findViewById(R.id.iv_save)
        var iv_send: ImageView = view.findViewById(R.id.iv_send)
        var tv_caption: TextView = view.findViewById(R.id.tv_caption)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
}