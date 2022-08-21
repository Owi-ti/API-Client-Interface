package dev.owiti.myposts



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.owiti.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommentsActivity : AppCompatActivity() {
    lateinit var  binding: ActivityCommentsBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        setupToolBar()
        fetchCommentsById()
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostById() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    binding.tvPostTitle.text = post?.title
                    binding.tvPostBody.text = post?.body

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun fetchCommentsById () {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getComments()
        request.enqueue(object : Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if ( response.isSuccessful) {
                    val comment = response.body()
                    if (comment != null) {
                        displayComments(comment)

                    }
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayComments (commentList: List<Comment>) {
        binding.rcvComment.layoutManager = LinearLayoutManager(this)
        val commentsadapter = CommentsRvAdapter(commentList)
        binding.rcvComment.adapter = commentsadapter
    }
    fun setupToolBar() {
        setSupportActionBar(binding.toolbarComment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
