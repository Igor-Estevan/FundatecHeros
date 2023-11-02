package br.com.fundatec.fundatecheros.home.views.profile.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheros.home.views.login.domain.LoginUseCase
import br.com.fundatec.fundatecheros.home.views.profile.model.ProfileViewState
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    private val useCase by lazy {
        LoginUseCase()
    }

    fun validateInputs(name: String?, email: String?, password: String?) {
        if (name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowNameError
        } else if (email.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowEmailError
        } else if (password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowPasswordError
        } else {
            Log.e("viewModel","validateInputs")
            viewModelScope.launch {
                val isSuccess = useCase.createUser(
                    name = name,
                    email = email,
                    password = password,
                )
                if (isSuccess) {
                    viewState.value = ProfileViewState.Success
                } else {
                    viewState.value = ProfileViewState.Error
                }
            }
        }
    }
}