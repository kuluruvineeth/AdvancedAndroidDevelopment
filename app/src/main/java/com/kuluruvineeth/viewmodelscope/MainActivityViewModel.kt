package com.kuluruvineeth.viewmodelscope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.kuluruvineeth.viewmodelscope.model.User
import com.kuluruvineeth.viewmodelscope.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository()

    var users = liveData<List<User>>(Dispatchers.IO){
        val result = userRepository.getUsers()
        emit(result)
    }
    /*var users : MutableLiveData<List<User>?> = MutableLiveData()
    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }*/
}