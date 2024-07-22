package com.example.feature.bootrecordslist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class Adapter(
    context: Context
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private val items = mutableListOf<Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Item>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflater.inflate(R.layout.item_boot_record, parent, false))

    override fun getItemCount(): Int = items.size

    data class Item(
        val id: String,
        val date: LocalDate,
        val count: Long,
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private val valueTextView: TextView = itemView.findViewById(R.id.value_text_view)
        private val dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
        fun bind(record: Item) {
            titleTextView.text = dateFormat.format(record.date)
            valueTextView.text = record.count.toString()
        }
    }
}