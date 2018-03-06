package ru.helen.cript.repository

import android.arch.lifecycle.MutableLiveData
import ru.helen.cript.api.Cript
import ru.helen.cript.api.Response

/**
 * Created by lenap on 03.03.2018.
 */
interface NetworkRepository {
    fun getCriptoRate() : MutableLiveData<Response>
}