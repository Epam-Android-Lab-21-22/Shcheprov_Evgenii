package com.example.shcheprov_homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setListeners()
        setObservers()
        binding.rotationEditText.setText(mainViewModel.charactersLiveData.value)


    }

    private fun setListeners() {
        binding.buttonShadow.setOnClickListener { mainViewModel.updateClicksCount() }

        binding.buttonTranslate.setOnClickListener {
            binding.buttonTranslate.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.anim_translate
                )
            )
            mainViewModel.updateClicksCount()
        }
        binding.buttonDisappearance.setOnClickListener {
            binding.buttonDisappearance.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.anim_disappearance
                )
            )
            mainViewModel.updateClicksCount()
        }
        binding.buttonScaleUp.setOnClickListener {
            binding.buttonScaleUp.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.anim_scale_up
                )
            )
            mainViewModel.updateClicksCount()
        }
        binding.rotationEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(update: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mainViewModel.updateCharacters(update.toString())
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
        binding.rotateEditTextButton.setOnClickListener {
            with(binding.editTextMotionLayout) {
                when (currentState) {
                    R.id.start -> transitionToState(R.id.end)
                    R.id.end -> transitionToState(R.id.start)
                }
            }
            mainViewModel.updateClicksCount()
        }
        binding.transformButton.setOnClickListener {
            mainViewModel.updateClicksCount()
        }

    }

    private fun setObservers() {
        mainViewModel.charactersCountLiveData.observe(this, {
            binding.buttonClicksTextView.text = getString(R.string.characterEnters)+it.toString()
        })
        mainViewModel.clicksLiveData.observe(this, {
            binding.CharacterEntersTextView.text = getString(R.string.buttonClicks)+it.toString()
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(BUTTON_STATUS, binding.buttonMotionLayout.currentState)
        outState.putInt(EDIT_TEXT_STATUS, binding.editTextMotionLayout.currentState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        with(binding){
            buttonMotionLayout.transitionToState(savedInstanceState.getInt(BUTTON_STATUS))
            editTextMotionLayout.transitionToState(savedInstanceState.getInt(EDIT_TEXT_STATUS))
        }

    }

    companion object {
        private val BUTTON_STATUS = "button_status"
        private val EDIT_TEXT_STATUS = "editText_status"
    }
}