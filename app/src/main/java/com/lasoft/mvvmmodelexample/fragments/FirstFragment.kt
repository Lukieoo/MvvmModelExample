package com.lasoft.mvpmodel

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.lasoft.mvvmmodelexample.R
import com.lasoft.mvvmmodelexample.viewModel.SharedViewModel
import kotlinx.android.synthetic.main.frag_first.*
import kotlinx.android.synthetic.main.frag_first.view.*


class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        var view:View=inflater.inflate(R.layout.frag_first, container, false)
        view.edit.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                viewModel.setText(edit.text.toString())
                // Toast.makeText(activity,"ok",Toast.LENGTH_LONG).show()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        });

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)
        // TODO: Use the ViewModel


        viewModel.getText().observe(getViewLifecycleOwner(), Observer {
            test.text=it
        })
    }

}
