package com.example.uana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uana.adapter.ProdutoAdapter
import com.example.uana.adapter.ProdutoClickListener
import com.example.uana.databinding.FragmentDescricaoProdutoBinding
import com.example.uana.model.Produto


class DescricaoProdutoFragment : Fragment(), ProdutoClickListener {

    private lateinit var binding: FragmentDescricaoProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDescricaoProdutoBinding.inflate(layoutInflater, container, false)

        mainViewModel.listProduto()

        val adapter = ProdutoAdapter(this, mainViewModel, requireContext())

        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)


        return binding.root
    }

    override fun onProdutoClickListener(produto: Produto) {
        TODO("Not yet implemented")
    }

}



