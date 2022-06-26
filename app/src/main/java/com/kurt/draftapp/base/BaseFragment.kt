package com.kurt.draftapp.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kurt.draftapp.ui.activities.MainActivity
import com.kurt.draftapp.utilities.Utils
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    private val inflate: Inflate<VB>
) : Fragment() {
    @Inject
    lateinit var utils: Utils

    private var _binding: VB? = null
    val binding get() = _binding!!

    protected abstract val viewModel: VM

    // Activity
    private val mainActivity: MainActivity? by lazy {
        activity as? MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupVM()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected open fun setupUI() = Unit

    protected open fun setupVM() {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            mainActivity?.errorMessageToast(it)
        }

        viewModel.alertMessage.observe(viewLifecycleOwner) {
            mainActivity?.messageAlert(it)
        }

        viewModel.isProgress.observe(viewLifecycleOwner) {
            mainActivity?.progressLoading(it)
        }
    }

    fun openInBrowser(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}