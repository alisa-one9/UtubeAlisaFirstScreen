package com.example.myutuuubalisa.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myutuuubalisa.R
import com.example.myutuuubalisa.databinding.ItemPlaylistBinding
import com.example.myutuuubalisa.extensions.load
import com.example.myutuuubalisa.model.Items
import com.example.myutuuubalisa.model.PlayList

class PlayListAdapter(
   // private val clickListener: (id: String, title: String, description: String, itemCount: String) -> Unit,
    private val playList: PlayList,
    private  val listener: OnClickItem
) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent,false),listener)


    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.onBind(playList.items[position])
    }

    override fun getItemCount() = playList.items.size


inner class ViewHolder(private  val containerView:ItemPlaylistBinding ,var listener:OnClickItem,) :
    RecyclerView.ViewHolder(containerView.root) {

    fun onBind(playList: Items) {
       containerView.tvPlaylistTitle.text = playList.snippet.title
       containerView.tvDesc.text = playList.snippet.description
        containerView.ivPlaylist.load(playList.snippet.thumbnails.default.url)

        containerView.tvPlaylistVideoCounter.text =
            String.format(
                playList.contentDetails.itemCount.toString() + " "
                        + itemView.context.getString(R.string.video_series)
            )
    }
}


interface OnClickItem  {
    fun onPLayListItemClick(id: String)
}


}
