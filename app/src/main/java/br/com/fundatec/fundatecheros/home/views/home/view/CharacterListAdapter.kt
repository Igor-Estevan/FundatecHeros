package br.com.fundatec.fundatecheros.home.views.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheros.databinding.CharacterListItemBinding
import br.com.fundatec.fundatecheros.home.views.home.domain.HeroModel

class CharacterListAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val list: MutableList<HeroModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: List<HeroModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }
}