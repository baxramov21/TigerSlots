package com.sheikh.tigerslots.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sheikh.tigerslots.databinding.FragmentGameBinding
import com.sheikh.tigerslots.presentation.ui.viewmodel.GameViewModel
import com.sheikh.tigerslots.presentation.ui.viewmodel.ViewModelFactory

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw NullPointerException("FragmentGameBinding is null")

    private val viewModelFactory by lazy {
        ViewModelFactory(requireActivity().application)
    }

    private val gameViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }

    private val betAmount by lazy {
        gameViewModel.betAmount.value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = gameViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        gameViewModel.deposit.observe(viewLifecycleOwner) {
            binding.textViewDeposit.text = it.toString()
        }
        with(binding) {
            buttonStartGame.setOnClickListener {

            }

            buttonUpBet.setOnClickListener {
                increaseBetAmount()
            }
        }
    }


    private fun increaseBetAmount() {
        gameViewModel.increaseBet()
    }

    override fun onDestroyView() {
        if (_binding != null) {
            _binding = null
        }
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = GameFragment()
    }

}