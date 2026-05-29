package com.laraduda.task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.laraduda.task2.R
import com.laraduda.task2.data.model.Status
import com.laraduda.task2.databinding.FragmentDoingBinding
import com.laraduda.task2.data.model.Task // Se ficar vermelho, aperte Alt+Enter para importar a sua classe Task
import com.laraduda.task2.ui.adapter.TaskAdapter // Se ficar vermelho, aperte Alt+Enter para importar o seu TaskAdapter

class DoingFragment : Fragment() {


    private lateinit var taskAdapter: TaskAdapter

    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerViewTask(getTaskList())
    }


    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(),taskList)


        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)
        binding.recyclerViewTask.adapter = taskAdapter
    }


    private fun getTaskList() = listOf(
        Task(id = "1", description = "Criar nova tela de app",Status.TODO),
        Task(id = "2", description = "Validar informações na tela de login",Status.TODO),
        Task(id = "3", description = "Estruturar novo fluxo do app",Status.TODO),
        Task(id = "4", description = "Testar novas features",Status.TODO),
        Task(id = "5", description = "Criar funcionalidades de login no app",Status.TODO)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}