package mx.itson.edu.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView;
import android.widget.Button;

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


        btnCero.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnCero.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnCero.text.toString())
                txtPrincipal.text = segundoValor
            }

        }

        btnUno.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnUno.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnUno.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnDos.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnDos.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnDos.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnTres.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnTres.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnTres.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnCuatro.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnCuatro.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnCuatro.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnCinco.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnCinco.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnCinco.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnSeis.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnSeis.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnSeis.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnSiete.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnSiete.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnSiete.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnOcho.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnOcho.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnOcho.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnNueve.setOnClickListener{
            if(!isUsingSymbol){
                primerValor = concatenateString(primerValor,btnNueve.text.toString())
                txtPrincipal.text = primerValor
            }else {
                segundoValor = concatenateString(segundoValor,btnNueve.text.toString())
                txtPrincipal.text = segundoValor
            }
        }

        btnMas.setOnClickListener{
            txtOperacion.text = primerValor + " + "
            txtPrincipal.text = segundoValor
            isUsingSymbol = true
            symbolPressed = "+"

        }

        btnMenos.setOnClickListener{
            txtOperacion.text = primerValor + " - "
            txtPrincipal.text = segundoValor
            isUsingSymbol = true
            symbolPressed = "-"
        }

        btnPor.setOnClickListener{
            txtOperacion.text = primerValor + " * "
            txtPrincipal.text = segundoValor
            isUsingSymbol = true
            symbolPressed = "*"
        }

        btnDiv.setOnClickListener{
            txtOperacion.text = primerValor + " / "
            txtPrincipal.text = segundoValor
            isUsingSymbol = true
            symbolPressed = "/"
        }

        btnBorrar.setOnClickListener{
            resetAll()
            txtOperacion.text = ""
            txtPrincipal.text = ""
        }

        btnResultado.setOnClickListener{
            primerValorInt = primerValor.toInt()
            segundoValorInt = segundoValor.toInt()

            val result = when(symbolPressed){
                "+" -> primerValorInt + segundoValorInt
                "-" -> primerValorInt - segundoValorInt
                "*" -> primerValorInt * segundoValorInt
                "/" -> primerValorInt / segundoValorInt
                else -> txtPrincipal.text = "Seleccione numeros"
            }
            txtOperacion.text = primerValor +" "+ symbolPressed +" "+ segundoValor
            txtPrincipal.text = result.toString()
            resetAll()
        }

    }

    fun resetAll(){
        isUsingSymbol = false
        primerValor = ""
        segundoValor = ""
    }

    fun concatenateString(currentlyString: String, newString: String): String {
        return currentlyString + newString
    }
}


