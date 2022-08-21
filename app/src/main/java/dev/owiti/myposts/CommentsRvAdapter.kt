package dev.owiti.myposts


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.owiti.myposts.databinding.CommentsListItemBinding



class CommentsRvAdapter(var commentList: List<Comment>):
    RecyclerView.Adapter<CommentViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding =
            CommentsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding){
            tvPostId.text = currentComment.postId.toString()
            tvIds.text = currentComment.Id
            tvName.text = currentComment.name
            tvEmail.text = currentComment.email
            tvBody2.text = currentComment.body


        }

    }

    override fun getItemCount(): Int {
        return commentList.size

    }

}
class CommentViewHolder( var binding : CommentsListItemBinding):RecyclerView.ViewHolder(binding.root){

}