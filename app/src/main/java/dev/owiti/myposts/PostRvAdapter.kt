package dev.owiti.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.owiti.myposts.databinding.PostListItemBinding

class PostRvAdapter(var postList:List<Post>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding= PostListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        with(holder.binding){
            tvUserId.text=currentPost.userId.toString()
            tvId.text=currentPost.id.toString()
            tvTitle.text=currentPost.title
            tvBody.text=currentPost.body
            holder.binding.cvPost.setOnClickListener {
                var context = holder.itemView.context
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID", currentPost.id)
                context.startActivity(intent)

            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}


class PostViewHolder(var binding:PostListItemBinding):RecyclerView.ViewHolder(binding.root){}