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
import com.bumptech.glide.Glide
import com.example.myselfapps.R
import com.example.myselfapps.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(R.drawable.pic)
            .circleCrop()
            .into(binding.profileImage)

        binding.callPhoneLayout.setOnClickListener {
            val phoneNumber = "+6281234567890"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Tidak ada aplikasi telepon yang tersedia.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.sendMailLayout.setOnClickListener {
            val emailAddress = "dyan.10122085@mahasiswa.unikom.ac.id"
            val subject = "Pesan dari Aplikasi My Self Apps"
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                putExtra(Intent.EXTRA_SUBJECT, subject)
            }
            try {
                startActivity(Intent.createChooser(intent, "Kirim email menggunakan..."))
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Tidak ada aplikasi email yang tersedia.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.socialMediaLayout.setOnClickListener {
            val socialMediaUrl = "https://www.instagram.com/dyan_wa?igsh=aHQ5Z3AxbXgzMTR4"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(socialMediaUrl))
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Tidak ada browser yang tersedia.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.mapPlaceholderLayout.setOnClickListener {
            val googleMapsUrl = "https://www.google.com/maps/place/Vifa+Kost/@-6.8868466,107.6231959,406m/data=!3m1!1e3!4m6!3m5!1s0x2e68e756752ce1ad:0xfab48ae8f15b6a84!8m2!3d-6.8864956!4d107.624131!16s%2Fg%2F11vfbgfjg8?entry=ttu&g_ep=EgoyMDI1MDYxMS4wIKXMDSoASAFQAw%3D%3D"
            val gmapsUri = Uri.parse(googleMapsUrl)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmapsUri)

            try {
                startActivity(mapIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Tidak ada aplikasi peta atau browser yang tersedia.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnInfo.setOnClickListener {
            val bottomeSheet = DialogCustom()
            bottomeSheet.show(childFragmentManager, "DialogCustom")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}