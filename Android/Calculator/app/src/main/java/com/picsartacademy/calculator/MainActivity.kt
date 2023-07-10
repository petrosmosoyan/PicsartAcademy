package com.picsartacademy.calculator

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.picsartacademy.calculator.ActionType.Divide
import com.picsartacademy.calculator.ActionType.Minus
import com.picsartacademy.calculator.ActionType.Multiply
import com.picsartacademy.calculator.ActionType.Percent
import com.picsartacademy.calculator.ActionType.Plus
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener, Actions {

    private var display: TextView by Delegates.notNull()
    private var resetDisplay = false

    companion object {
        const val displayKey = "displayKey"
        private var number = 0.0
        private var tmpNumber: Double? = null
        private var actionType: ActionType? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        savedInstanceState?.takeIf {
            it.containsKey(displayKey)
        }?.let {
            display.text = it.getString(displayKey)
        }

        val btn0: Button = findViewById(R.id.btn_0)
        val btn1: Button = findViewById(R.id.btn_1)
        val btn2: Button = findViewById(R.id.btn_2)
        val btn3: Button = findViewById(R.id.btn_3)
        val btn4: Button = findViewById(R.id.btn_4)
        val btn5: Button = findViewById(R.id.btn_5)
        val btn6: Button = findViewById(R.id.btn_6)
        val btn7: Button = findViewById(R.id.btn_7)
        val btn8: Button = findViewById(R.id.btn_8)
        val btn9: Button = findViewById(R.id.btn_9)

        val btnPlus: Button = findViewById(R.id.btn_plus)
        val btnMinus: Button = findViewById(R.id.btn_minus)
        val btnDivide: Button = findViewById(R.id.btn_divide)
        val btnMultiply: Button = findViewById(R.id.btn_mult)

        val btnEqual: Button = findViewById(R.id.btn_equal)
        val btnPercent: Button = findViewById(R.id.btn_percent)
        val btnSwitch: Button = findViewById(R.id.btn_switch)
        val btnC: Button = findViewById(R.id.btn_c)
        val btnDot: Button = findViewById(R.id.btn_dot)

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnEqual.setOnClickListener(this)
        btnPercent.setOnClickListener(this)
        btnSwitch.setOnClickListener(this)
        btnC.setOnClickListener(this)
        btnDot.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(displayKey, display.text.toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_0 -> {
                concatNumbers("0")
            }

            R.id.btn_1 -> {
                concatNumbers("1")
            }

            R.id.btn_2 -> {
                concatNumbers("2")
            }

            R.id.btn_3 -> {
                concatNumbers("3")
            }

            R.id.btn_4 -> {
                concatNumbers("4")
            }

            R.id.btn_5 -> {
                concatNumbers("5")
            }

            R.id.btn_6 -> {
                concatNumbers("6")
            }

            R.id.btn_7 -> {
                concatNumbers("7")
            }

            R.id.btn_8 -> {
                concatNumbers("8")
            }

            R.id.btn_9 -> {
                concatNumbers("9")
            }

            R.id.btn_plus -> {
                actionType = Plus
                onAction()
            }

            R.id.btn_minus -> {
                actionType = Minus
                onAction()
            }

            R.id.btn_divide -> {
                actionType = Divide
                onAction()
            }

            R.id.btn_mult -> {
                actionType = Multiply
                onAction()
            }

            R.id.btn_percent -> {
                actionType = Percent
                evaluate()
            }

            R.id.btn_equal -> {
                onEqual()
            }

            R.id.btn_switch -> {
                onSwitch()
            }

            R.id.btn_c -> {
                onClear()
            }

            R.id.btn_dot -> {
                concatNumbers(".")
            }
        }
    }

    override fun onPlus() {
        tmpNumber?.let {
            val result = number + it
            number = result
            showOnDisplay(result)
        }
    }

    override fun onMinus() {
        tmpNumber?.let {
            val result = number - it
            number = result
            showOnDisplay(result)
        }
    }

    override fun onDivide() {
        tmpNumber?.let {
            val result = number / it
            number = result
            showOnDisplay(result)
        }
    }

    override fun onMultiply() {
        tmpNumber?.let {
            val result = number * it
            number = result
            showOnDisplay(result)
        }
    }

    override fun onSwitch() {
        val result = display.text.toString().replace(" ", "").toDouble() * (-1)
        showOnDisplay(result)
    }

    override fun onPercent() {
        number = display.text.toString().replace(" ", "").toDouble()

        number /= 100
        showOnDisplay(number)
    }

    override fun onClear() {
        display.text = "0"
        number = 0.0
        tmpNumber = null
        actionType = null
    }

    override fun onEqual() {
        if (actionType == null)
            return

        evaluate()
    }

    private fun concatNumbers(string: String) {
        if (resetDisplay) {
            resetDisplay = false
            display.text = ""
        }

        val result = (display.text.toString().replace(" ", "") + string).toDouble()
        showOnDisplay(result)
    }

    private fun showOnDisplay(result: Double) {
        var tmpText = if (result == 0.0 || result - result.toInt() == 0.0)
            result.toInt().toString()
        else
            result.toString()

        when (tmpText.length) {
            in 1..3 -> {
                tmpText = tmpText
            }

            4 -> {
                val list = tmpText.toMutableList()
                list.add(1, ' ')

                tmpText = list.joinToString("")
            }

            5 -> {
                val list = tmpText.toMutableList()
                list.add(2, ' ')

                tmpText = list.joinToString("")
            }

            6 -> {
                val list = tmpText.toMutableList()
                list.add(3, ' ')

                tmpText = list.joinToString("")
            }

            7 -> {
                val list = tmpText.toMutableList()
                list.add(1, ' ')
                list.add(5, ' ')

                tmpText = list.joinToString("")
            }

            8 -> {
                val list = tmpText.toMutableList()
                list.add(2, ' ')
                list.add(6, ' ')

                tmpText = list.joinToString("")
            }

            9 -> {
                val list = tmpText.toMutableList()
                list.add(3, ' ')
                list.add(7, ' ')

                tmpText = list.joinToString("")
            }

            else -> {
                return
            }
        }

        display.text = tmpText
    }

    private fun onAction() {
        number = display.text.toString().replace(" ", "").toDouble()
        resetDisplay = true
        tmpNumber = null
    }

    private fun evaluate() {
        resetDisplay = true

        if (tmpNumber == null)
            tmpNumber = display.text.toString().replace(" ", "").toDouble()

        when (actionType) {
            Plus -> onPlus()
            Minus -> onMinus()
            Divide -> onDivide()
            Multiply -> onMultiply()
            Percent -> onPercent()
            else -> {}
        }
    }
}