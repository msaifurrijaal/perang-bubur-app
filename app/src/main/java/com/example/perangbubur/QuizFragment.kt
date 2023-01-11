package com.example.perangbubur

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.perangbubur.databinding.FragmentQuizBinding
import com.example.perangbubur.viewmodel.QuizViewModel

class QuizFragment : Fragment() {

    private lateinit var binding : FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        viewModel.questionBubur.observe(viewLifecycleOwner, Observer {
            binding.tvQuestion.text = it
        })

        viewModel.diadukScore.observe(viewLifecycleOwner, Observer {
            binding.scoreDiaduk.text = it.toString()
        })

        viewModel.gaDiadukScore.observe(viewLifecycleOwner, Observer {
            binding.scoreGaDiaduk.text = it.toString()
        })

        binding.button2.setOnClickListener {
            viewModel.updateScore(1)
        }

        binding.button3.setOnClickListener {
            viewModel.updateScore(2)
        }


        viewModel.eventFinished.observe(viewLifecycleOwner, Observer {
            if(it) {
                viewModel.reset()
                requireView().findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(viewModel.result.value.toString()))
            }
        })



        return binding.root
    }


}