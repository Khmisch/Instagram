package com.example.instagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.instagram.R
import com.example.instagram.model.Photo
import java.util.*


class ViewPagerAdapter() : PagerAdapter() {
    // Layout Inflater
    lateinit var context: Context
    lateinit var items: ArrayList<Photo>
    var mLayoutInflater: LayoutInflater? = null
    constructor(context: Context, items: ArrayList<Photo>) : this() {
        this.context = context;
        this.items = items;
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }

    override fun getCount(): Int {
        // return the number of images
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var images = items[position]
        // inflating the item.xml
        val itemView: View = mLayoutInflater!!.inflate(R.layout.item_feed_post_multi_view, container, false)
        // referencing the image view from the item.xml file
        val imageView = itemView.findViewById<View>(R.id.iv_photo) as ImageView
        // setting the image in the imageView
        imageView.setImageResource(images.photo)
        // Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout?)
    }
}