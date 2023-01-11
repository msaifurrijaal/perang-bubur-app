package com.example.perangbubur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.perangbubur.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    private lateinit var binding : FragmentFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinishBinding.inflate(layoutInflater)

        var args = FinishFragmentArgs.fromBundle(arguments as Bundle).result

        binding.tvResult.text = args

        return binding.root
    }

}