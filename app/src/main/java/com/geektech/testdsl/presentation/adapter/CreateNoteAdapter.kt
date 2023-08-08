package com.geektech.testdsl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.testdsl.databinding.ItemNoteBinding
import com.geektech.testdsl.presentation.model.NoteUI

class CreateNoteAdapter(private val list: ArrayList<NoteUI>) :
    RecyclerView.Adapter<CreateNoteAdapter.CreateNoteViewHolder>() {

    var onItemClick: ((NoteUI) -> Unit)? = null
    var onItemLongClick: ((NoteUI) -> Unit)? = null

    inner class CreateNoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteUI: NoteUI) {
            binding.txtTitle.text = noteUI.title
            binding.txtNote.text = noteUI.description
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
            itemView.setOnLongClickListener {
                onItemLongClick?.invoke(list[adapterPosition])
                return@setOnLongClickListener true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateNoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreateNoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreateNoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}