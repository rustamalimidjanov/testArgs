package com.example.testargs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.testargs.databinding.FragmentFirstBinding
import com.example.testargs.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {
    private val args: SecondFragmentArgs by navArgs()
    private var _binding: FragmentSecondBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getText = args.strArg
        binding.secondText.text = getText

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}