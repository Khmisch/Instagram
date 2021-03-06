package com.example.instagram.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.adapter.FeedAdapter
import com.example.facebook.model.Feed
import com.example.facebook.model.Post
import com.example.facebook.model.Story
import com.example.instagram.R
import com.example.instagram.model.Photo

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var iv_camera: ImageView
    var videoUrl = "https://ak.picdn.net/shutterstock/videos/1074496190/preview/stock-footage-extreme-close-up-shot-of-good-looking-caucasian-young-blond-woman-puts-skin-care-serum-on-her-cheek.webm"
    var videoUrl_2 = "https://ak.picdn.net/shutterstock/videos/31063246/preview/stock-footage-animation-dental-brackets-and-tooth-implant-d-render.webm"
    var videoUrl_3 = "https://ak.picdn.net/shutterstock/videos/1056250001/preview/stock-footage-using-a-personal-tablet-computer-devise-to-shop-for-clothes-on-an-online-website-montreal-canada.webm"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshFeedAdapter(getAllFeeds())
        iv_camera = findViewById(R.id.iv_camera)
        iv_camera.setOnClickListener( View.OnClickListener{
            callMainActivityLight()
        })


    }

    private fun callMainActivityLight() {
        var intent = Intent(this, MainActivityLight::class.java)
        startActivity(intent)
    }


    private fun refreshFeedAdapter(allFeeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, allFeeds)
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

        val photo: ArrayList<Photo> = ArrayList<Photo>()
        photo.add(Photo(R.drawable.im_post_1))
        photo.add(Photo(R.drawable.im_post_2))
        photo.add(Photo(R.drawable.im_post_3))


        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_doctor, "Dental Treatment", videoUrl_2, true)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Begzodbek", photo, true)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_4, "Firdavsbek", R.drawable.im_post_1)))
        feeds.add(Feed(Post(R.drawable.im_add_1, "Men's Clothes", videoUrl_3, true)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Begzodbek", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_add_1, "Face Yoga", videoUrl, true)))
        feeds.add(Feed(Post(R.drawable.im_user_4, "Firdavsbek", R.drawable.im_post_1)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))



        return feeds;
    }
}