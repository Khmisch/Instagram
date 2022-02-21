package com.example.instagram.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.adapter.FeedAdapter
import com.example.facebook.adapter.FeedAdapterLight
import com.example.facebook.model.Feed
import com.example.facebook.model.Post
import com.example.facebook.model.Story
import com.example.instagram.R

class MainActivityLight : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var iv_camera: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_light)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        refreshFeedAdapter(getAllFeeds())

        iv_camera = findViewById(R.id.iv_camera)
        iv_camera.setOnClickListener( View.OnClickListener{
            finish()
        })
    }


    private fun refreshFeedAdapter(allFeeds: ArrayList<Feed>) {
        val adapter = FeedAdapterLight(this, allFeeds)
        recyclerView!!.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList<Story>()
        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))
        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))

        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Begzodbek", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_4, "Firdavsbek", R.drawable.im_post_1)))

        return feeds;
    }
}