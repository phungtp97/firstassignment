package com.example.macintoshhd.kotlinfirstapp.base


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.macintoshhd.kotlinfirstapp.R
import com.example.macintoshhd.kotlinfirstapp.`object`.Post


class PostRecyclerViewAdapter(listPosts: List<Post>, listener: ClickMoreListener) : RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>() {

    open interface ClickMoreListener{
        fun OnClickMore()
    }

    private var mListener: ClickMoreListener = listener
    private var mListPost: List<Post> = listPosts

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_comment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postItem = mListPost.get(position)
        holder.tvName.text = postItem.user!!.name
        holder.tvRole.text = postItem.user!!.role
        holder.tvComment.text = postItem.comment
        holder.tvAvgScore.text = "AVG: "+((postItem.authentic + postItem.clear + postItem.passionate + postItem.timing)/4)
        if(postItem.user!!.current==true) {
            holder.btnOpenBottomSheer.visibility = View.VISIBLE
            holder.btnOpenBottomSheer.setOnClickListener {
                mListener.OnClickMore()
            }
        }
    }

    override fun getItemCount(): Int {
        var num: Int = 0;
        if(mListPost.isNotEmpty()){
            num = mListPost.size
        }
        return num
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val btnOpenBottomSheer: ImageView = itemView.findViewById(R.id.row_comment_iv_more)
        val tvName: TextView = itemView.findViewById(R.id.row_comment_tv_username)
        val tvRole: TextView = itemView.findViewById(R.id.row_comment_tv_role)
        val tvComment: TextView = itemView.findViewById(R.id.row_comment_tv_comment)
        val tvAvgScore: TextView = itemView.findViewById(R.id.row_comment_tv_avgscore)
    }
}
