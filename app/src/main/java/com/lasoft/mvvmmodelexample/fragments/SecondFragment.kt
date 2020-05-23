package com.lasoft.mvpmodel


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anioncode.retrofit2.ApiService
import com.anioncode.retrofit2.RetrofitClientInstance
import com.lasoft.mvvmmodelexample.R
import com.lasoft.mvvmmodelexample.viewModel.SharedViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.frag_second.*
import kotlinx.android.synthetic.main.frag_second.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view:View = inflater.inflate(R.layout.frag_second, container, false)
        // Inflate the layout for this fragment

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)
        viewModel.getText().observe(getViewLifecycleOwner(), Observer {

             text.text=it

        })

        button.setOnClickListener {
            val service = RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)

            service.findall().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    viewModel.setText(data.toString())

                }, { t ->
                    t.message
                })
        }


    }

}
