package com.example.testargs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testargs.databinding.FragmentFirstBinding

class FirstFragment:Fragment() {
    private var _binding:FragmentFirstBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val textToNextFrag = binding.editText.text.toString()
            findNavController().navigate(FirstFragmentDirections.goNextFrag(textToNextFrag))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}