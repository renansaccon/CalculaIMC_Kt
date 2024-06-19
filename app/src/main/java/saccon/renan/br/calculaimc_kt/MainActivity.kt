package saccon.renan.br.calculaimc_kt

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var tvPeso : TextView
    private lateinit var etPeso : EditText
    private lateinit var tvAltura : TextView
    private lateinit var etAltura : EditText
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button
    private lateinit var tvResultado : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPeso = findViewById(R.id.tvPeso)
        etPeso = findViewById(R.id.etPeso)
        tvAltura = findViewById(R.id.tvAltura)
        etAltura = findViewById(R.id.etAltura)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)
        tvResultado = findViewById(R.id.tvResultado)


        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener{
            btLimparOnClick()
        }


    }

    private fun btCalcularOnClick() {
        if (etPeso.text.isEmpty()){
            etPeso.setError("Favor preencher o peso")
            etPeso.requestFocus()
            return
        }

        if (etAltura.text.isEmpty()){
            etAltura.setError("Favor preencher a altura")
            etAltura.requestFocus()
            return
        }

        val vlPeso = etPeso.text.toString().toDouble()
        val vlAltura = etAltura.text.toString().toDouble()
        val vlResultado = vlPeso / vlAltura.pow(2)

        tvResultado.text = "%.2f".format(vlResultado)

    }

    private fun btLimparOnClick() {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.setText( "0.0" )
        etPeso.requestFocus()
        Toast.makeText(this, "Campos apagados", Toast.LENGTH_SHORT).show()

    }


}