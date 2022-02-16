package com.ehsankolivand.simpleepoxyexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.simpleepoxyexample.databinding.ActivityMainBinding
import com.ehsankolivand.simpleepoxyexample.epoxy.MyController
import com.ehsankolivand.simpleepoxyexample.model.SimpleModel

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val myController = MyController()
        var list = mutableListOf<SimpleModel>()
        list.add(SimpleModel(1))
        list.add(SimpleModel(2))
        list.add(SimpleModel(2))
        list.add(SimpleModel(4))
        list.add(SimpleModel(5))
        list.add(SimpleModel(6))

        activityMainBinding.epoxyRecycler.adapter = myController.adapter

        myController.dataModel = list

    }
}