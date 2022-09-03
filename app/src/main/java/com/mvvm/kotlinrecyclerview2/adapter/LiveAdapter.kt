package com.mvvm.kotlinrecyclerview2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mvvm.kotlinrecyclerview2.R
import com.mvvm.kotlinrecyclerview2.model.Live
import kotlinx.android.synthetic.main.res_item_list.view.*

class LiveAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is LiveViewHolder ->{
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(lives : List<Live>){
        this.items = lives
    }

    class LiveViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live: Live){
            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(live.thumbnailUrl)
                .into(liveThumbnail)

        }
    }
}