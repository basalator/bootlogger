package com.example.feature.bootrecordslist

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BootRecordsFragment: Fragment(R.layout.fragment_boot_records) {

    private val viewModel: BootRecordsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recordsAdapter = Adapter(requireContext())
        val emptyView = view.findViewById<TextView>(R.id.empty_list_text_view)
        view.findViewById<RecyclerView>(R.id.recyclerView)?.apply {
            adapter = recordsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        // TODO hide test button
        view.findViewById<TextView>(R.id.button_add)?.setOnClickListener {
            viewModel.add()
        }

        viewModel.items.observe(viewLifecycleOwner) {
            it ?: return@observe
            recordsAdapter.submitList(it)
            emptyView.isVisible = it.isEmpty()
        }

        // TODO add interval controls
    }

}