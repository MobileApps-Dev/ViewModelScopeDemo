package com.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viewmodelscopedemo.model.User
import com.viewmodelscopedemo.repositary.UserRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivityViewModel : ViewModel() {
    //With Coroutines
    // private val myJob = Job()
    // private val myScope = CoroutineScope(IO + myJob)

    private var userRepository=UserRepository()
    var users:MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {
//        myScope.launch {
//            //My code
//        }

        viewModelScope.launch {
            var result :List<User>?=null
            withContext(Dispatchers.IO){
                result = userRepository.getUser()
            }
            users.value = result
        }

    }

//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//
//    }
}