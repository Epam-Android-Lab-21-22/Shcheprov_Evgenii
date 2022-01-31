package com.example.shcheprov_homeworks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shcheprov_homeworks.R
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding
import com.example.shcheprov_homeworks.di.appComponent
import com.example.shcheprov_homeworks.viewmodels.MainActivityViewModel
import com.example.shcheprov_homeworks.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        viewModel.textLiveData.observe(this, {
            binding.editText.setText(it)
        })
        viewModel.showWriteErrorToast.observe(this, {
            Toast.makeText(this, getString(R.string.write_error), Toast.LENGTH_SHORT).show()
        })
    }

    private fun setListeners() {
        binding.buttonSave.setOnClickListener {
            saveText(binding.editText.text.toString())
            binding.editText.setText("")
        }
        binding.buttonLoad.setOnClickListener {
            loadText()
        }
    }

    private fun saveText(text: String) {
        with(binding) {
            when (radioGroup.checkedRadioButtonId) {
                radioButtonSP.id -> viewModel.saveStringToSharedPreferences(text)
                radioButtonIS.id -> viewModel.saveStringToInternalStorage(text)
                radioButtonES.id -> viewModel.saveStringToExternalStorage(text)
                radioButtonDB.id -> viewModel.saveStringToDataBase(text)
            }
        }
    }

    private fun loadText() {
        with(binding) {
            when (radioGroup.checkedRadioButtonId) {
                radioButtonSP.id -> viewModel.readStringFromSharedPreferences()
                radioButtonIS.id -> viewModel.readStringFromInternalStorage()
                radioButtonES.id -> viewModel.readStringFromExternalStorage()
                radioButtonDB.id -> viewModel.readStringFromDataBase()
            }
        }
    }


}