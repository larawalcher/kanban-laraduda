package com.laraduda.task2.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.laraduda.task2.R
import com.laraduda.task2.databinding.FragmentRegisterBinding
import com.laraduda.task2.util.initTollbar


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTollbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.EnviarRegistro.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()

        if (email.isNotBlank()){
            if (senha.isNotBlank()){
                Toast.makeText(requireContext(), "Tudo ok!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Preencha uma senha!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Preencha um email valido!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}