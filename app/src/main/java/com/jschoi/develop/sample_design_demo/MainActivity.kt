package com.jschoi.develop.sample_design_demo

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.powerspinner.PowerSpinnerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aaa = findViewById<PowerSpinnerView>(R.id.rec)
        val adapter = MySpinnerAdapter(aaa)
        aaa.setSpinnerAdapter(adapter)
        findViewById<PowerSpinnerView>(R.id.rec).let {
            it.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newText ->
            }

            it.setOnClickListener {
                (it as PowerSpinnerView).let { v ->

                    val location = IntArray(2)
                    it.getLocationOnScreen(location)
                    val y = location[1]


                    val metrics = DisplayMetrics()
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                        display?.getRealMetrics(metrics)
                    } else {
                        @Suppress("DEPRECATION")
                        val display = windowManager.defaultDisplay
                        @Suppress("DEPRECATION")
                        display.getMetrics(metrics)
                    }

                    val a = metrics.heightPixels - y - 50
                    v.spinnerPopupHeight = a.toInt()
                    v.showOrDismiss(0, -it.height)
                }
            }
        }
    }
}