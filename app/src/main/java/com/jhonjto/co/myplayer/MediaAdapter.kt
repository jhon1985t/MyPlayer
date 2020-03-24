package com.jhonjto.co.myplayer

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_media_item.view.*

/**
 * Created by jhon on 8/03/2020
 */
class MediaAdapter(private val items: List<MediaItem>, private val listener: (MediaItem) -> Unit) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_media_item))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.invoke(item) }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

/*        private var title = view.media_title
        private val image = view.findViewById<ImageView>(R.id.image)
        private val videoIndicator = find<ImageView>(R.id.media_video_indicator)*/

        fun bind(item: MediaItem) = with(itemView) {
/*            title = TextView(context).apply {
                text = "apply rules!"
                textSize = 20f
                setOnClickListener { toast("Yeah!") }
            }
            title.text = item.title
            image.loadUrl(item.thumbUrl)
            item.test(listOf(item))
            toast("toast from media adapter")
            videoIndicator.visibility = when (item.type) {
                MediaItem.Type.VIDEO -> View.VISIBLE
                MediaItem.Type.PHOTO -> View.GONE
            }*/
            media_title.text = item.title
            media_thumb.loadUrl(item.thumbUrl)
            media_video_indicator.visibility = when (item.type) {
                MediaItem.Type.VIDEO -> View.VISIBLE
                MediaItem.Type.PHOTO -> View.GONE
            }
        }
    }
}