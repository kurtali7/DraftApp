package com.kurt.draftapp.ui.activities

import android.view.View
import android.widget.Toast
import com.kurt.draftapp.R
import com.kurt.draftapp.base.BaseActivity
import com.kurt.draftapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun errorMessageToast(message: String?) = Toast.makeText(
        this,
        message ?: getString(R.string.error_message),
        Toast.LENGTH_SHORT
    ).show()

    fun messageAlert(message: String?) = Toast.makeText(
        this,
        message ?: getString(R.string.error_message),
        Toast.LENGTH_SHORT
    ).show()

    fun progressLoading(isVisible: Boolean) {
        binding.progressbar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}