package ru.helen.cript.repository

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.helen.cript.api.Cript
import ru.helen.cript.api.CriptService
import ru.helen.cript.api.Response

/**
 * Created by lenap on 03.03.2018.
 */
class NetworkRepositoryImpl(val service: CriptService) : NetworkRepository {
    override fun getCriptoRate(): MutableLiveData<Response> {
        val response : MutableLiveData<Response> = MutableLiveData<Response>()
        //var criptolist: MutableLiveData<List<Cript>> = MutableLiveData<List<Cript>>() ;

        var observer: Observable<List<Cript>> = service.getCriptoRate().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .repeat(10000)

        observer.subscribe({ criptorateList ->
            response.postValue(Response(criptorateList,""))

        }) { throwable -> response.postValue(Response(ArrayList<Cript>(), throwable.toString()))  };
        return response;
    }
}