package ru.helen.cript

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCripto.layoutManager = LinearLayoutManager(this)
        ViewModelProviders.of(this).get(MainViewModel::class.java).getCriptoRate().observe(this, Observer { response ->
            run {
                if (response?.error == null) {
                    Log.e("ERROR", response!!.error)
                }
                rvCripto.adapter = MainAdapter(response!!.data)
            }
        })

    }
}
