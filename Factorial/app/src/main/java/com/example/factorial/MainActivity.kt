package com.example.factorial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClick()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this, ::renderState)

    }

    private fun renderState(state: State) {
        binding.progressBarLoading.visibility = View.GONE
        binding.buttonCalculate.isEnabled = true

        when(state) {
            State.Error -> {
                Toast.makeText(
                    this,
                    "You did not entered value",
                    Toast.LENGTH_SHORT
                ).show()
            }
            State.Progress -> {
                binding.progressBarLoading.visibility = View.VISIBLE
                binding.buttonCalculate.isEnabled = false
            }
            is State.Result -> {
                binding.textViewFactorial.text = state.factorial
            }
        }
    }

    private fun setOnClick() = with(binding) {
        buttonCalculate.setOnClickListener {
            viewModel.calculate(editTextNumber.text.toString())
        }
    }
}