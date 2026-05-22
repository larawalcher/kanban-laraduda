package com.laraduda.task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.laraduda.task2.R
import com.laraduda.task2.databinding.FragmentFormTaskBinding
import com.laraduda.task2.util.initTollbar
import com.laraduda.task2.util.showBottomSheet

class FormTaskFragment: Fragment(){
    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTollbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.buttonSave.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val description = binding.editTextDescricao.text.toString().trim()
        if (description.isNotBlank()){
            Toast.makeText(requireContext(), "Tudo ok!", Toast.LENGTH_SHORT).show()

        }else{
            showBottomSheet(message = R.string.description_empty_form_task_fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    }

