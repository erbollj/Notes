package com.geektech.testdsl.presentation.ui.note

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.geektech.testdsl.R
import com.geektech.testdsl.base.BaseFragment
import com.geektech.testdsl.databinding.FragmentCreateNoteBinding
import com.geektech.testdsl.domain.model.NoteDomain
import com.geektech.testdsl.presentation.adapter.CreateNoteAdapter
import com.geektech.testdsl.presentation.model.NoteUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment<FragmentCreateNoteBinding, CreateNoteViewModel>() {

    override val viewModel: CreateNoteViewModel by viewModels()

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentCreateNoteBinding {
        return FragmentCreateNoteBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {

        val list = ArrayList<NoteUI>()
        val adapter = CreateNoteAdapter(list)

        viewModel.getAllNotes()

        setFragmentResultListener("key") { _, bundle ->
            val title = bundle.getString("keyOne")
            val description = bundle.getString("keyTwo")
            viewModel.addNote(
                NoteDomain(
                    title = title.toString(),
                    description = description.toString()
                )
            )
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_createNoteFragment_to_secondFragment)
        }

        viewModel.addNote.subscribe(
            {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            },
            {
                // TODO loading
            },
            {
                viewModel.getAllNotes()
            }
        )

        viewModel.getAllNotes.subscribe(
            {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            },
            {
                // TODO loading
            },
            {
                Log.e("ololo", "initView: $it")
                list.removeAll(it.toSet())
                list.addAll(it)

                binding.recycler.adapter = adapter
                adapter.onItemLongClick = { it ->
                    Toast.makeText(requireActivity(), it.title, Toast.LENGTH_SHORT).show()
                    list.remove(it)
                    adapter.notifyDataSetChanged()
                    viewModel.delete(NoteDomain(it.id, it.description, it.title))
                    Log.e("ololo", "initView: " + it.id)
                }

            }
        )

        viewModel.delete.subscribe(
            {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            },
            {
                // TODO loading
            },
            {
            }
        )

    }

    override fun initListener() {
    }
}








