package ru.helen.cript.api

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * api service
 *
 */
public interface CriptService {
    @GET("v1/ticker")
    fun getCriptoRate(): Observable<List<Cript>>

}
