package com.ehsankolivand.simpleepoxyexample.epoxy

import com.airbnb.epoxy.EpoxyController
import com.ehsankolivand.simpleepoxyexample.R
import com.ehsankolivand.simpleepoxyexample.databinding.SimpleItemBinding
import com.ehsankolivand.simpleepoxyexample.epoxy.helper.ViewBindingKotlinModel
import com.ehsankolivand.simpleepoxyexample.model.SimpleModel

class MyController: EpoxyController() {
    var dataModel = listOf<SimpleModel>()
    set(value) {
        field = value
        requestModelBuild()
    }
     override fun buildModels() {

         dataModel.forEach {
             add(MyEpoxyModel(it).id(it.id))
         }
     }

    data class MyEpoxyModel(val simpleModel:SimpleModel):
        ViewBindingKotlinModel<SimpleItemBinding>(R.layout.simple_item) {
        override fun SimpleItemBinding.bind() {
            txtText.text = simpleModel.name
        }
    }
}