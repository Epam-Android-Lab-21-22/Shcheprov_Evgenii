package com.example.shcheprov_homeworks

import android.content.Context
import android.util.Log
import java.math.RoundingMode
import java.text.DecimalFormat

class BMICalculator() {
    var calcTypeIsSwitched = false
    fun calcBMI(height: Int, weight: Int, context: Context): String {
        if (height == 0 || weight == 0) return context.getString(R.string.wrong_input)
        else if (calcTypeIsSwitched) return context.getString(R.string.your_BMI) +
                calcBMIImperial(height.toDouble(), weight.toDouble())
        else return context.getString(R.string.your_BMI) +
                calcBMIMetric(height.toDouble(), weight.toDouble())
    }

    companion object {

        fun calcBMIMetric(height: Double, weight: Double): String {
            return roundDouble((weight / ((height / 100) * (height / 100)))).toString()
        }

        fun calcBMIImperial(height: Double, weight: Double): String {
            return roundDouble(((weight / (height * height)) * 703)).toString()
        }

        fun roundDouble(a: Double): Double {
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.CEILING
            return df.format(a).toDouble()
        }
    }
}