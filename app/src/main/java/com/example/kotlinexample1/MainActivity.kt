package com.example.kotlinexample1

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.ComponentActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtInput = findViewById<EditText>(R.id.edtInput)

        edtInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                edtInput.removeTextChangedListener(this)
                var number1  = decimalFormat(edtInput)
                edtInput.setText(number1);
//                edtInput.requestFocus()
                edtInput.setSelection(edtInput.text.length)


                edtInput.addTextChangedListener(this)

            }

        })

    }
}

fun decimalFormat(edt: EditText): String {
    val string = edt.text.toString()
    val numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH)
    val dec:DecimalFormat = numberFormat as DecimalFormat
    dec.applyPattern("#,###")

    if (!TextUtils.isEmpty(string)) {
        val textNb = string.replace(",".toRegex(), "")
        val number = textNb.toDouble()
        return dec.format(number)

    }
    return ""
}





