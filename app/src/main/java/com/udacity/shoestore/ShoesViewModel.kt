package com.udacity.shoestore

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private var _shoesName = MutableLiveData<String?>()
    val shoesNam: LiveData<String?>
        get() = _shoesName

    private var _size = MutableLiveData<String?>()
    val size: LiveData<String?>
        get() = _size

    private var _company = MutableLiveData<String?>()
    val company: LiveData<String?>
        get() = _company

    private var _description = MutableLiveData<String?>()
    val description: LiveData<String?>
        get() = _description


    fun setShoeName(sN: String) {
        _shoesName.value = sN

    }

    fun setCompany(com: String) {
        _company.value = com
    }

    fun setDescription(Des: String) {
        _description.value = Des
    }

    fun setsize(s: String) {


        _size.value = s

    }

    fun addShoe() {


        var shoes = Shoe(
            _shoesName.value.toString(),
            _size.value.toString(),
            _company.value.toString(),
            _description.value.toString()
        )
        _shoes.value?.add(shoes)
    }
}
