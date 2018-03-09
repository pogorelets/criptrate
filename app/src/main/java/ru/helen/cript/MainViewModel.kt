package ru.helen.cript

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.helen.cript.api.Cript
import ru.helen.cript.api.Response
import ru.helen.cript.api.RestClient
import ru.helen.cript.repository.NetworkRepository
import ru.helen.cript.repository.NetworkRepositoryImpl

/**
 * ViewModel for main.
 */
class MainViewModel() : ViewModel() {
    val client : RestClient = RestClient().getInstance()
    val networkRepository : NetworkRepository = NetworkRepositoryImpl(client.getApi())
    var response : MutableLiveData<Response> = networkRepository.getCriptoRate()
    fun getCriptoRate() : MutableLiveData<Response> = response

}