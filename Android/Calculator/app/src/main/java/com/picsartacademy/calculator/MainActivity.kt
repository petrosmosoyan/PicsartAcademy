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
import com.picsartacademy.calculator.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener, Actions {

    private var viewBinding: ActivityMainBinding? = null
    private var resetDisplay = false

    companion object {
        const val displayKey = "displayKey"
        private var number = 0.0
        private var tmpNumber: Double? = null
        private var actionType: ActionType? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val containerView = ActivityMainBinding.inflate(layoutInflater)
            .also { viewBinding = it }
            .root

        setContentView(containerView)

        savedInstanceState?.takeIf {
            it.containsKey(displayKey)
        }?.let {
            viewBinding?.display?.text = it.getString(displayKey)
        }

        viewBinding?.btn0?.setOnClickListener(this)
        viewBinding?.btn1?.setOnClickListener(this)
        viewBinding?.btn2?.setOnClickListener(this)
        viewBinding?.btn3?.setOnClickListener(this)
        viewBinding?.btn4?.setOnClickListener(this)
        viewBinding?.btn5?.setOnClickListener(this)
        viewBinding?.btn6?.setOnClickListener(this)
        viewBinding?.btn7?.setOnClickListener(this)
        viewBinding?.btn8?.setOnClickListener(this)
        viewBinding?.btn9?.setOnClickListener(this)
        viewBinding?.btnPlus?.setOnClickListener(this)
        viewBinding?.btnMinus?.setOnClickListener(this)
        viewBinding?.btnDivide?.setOnClickListener(this)
        viewBinding?.btnMult?.setOnClickListener(this)
        viewBinding?.btnEqual?.setOnClickListener(this)
        viewBinding?.btnPercent?.setOnClickListener(this)
        viewBinding?.btnSwitch?.setOnClickListener(this)
        viewBinding?.btnC?.setOnClickListener(this)
        viewBinding?.btnDot?.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(displayKey, viewBinding?.display?.text.toString())
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
        val result = viewBinding?.display?.text.toString().replace(" ", "").toDouble() * (-1)
        showOnDisplay(result)
    }

    override fun onPercent() {
        number = viewBinding?.display?.text.toString().replace(" ", "").toDouble()

        number /= 100
        showOnDisplay(number)
    }

    override fun onClear() {
        viewBinding?.display?.text = "0"
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
            viewBinding?.display?.text = ""
        }

        val result = (viewBinding?.display?.text.toString().replace(" ", "") + string).toDouble()
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

        viewBinding?.display?.text = tmpText
    }

    private fun onAction() {
        number = viewBinding?.display?.text.toString().replace(" ", "").toDouble()
        resetDisplay = true
        tmpNumber = null
    }

    private fun evaluate() {
        resetDisplay = true

        if (tmpNumber == null)
            tmpNumber = viewBinding?.display?.text.toString().replace(" ", "").toDouble()

        when (actionType) {
            Plus -> onPlus()
            Minus -> onMinus()
            Divide -> onDivide()
            Multiply -> onMultiply()
            Percent -> onPercent()
            else -> {}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}