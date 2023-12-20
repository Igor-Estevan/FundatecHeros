package br.com.fundatec.fundatecheros.home.views.heros.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheros.home.views.heros.domain.HeroUseCase
import br.com.fundatec.fundatecheros.home.views.heros.presentation.model.HeroType
import br.com.fundatec.fundatecheros.home.views.heros.presentation.model.HeroViewState
import br.com.fundatec.fundatecheros.home.views.heros.presentation.model.UniverseType
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {

    private val useCase by lazy {
        HeroUseCase()
    }

    private val viewState: MutableLiveData<HeroViewState> = MutableLiveData()
    val state: LiveData<HeroViewState> = viewState

    fun validateInputs(
        name: String,
        description: String,
        image: String,
        universeType: Int,
        characterType: Int,
        age: String,
        birthday: String
    ) {
        if (name.isNullOrBlank()) {
            viewState.value = HeroViewState.ShowNameError
            return
        } else if (description.isNullOrBlank()) {
            viewState.value = HeroViewState.ShowDescriptionError
            return
        } else if (image.isNullOrBlank()) {
            viewState.value = HeroViewState.ShowImageError
            return
        } else if (universeType == 0) {
            viewState.value = HeroViewState.ShowUniverseTypeError
            return
        } else if (characterType == 0) {
            viewState.value = HeroViewState.ShowCharacterTypeError
            return
        } else if (age.isNullOrBlank()) {
            viewState.value = HeroViewState.ShowAgeError
            return
        } else {
            viewModelScope.launch {
                val isSuccess = useCase.createHero(
                    name = name,
                    description = description,
                    image = image,
                    universeType = UniverseType.getValueOf(universeType),
                    characterType = HeroType.getValueOf(characterType),
                    age = age.toInt(),
                    birthday = null
                )
                if (isSuccess) {
                    viewState.value = HeroViewState.ShowHomeScreen
                } else {
                    viewState.value = HeroViewState.ShowGenericError
                }
            }
        }
    }
}