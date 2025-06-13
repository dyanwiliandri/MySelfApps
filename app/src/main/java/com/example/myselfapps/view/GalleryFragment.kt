package com.example.myselfapps.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myselfapps.R
import com.example.myselfapps.adapter.GalleryAdapter
import com.example.myselfapps.databinding.FragmentGalleryBinding
import com.example.myselfapps.model.GalleryData


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galleryItems = getDummyGalleryItems()
        val galleryAdapter = GalleryAdapter(galleryItems)

        val numberOfColumns = 2
        binding.galleryRecyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)
        binding.galleryRecyclerView.adapter = galleryAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDummyGalleryItems(): List<GalleryData> {
        return listOf(
            GalleryData(R.drawable.foto1),
            GalleryData(R.drawable.foto2),
            GalleryData(R.drawable.foto3),
        )
    }
}