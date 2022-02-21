package com.example.facebook.model

import com.example.instagram.model.Photo

class Post {

    var profile:Int = 0
    lateinit var fullname:String
    var photo:Int = 0
    lateinit var viewPager:ArrayList<Photo>
    var isVideo:Boolean = false
    var isMulti:Boolean = false
    lateinit var video:String


    constructor(profile:Int, fullname:String, photo:Int){
        this.profile= profile
        this.fullname= fullname
        this.photo= photo
    }
    constructor(profile:Int, fullname:String, viewPager:ArrayList<Photo>, isMulti:Boolean){
        this.profile= profile
        this.fullname= fullname
        this.viewPager= viewPager
        this.isMulti= isMulti
    }
    constructor(profile:Int, fullname:String, video:String, isVideo:Boolean){
        this.profile= profile
        this.fullname= fullname
        this.video= video
        this.isVideo= isVideo
    }
}