package com.kurt.draftapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kurt.draftapp.base.BaseAdapter
import com.kurt.draftapp.base.BaseHolder
import com.kurt.draftapp.data.model.Track
import com.kurt.draftapp.databinding.TrackItemBinding

class TrackListAdapter(private val onClickAction: ((Track) -> Unit)) :
    BaseAdapter<Track, TrackItemBinding, TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TrackViewHolder {
        return TrackViewHolder(
            TrackItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClickAction
        )
    }
}

class TrackViewHolder(
    viewBinding: TrackItemBinding,
    private val onClickAction: (Track) -> Unit
) :
    BaseHolder<Track, TrackItemBinding>(viewBinding) {

    override fun bind(binding: TrackItemBinding, item: Track?) {
        item?.let { trackData ->
            binding.apply {
                track = trackData
                cvParent.setOnClickListener {
                    onClickAction.invoke(trackData)
                }
            }
        } ?: return
    }
}