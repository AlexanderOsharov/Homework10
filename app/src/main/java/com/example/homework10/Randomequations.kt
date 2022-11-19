package com.example.homework10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework10.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity

class Randomequations : Fragment() {

    private lateinit var binding: ActivityMainBinding
    private final val problem = Problem()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityMainBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).setContentView(binding.root)
        generateProblem()
        return inflater.inflate(R.layout.fragment_randomequations, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = Randomequations()
    }

}