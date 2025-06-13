package com.example.myselfapps.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myselfapps.R
import com.example.myselfapps.adapter.DailyActivityAdapter
import com.example.myselfapps.adapter.FriendListAdapter
import com.example.myselfapps.databinding.FragmentDailyBinding
import com.example.myselfapps.model.DailyData
import com.example.myselfapps.model.FriendData


class DailyFragment : Fragment() {

    private var _binding : FragmentDailyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDailyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dailyActivities = getDummyDailyActivities()
        val dailyActivityAdapter = DailyActivityAdapter(dailyActivities)
        binding.rvDaily.layoutManager = LinearLayoutManager(context)
        binding.rvDaily.adapter = dailyActivityAdapter

        val friends = getDummyFriends()
        val friendsListAdapter = FriendListAdapter(friends, requireContext())

        binding.rvFriends.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFriends.adapter = friendsListAdapter
    }

    private fun getDummyDailyActivities(): List<DailyData> {
        return listOf(
            DailyData(R.drawable.sarapan, "Sarapan", "Pukul 07.00 WIB"),
            DailyData(R.drawable.kerja, "Kerja", "Pukul 08.00 WIB"),
            DailyData(R.drawable.istirahat, "Istirahat", "Pukul 12.00 WIB"),
            DailyData(R.drawable.kuliah, "Kuliah", "Pukul 17.00 WIB"),
            DailyData(R.drawable.tidur, "Tidur", "Pukul 23.59 WIB")
        )
    }
    private fun getDummyFriends(): List<FriendData> {
        return listOf(
            FriendData(R.drawable.profile, "TemanA"),
            FriendData(R.drawable.profile, "TemanB"),
        )
    }

}