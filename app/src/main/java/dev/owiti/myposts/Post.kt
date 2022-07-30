package dev.owiti.myposts

import android.icu.text.CaseMap

data class Post(
      var userId:Int,
      var id:Int,
      var title: String,
      var body:String,
)
data class  Comment(
    var postId:Int,
    var Id: String,
    var name:String,
    var email:String,
    var body:String,
)
