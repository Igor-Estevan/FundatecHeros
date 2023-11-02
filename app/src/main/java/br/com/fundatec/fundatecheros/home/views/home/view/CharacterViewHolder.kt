package br.com.fundatec.fundatecheros.home.views.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheros.databinding.CharacterListItemBinding
import br.com.fundatec.fundatecheros.home.domain.CharacterModel
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val binding: CharacterListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.ivCharacter)
    }
}