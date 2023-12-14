package br.com.fundatec.fundatecheros.home.views.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheros.home.views.heros.domain.HeroUseCase
import br.com.fundatec.fundatecheros.home.views.home.domain.toModel
import br.com.fundatec.fundatecheros.home.views.home.presentation.model.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val useCase by lazy {
        HeroUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState

    private fun searchInfo() {
        viewModelScope.launch {
            val listHero = useCase.listHero()
            if (listHero.isNotEmpty()) {
                viewState.value = HomeViewState.Sucess(listHero.toModel())
            }
            else {
                viewState.value = HomeViewState.Error("Lista Vazia")
            }
        }
    }

    init {
        searchInfo()
    }

}