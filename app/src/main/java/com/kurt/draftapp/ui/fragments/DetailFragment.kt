package com.kurt.draftapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.kurt.draftapp.base.BaseFragment
import com.kurt.draftapp.data.model.Track
import com.kurt.draftapp.databinding.DetailFragmentBinding
import com.kurt.draftapp.viewmodel.DetailViewModel

class DetailFragment : BaseFragment<DetailFragmentBinding,DetailViewModel>(
    DetailFragmentBinding::inflate
) {
    override val viewModel: DetailViewModel by viewModels()
    private var trackData: Track? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackData = it.getSerializable("TrackData") as Track

        }
    }

    override fun setupUI() {
        super.setupUI()
        binding.track = trackData
    }

}