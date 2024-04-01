package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGameFinishedBinding
import com.example.myapplication.domain.entity.GameResult


class GameFinishedFragment : Fragment() {
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding
        get() = _binding!!


    private val args by navArgs<GameFinishedFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListener()
        binding.gameResult = args.gameResult

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun retryGame() {
        findNavController().popBackStack()
    }

    private fun setupClickListener() {

        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }


}