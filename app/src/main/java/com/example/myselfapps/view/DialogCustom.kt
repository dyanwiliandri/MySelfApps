package com.example.myselfapps.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myselfapps.R
import com.example.myselfapps.databinding.DialogCustomBinding
import com.example.myselfapps.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogCustom: BottomSheetDialogFragment() {
    private var _binding: DialogCustomBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogCustomBinding.inflate(inflater, container, false)
        return binding.root
    }

}