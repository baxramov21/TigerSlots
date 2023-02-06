package com.sheikh.tigerslots.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sheikh.tigerslots.R
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

    private var deposit = 0
    private var profit = 0

    private val imageIDsList = arrayListOf(
        R.drawable.usa_dollar,
        R.drawable.dollar,
        R.drawable.bocket,
        R.drawable.strawberry,
        R.drawable.tarvuz,
        R.drawable.real_coin,
        R.drawable.pear,
        R.drawable.pepe,
        R.drawable.bomb,
        R.drawable.brilliant
    )

    private val imageViews: ArrayList<ImageView> by lazy {
        val list: ArrayList<ImageView>
        with(binding.slotsTable) {
            list = arrayListOf(
                imageView,
                imageView2,
                imageView3,
                imageView4,
                imageView5,
                imageView6,
                imageView7,
                imageView8,
                imageView9
            )
        }
        list
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

        gameViewModel.imageList.observe(viewLifecycleOwner) {
            generateSlotsTable(it)
        }

        with(binding) {
            buttonStartGame.setOnClickListener {
                gameViewModel.startGame(imageIDsList)
                changeViewEnabled(it, false)
            }

            gameViewModel.deposit.observe(viewLifecycleOwner) {
                deposit = it
            }

            gameViewModel.profit.observe(viewLifecycleOwner) {
                profit = it
                gameViewModel.updateDeposit(deposit,it)
            }

            buttonUpBet.setOnClickListener {
                increaseBetAmount()
            }

            gameViewModel.gameFinished.observe(viewLifecycleOwner) {
                if (it) {
                    gameViewModel.generateProfit()
                    gameViewModel.updateDeposit(deposit, profit)
                }
                buttonStartGame.isEnabled = it
            }
        }
    }

    private fun changeViewEnabled(view: View, enabled: Boolean) {
        view.isEnabled = enabled
    }

    private fun generateSlotsTable(imageIds: List<Int>) {
        for (position in 0 until imageViews.size) {
            imageViews[position].setImageResource(imageIds[position])
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