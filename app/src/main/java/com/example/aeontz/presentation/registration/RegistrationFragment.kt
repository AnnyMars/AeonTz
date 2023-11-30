package com.example.aeontz.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aeontz.R
import com.example.aeontz.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registrationBtn.isEnabled = false

        binding.loginField.addTextChangedListener { text ->
            if (text.toString() == "demo" ) {
                binding.loginLayout.error = null
                binding.registrationBtn.isEnabled = true
                binding.registrationBtn.setOnClickListener {
                    findNavController().navigate(R.id.action_registrationFragment_to_mainFragment)
                    viewModel.makePost()
                }
            } else {
                binding.registrationBtn.isEnabled = false
                binding.loginLayout.error = "Ошика в логине"
            }
        }

        binding.passwordField.addTextChangedListener { text ->
            if (text.toString() == "12345") {
                binding.passwordLayout.error = null
                binding.registrationBtn.isEnabled = true
                binding.registrationBtn.setOnClickListener {
                    findNavController().navigate(R.id.action_registrationFragment_to_mainFragment)
                    viewModel.makePost()
                }
            } else {
                binding.registrationBtn.isEnabled = false
                binding.passwordLayout.error = "Ошика в логине"
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}