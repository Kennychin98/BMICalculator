package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalculate.setOnClickListener {
            calculateBMI()
        }
        btnReset.setOnClickListener {
            resetfun()
        }
    }
    private fun resetfun()
    {

        Image.setImageResource(R.drawable.empty)
        textViewBMI.text = null;
        txtWeight.text = null;
        txtHeight.text = null;
        txtWeight.requestFocus()
    }
    private fun calculateBMI() {
        try {
            val weight: Double = txtWeight.text.toString().toDouble();
            val height: Double = txtHeight.text.toString().toDouble();
            val bmi: Double = weight / (height * height);
            val result: String;


            if (bmi <= 18.5) {
                Image.setImageResource(R.drawable.under)
                result = "under"
            } else if (bmi <= 24.9) {
                Image.setImageResource(R.drawable.normal)
                result = "Normal"
            } else {
                Image.setImageResource(R.drawable.over)
                result = "over"
            }
            textViewBMI.text = "BMI %.2f (%s)".format(bmi, result)
        }
        catch(e:Exception)
        {
            val toast:Toast = Toast.makeText(this , "Invalid Input", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0, 0)
            toast.show()
            
        }
    }



}
