package mx.itson.edu.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var primerValor: String = ""
    var segundoValor: String = ""

    var primerValorInt: Int = 0
    var segundoValorInt: Int = 0

    var isUsingSymbol: Boolean = false
    var symbolPressed: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtenemos todos los botones para poder darles funcionalidad
        val btnCero: Button = findViewById(R.id.btn0)
        val btnUno: Button = findViewById(R.id.btn1)
        val btnDos: Button = findViewById(R.id.btn2)
        val btnTres: Button = findViewById(R.id.btn3)
        val btnCuatro: Button = findViewById(R.id.btn4)
        val btnCinco: Button = findViewById(R.id.btn5)
        val btnSeis: Button = findViewById(R.id.btn6)
        val btnSiete: Button = findViewById(R.id.btn7)
        var btnOcho:  Button = findViewById(R.id.btn8)
        val btnNueve: Button = findViewById(R.id.btn9)

        val btnMas: Button = findViewById(R.id.btnMas)
        val btnMenos: Button = findViewById(R.id.btnResta)
        val btnPor: Button = findViewById(R.id.btnMult)
        val btnDiv: Button = findViewById(R.id.btnDiv)

        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnResultado: Button = findViewById(R.id.btnResult)

        val txtOperacion: TextView = findViewById(R.id.textViewSecundario)
        val txtPrincipal: TextView = findViewById(R.id.textViewPrincipal)

        val buttons = arrayOf(btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve)
        for (button in buttons) {
            button.setOnClickListener { asingValues(button) }
        }

        btnMas.setOnClickListener{
            setOperator("+")

        }

        btnMenos.setOnClickListener{
            setOperator("-")
        }

        btnPor.setOnClickListener{
            setOperator("*")
        }

        btnDiv.setOnClickListener{
            setOperator("/")
        }

        btnBorrar.setOnClickListener{
            resetAll()
            txtOperacion.text = ""
            txtPrincipal.text = ""
        }

        btnResultado.setOnClickListener{
            var result = 0
            var success = true
            try {
                primerValorInt = primerValor.toInt()
                segundoValorInt = segundoValor.toInt()

                result = when(symbolPressed){
                    "+" -> primerValorInt + segundoValorInt
                    "-" -> primerValorInt - segundoValorInt
                    "*" -> primerValorInt * segundoValorInt
                    "/" -> primerValorInt / segundoValorInt
                    else -> 0
                }
            }catch(e: Exception){
                txtPrincipal.text = ""
                txtOperacion.text = ""
                resetAll()
                success = false
            }
            if(success){
                txtOperacion.text = primerValor +" "+ symbolPressed +" "+ segundoValor
                txtPrincipal.text = result.toString()
                resetAll()
            }

        }

    }
    private fun setOperator(symbol: String) {
        val txtPrincipal: TextView = findViewById(R.id.textViewPrincipal)
        val txtOperacion: TextView = findViewById(R.id.textViewSecundario)
        txtOperacion.text = primerValor + " " + symbol + " "
        txtPrincipal.text = segundoValor
        isUsingSymbol = true
        symbolPressed = symbol
    }
    private fun asingValues(btn: Button){
        val txtPrincipal: TextView = findViewById(R.id.textViewPrincipal)
        if(!isUsingSymbol){
            primerValor = concatenateString(primerValor,btn.text.toString())
            txtPrincipal.text = primerValor
        }else {
            segundoValor = concatenateString(segundoValor,btn.text.toString())
            txtPrincipal.text = segundoValor
        }
    }
    private fun resetAll(){
        isUsingSymbol = false
        primerValor = ""
        segundoValor = ""
    }
    private fun concatenateString(currentlyString: String, newString: String): String {
        return currentlyString + newString
    }
}


