package com.kurt.draftapp.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kurt.draftapp.R
import com.kurt.draftapp.adapters.TrackListAdapter
import com.kurt.draftapp.base.BaseFragment
import com.kurt.draftapp.data.model.Track
import com.kurt.draftapp.databinding.HomeFragmentBinding
import com.kurt.draftapp.utilities.observe
import com.kurt.draftapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import segmented_control.widget.custom.android.com.segmentedcontrol.item_row_column.SegmentViewHolder

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeFragmentBinding, HomeViewModel>(HomeFragmentBinding::inflate) {

    override val viewModel: HomeViewModel by viewModels()
    private val listAdapter = TrackListAdapter(::onClickAction)

    override fun setupUI() {
        super.setupUI()
        observe()
        createAdapter()
        viewModel.searchTrack()

        context?.resources?.getStringArray(R.array.categories)
            ?.indexOf(viewModel.mediaType)
            ?.let {
                binding.segmentedCategories.setSelectedSegment(
                    it
                )
            }

        binding.editTextTerm.setText(viewModel.term)

        binding.segmentedCategories.addOnSegmentClickListener { segmentViewHolder: SegmentViewHolder<*> ->
            viewModel.mediaType = context?.resources?.getStringArray(
                R.array.categories
            )?.get(segmentViewHolder.absolutePosition).toString()

            viewModel.searchTrack()
        }

        binding.editTextTerm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.term = p0.toString()
                viewModel.searchTrack()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    private fun createAdapter() {
        binding.recyclerViewTrack.adapter = listAdapter
    }

    private fun observe() {
        observe(viewModel.trackList, ::setDataList)
    }

    private fun setDataList(data: ArrayList<Track>) {
        listAdapter.replaceData(data)
    }

    private fun onClickAction(track: Track) {
        val bundle = Bundle()
        bundle.putSerializable("TrackData", track)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}