package com.anioncode.retrofit2

import com.lasoft.mvvmmodelexample.model.Profile
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    //RXJAVA2
    @GET("users")
    fun  findall(): Observable<List<Profile>>

}