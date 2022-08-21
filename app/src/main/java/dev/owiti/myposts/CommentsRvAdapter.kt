package dev.owiti.myposts


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.owiti.myposts.databinding.CommentsListItemBinding




class CommentsRvAdapter(var commentsList: List<Comment>):
    RecyclerView.Adapter<CommentViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding =
            CommentsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentsList.get(position)
        holder.binding.tvPostId.text = currentComment.postId.toString()
        holder.binding.tvIds.text = currentComment.Id.toString()
        holder.binding.tvName.text = currentComment.name
        holder.binding.tvEmail.text = currentComment.email
        holder.binding.tvBody2.text = currentComment.body


    }

    override fun getItemCount(): Int {
        return commentsList.size

    }

}
class CommentViewHolder( var binding : CommentsListItemBinding):RecyclerView.ViewHolder(binding.root){

}