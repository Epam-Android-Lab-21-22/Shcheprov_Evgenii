package com.example.shcheprov_homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.shcheprov_homeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val calculator = BMICalculator()
    companion object {
        const val MAX_HEIGHT_MET = 220
        const val MAX_WEIGHT_MET = 150
        const val MAX_HEIGHT_IMP = 86
        const val MAX_WEIGHT_IMP = 330
        const val DEFAULT_PROGRESS = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcTypeSwitch.text = getString(R.string.metric)//metric is default
        setMetricType()

        binding.calcTypeSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                compoundButton.text = getString(R.string.imperial)
                setImperialType()
                calculator.apply { calcTypeIsSwitched = true }
            } else {
                compoundButton.text = getString(R.string.metric)
                setMetricType()
                calculator.apply { calcTypeIsSwitched = false }
            }
        }

        binding.weightSeekBar.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                    binding.weightTextView.text = progress.toString()
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}
            }
        )

        binding.heightSeekBar.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                    binding.heightTextView.text = progress.toString()
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}
            }
        )
        binding.calcButton.setOnClickListener {
            binding.resoultTextView.text = calculator.let { //не нарушаем тз :)
                it.calcBMI(
                    height = binding.heightSeekBar.progress,
                    weight = binding.weightSeekBar.progress,
                    context = this.applicationContext
                )
            }

        }
    }

    private fun setMetricType() {
        binding.weightHintTextView.text = getString(R.string.enter_weight_in_kg)
        binding.heightHintTextView.text = getString(R.string.enter_height_in_sm)
        binding.weightSeekBar.apply {
            max = MAX_WEIGHT_MET
            progress = DEFAULT_PROGRESS
        }

        binding.heightSeekBar.apply {
            max = MAX_HEIGHT_MET
            progress = DEFAULT_PROGRESS
        }
    }

    private fun setImperialType() {
        binding.weightHintTextView.text = getString(R.string.enter_weight_in_ft)
        binding.heightHintTextView.text = getString(R.string.enter_height_in_inch)
        binding.weightSeekBar.apply {
            max = MAX_WEIGHT_IMP
            progress = DEFAULT_PROGRESS
        }
        binding.heightSeekBar.apply {
            max = MAX_HEIGHT_IMP
            progress = DEFAULT_PROGRESS
        }
    }

}