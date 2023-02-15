package mx.itson.edu.calculadora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var operacion: Int = 0
    private var numero: Double = 0.0

    private lateinit var tvResultado: TextView
    private lateinit var tvOperacion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOperacion = findViewById(R.id.textViewSecundario)
        tvResultado = findViewById(R.id.textViewPrincipal)

        val btnDel: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnResult)

        btnIgual.setOnClickListener {
            try {
                val numero2: Double = tvResultado.text.toString().toDouble()
                val resp: Any = when (operacion) {
                    1 -> numero + numero2
                    2 -> numero - numero2
                    3 -> numero * numero2
                    4 -> if (numero2 == 0.0) "División por cero inválida" else numero / numero2
                    else -> ""
                }

                tvResultado.text = resp.toString()
                tvOperacion.text = ""
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Seleccione una operación", Toast.LENGTH_SHORT).show()
                resetAll()
            }

        }
        btnDel.setOnClickListener {
            resetAll()
        }
    }

    private fun resetAll() {
        tvOperacion.text = ""
        tvResultado.text = ""
        numero = 0.0
        operacion = 0
    }

    fun toque(view: View) {
        val tvResultado: TextView = findViewById(R.id.textViewPrincipal)
        val num2: String = tvResultado.text.toString()

        tvResultado.text = num2 + (view as Button).text
    }

    fun operacion(view: View) {
        try {
            numero = tvResultado.text.toString().toDouble()
            val num2Text: String = tvResultado.text.toString()
            tvResultado.text = ""
            when (view.id) {
                R.id.btnMas -> {
                    tvOperacion.text = "$num2Text+"
                    operacion = 1
                }
                R.id.btnResta -> {
                    tvOperacion.text = "$num2Text-"
                    operacion = 2
                }
                R.id.btnMult -> {
                    tvOperacion.text = "$num2Text*"
                    operacion = 3
                }
                R.id.btnDiv -> {
                    tvOperacion.text = "$num2Text/"
                    operacion = 4
                }
            }
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Seleccione una operación", Toast.LENGTH_SHORT).show()
            resetAll()
        }
    }
}
