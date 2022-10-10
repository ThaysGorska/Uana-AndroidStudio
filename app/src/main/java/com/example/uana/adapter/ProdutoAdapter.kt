package com.example.uana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uana.MainViewModel
import com.example.uana.databinding.CardLayoutBinding
import com.example.uana.model.Produto

class ProdutoAdapter(
    val produtoClickListener: ProdutoClickListener,
    val mainViewModel: MainViewModel
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(


) {
    private var listProduto = emptyList<Produto>()

    class ProdutoViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        return ProdutoViewHolder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listProduto[position]

        holder.binding.textNome.text = produto.nome
        holder.binding.textPreco.text = produto.preco
        holder.binding.textQuantidade.text = produto.quantidade.toString()

        holder.binding.buttonAdd.setOnClickListener{

            produto.addQuantidade()
            notifyItemChanged(position)
        }

        holder.binding.buttonRem.setOnClickListener{

            produto.remQuantidade()
            notifyItemChanged(position)
        }

        holder.itemView.setOnClickListener {
            produtoClickListener.onProdutoClickListener(produto)
        }


    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produto>) {

        listProduto = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }
}