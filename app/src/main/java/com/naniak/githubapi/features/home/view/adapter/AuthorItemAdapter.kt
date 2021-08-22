package com.naniak.githubapi.features.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naniak.githubapi.databinding.ItemHomeBinding
import com.naniak.githubapi.datamodel.DataAuthor

class AuthorItemAdapter(
    val listAuthor:List<DataAuthor>,
     private val onClickListener: (binding: ItemHomeBinding) -> Unit):
    RecyclerView.Adapter<AuthorItemAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind ( dataAuthor: DataAuthor, onClickListener: (binding: ItemHomeBinding) -> Unit){
            binding.authorName.text = dataAuthor.authorName
            binding.repoName.text = dataAuthor.repositoryName
            binding.photoAuthor.setImageResource(dataAuthor.image.toInt())
            binding.numberFork.text = dataAuthor.forksNumbers.toString()
            binding.numberStar.text = dataAuthor.starsNumbers.toString()
            binding.card.setOnClickListener { onClickListener(binding) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding= ItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listAuthor[position], onClickListener)

    override fun getItemCount() = listAuthor.size
}