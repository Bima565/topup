package com.example.topupgame

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransaksiFragment : Fragment() {

    private lateinit var rvTransaksi: RecyclerView
    private lateinit var adapter: TransaksiAdapter
    private lateinit var btnSemua: Button
    private lateinit var btnMenunggu: Button
    private lateinit var btnSelesai: Button

    private var currentFilter = "Menunggu Konfirmasi"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transaksi_fg, container, false)

        rvTransaksi = view.findViewById(R.id.rvTransaksi)
        btnSemua = view.findViewById(R.id.btnSemua)
        btnMenunggu = view.findViewById(R.id.btnMenunggu)
        btnSelesai = view.findViewById(R.id.btnSelesai)

        setupRecyclerView()
        setupTabs()
        scheduleStatusUpdates()

        return view
    }

    private fun setupRecyclerView() {
        rvTransaksi.layoutManager = LinearLayoutManager(context)
        adapter = TransaksiAdapter(emptyList())
        rvTransaksi.adapter = adapter
    }

    private fun setupTabs() {
        selectButton(btnMenunggu)
        updateAndFilterList()

        btnSemua.setOnClickListener {
            selectButton(btnSemua)
            currentFilter = "Semua"
            updateAndFilterList()
        }

        btnMenunggu.setOnClickListener {
            selectButton(btnMenunggu)
            currentFilter = "Menunggu Konfirmasi"
            updateAndFilterList()
        }

        btnSelesai.setOnClickListener {
            selectButton(btnSelesai)
            currentFilter = "Selesai"
            updateAndFilterList()
        }
    }

    private fun selectButton(selectedButton: Button) {
        val defaultColor = ContextCompat.getColor(requireContext(), R.color.default_tint)
        val activeColor = ContextCompat.getColor(requireContext(), R.color.active_tint)

        listOf(btnSemua, btnMenunggu, btnSelesai).forEach { button ->
            button.setTextColor(defaultColor)
            button.compoundDrawableTintList = ColorStateList.valueOf(defaultColor)
        }

        selectedButton.setTextColor(activeColor)
        selectedButton.compoundDrawableTintList = ColorStateList.valueOf(activeColor)
    }

    private fun scheduleStatusUpdates() {
        TransaksiRepository.riwayatTransaksi.forEach { transaksi ->
            if (transaksi.status == "Menunggu Konfirmasi") {
                // Jalankan proses menunggu di background thread (IO)
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    delay(10000L) // Tunggu 10 detik di background, tidak memblokir UI

                    // Setelah selesai, kembali ke Main thread untuk update UI
                    withContext(Dispatchers.Main) {
                        if (isAdded) { // Pastikan fragment masih ada
                            transaksi.status = "Selesai"
                            updateAndFilterList()
                        }
                    }
                }
            }
        }
    }

    private fun updateAndFilterList() {
        val listToShow = when (currentFilter) {
            "Menunggu Konfirmasi" -> TransaksiRepository.riwayatTransaksi.filter { it.status == "Menunggu Konfirmasi" }
            "Selesai" -> TransaksiRepository.riwayatTransaksi.filter { it.status == "Selesai" }
            else -> TransaksiRepository.riwayatTransaksi
        }
        adapter.updateList(listToShow.toMutableList())
    }
}