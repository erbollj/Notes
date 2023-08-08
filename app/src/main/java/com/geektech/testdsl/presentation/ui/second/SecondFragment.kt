package com.geektech.testdsl.presentation.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.geektech.testdsl.R
import com.geektech.testdsl.base.BaseFragment
import com.geektech.testdsl.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondViewModel>() {

    override val viewModel: SecondViewModel by viewModels()

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        binding.btnAdd.setOnClickListener {
            val description = binding.etDescription.text.toString()
            val title = binding.etTitle.text.toString()
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_secondFragment_to_createNoteFragment)
            setFragmentResult("key", bundleOf("keyTwo" to description, "keyOne" to title))
        }
    }

    override fun initListener() {
    }

}