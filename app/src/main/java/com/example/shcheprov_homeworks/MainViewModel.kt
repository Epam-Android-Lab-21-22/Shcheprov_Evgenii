package com.example.shcheprov_homeworks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private var _clicksLiveData:MutableLiveData<Int> = MutableLiveData(0)
    var clicksLiveData:LiveData<Int> = _clicksLiveData
    private var _charactersCountLiveData:MutableLiveData<Int> = MutableLiveData(0)
    var charactersCountLiveData:LiveData<Int> = _charactersCountLiveData
    private var _charactersLiveData:MutableLiveData<String> = MutableLiveData("")
    var charactersLiveData:LiveData<String> = _charactersLiveData

    fun updateClicksCount(){
        _clicksLiveData.apply { value=value?.plus(1) }
    }

    fun updateCharacters(str:String){
        if(str.length> _charactersLiveData.value!!.length){
            _charactersCountLiveData.apply { value=value?.plus(1)
            }
        }
        _charactersLiveData.value=str
    }
}