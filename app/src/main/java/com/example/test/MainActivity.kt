package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOk()) {

            try {
                //"Pegando" os valores que estão nos editTexts
                val distance = etDistance.text.toString().toFloat()
                val price = etPrice.text.toString().toFloat()
                val autonomy = etAutonomy.text.toString().toFloat()

                //Calculando o valor total do gasto
                val totalValue = (distance * price) / autonomy
                //Formatando a variavel de valor total para 2 casas decimais
                tvTotal.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validationOk(): Boolean {
        return etDistance.text.toString() != "" && etPrice.text.toString() != "" && etAutonomy.text.toString() != ""
    }

}

