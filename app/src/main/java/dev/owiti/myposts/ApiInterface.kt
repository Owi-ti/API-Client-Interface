package dev.owiti.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPost(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") postId:Int): Call<Post>

    @GET("/comment")
    fun getComments(): Call<List<Comment>>



}