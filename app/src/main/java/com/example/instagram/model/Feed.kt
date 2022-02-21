package com.example.facebook.model

import com.example.instagram.model.Photo

class Feed {
    var post: Post? = null
    var stories:ArrayList<Story> = ArrayList<Story>()


    constructor(){
    }
    constructor(post: Post){
        this.post= post
    }
    constructor(stories: ArrayList<Story>){
        this.stories = stories
    }
}