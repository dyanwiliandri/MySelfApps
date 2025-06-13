package com.example.myselfapps.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myselfapps.R
import com.example.myselfapps.adapter.MusicAdapter
import com.example.myselfapps.adapter.VideoAdapter
import com.example.myselfapps.databinding.FragmentMultimediaBinding
import com.example.myselfapps.model.MusicData
import com.example.myselfapps.model.VideoData

class MultimediaFragment : Fragment() {

    private var _binding: FragmentMultimediaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMultimediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Setup Music Favorites RecyclerView ---
        val musicItems = getDummyMusicItems()
        val musicAdapter = MusicAdapter(musicItems)
        binding.musicFavoritesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.musicFavoritesRecyclerView.adapter = musicAdapter

        // --- Setup Videos RecyclerView ---
        val videoItems = getDummyVideoItems()
        val videoAdapter = VideoAdapter(videoItems) { videoUrl ->
            // Lambda ini akan dipanggil saat item video diklik
            openYouTubeVideo(videoUrl)
        }
        binding.videosRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.videosRecyclerView.adapter = videoAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openYouTubeVideo(videoUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // Penting untuk Intent yang tidak berasal dari Activity

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Aplikasi YouTube tidak ditemukan.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDummyMusicItems(): List<MusicData> {
        return listOf(
            MusicData(R.drawable.note, "It's 6pm but i miss u already", "bbbluelee"),
        )
    }

    private fun getDummyVideoItems(): List<VideoData> {
        return listOf(
            VideoData(R.drawable.youtube, "It's 6pm but i miss u already - bbbluelee", "LZHOU STUDIO", "https://www.youtube.com/watch?v=CXc6fPvhbrU"),
        )
    }
}