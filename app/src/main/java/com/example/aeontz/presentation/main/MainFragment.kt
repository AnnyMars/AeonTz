package com.example.aeontz.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aeontz.R
import com.example.aeontz.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private var backPressedTime: Long = 0
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            if (backPressedTime + 3000 > System.currentTimeMillis()){
                activity?.finish()
            }
            else
                Toast.makeText(requireContext(), "Нажмите еще чтобы выйти", Toast.LENGTH_LONG).show()
            backPressedTime = System.currentTimeMillis()
        }


        viewModel.fetchData()

        binding.recView.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner){ list ->
            adapter.differ.submitList(list)
        }

        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_authFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}