package com.lasoft.mvvmmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import com.anioncode.retrofit2.ApiService
import com.anioncode.retrofit2.RetrofitClientInstance
import com.lasoft.mvpmodel.FirstFragment
import com.lasoft.mvpmodel.SecondFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.container_b, SecondFragment())
            .add(R.id.container_a, FirstFragment())
            .commit()


    }
}
