package com.kuluruvineeth.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuluruvineeth.room.db.Subscriber
import com.kuluruvineeth.room.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(
    private val repository: SubscriberRepository
) : ViewModel(){

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete : Subscriber

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        if(isUpdateOrDelete){
            subscriberToUpdateOrDelete.name = inputName.value!!
            subscriberToUpdateOrDelete.email = inputEmail.value!!
            update(subscriberToUpdateOrDelete)
        }else{
            val name = inputName.value!!
            val email = inputEmail.value!!
            insert(Subscriber(0,name,email))
            inputName.value = null
            inputEmail.value = null
        }
    }

    fun clearAllOrDelete(){
        if(isUpdateOrDelete){
            delete(subscriberToUpdateOrDelete)
        }else{
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber){
        viewModelScope.launch {
            val newRowId = repository.insert(subscriber)
            if(newRowId>-1){
                statusMessage.value = Event("Subscriber inserted successfully $newRowId")
            }else{
                statusMessage.value = Event("Error Occurred")
            }
        }
    }

    fun update(subscriber: Subscriber){
        viewModelScope.launch {
            val noOfRows = repository.update(subscriber)
            if(noOfRows>0) {
                inputName.value = null
                inputEmail.value = null
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "Save"
                clearAllOrDeleteButtonText.value = "Clear All"
                statusMessage.value = Event("$noOfRows Row Updated Successfully")
            }else{
                statusMessage.value = Event("Error occurred")
            }
        }
    }

    fun delete(subscriber: Subscriber){
        viewModelScope.launch {
            val noOfRows = repository.delete(subscriber)
            if(noOfRows>0) {
                inputName.value = null
                inputEmail.value = null
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "Save"
                clearAllOrDeleteButtonText.value = "Clear All"
                statusMessage.value = Event("$noOfRows Row deleted successfully")
            }else{
                statusMessage.value = Event("Error occured")
            }
        }
    }

    fun clearAll(){
        viewModelScope.launch {
            val noOfRows = repository.deleteAll()
            if(noOfRows>0){
                statusMessage.value = Event("All $noOfRows Deleted Successfully")
            }else{
                statusMessage.value = Event("Error occured")
            }
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }
}