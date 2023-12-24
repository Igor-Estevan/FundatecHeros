package br.com.fundatec.fundatecheros.home.views.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheros.databinding.CharacterListItemBinding
import br.com.fundatec.fundatecheros.home.views.home.domain.HeroModel

class CharacterListAdapter(private val click: (HeroModel) -> Unit) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    private val list: MutableList<HeroModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, click)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: List<HeroModel>, gone: Unit) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun retrieveCharacter(position: Int): HeroModel {
        return list[position]
    }
}