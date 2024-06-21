package saccon.renan.br.calculaimc_kt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.math.pow
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button
    private lateinit var tvResultado : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
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
            etPeso.error = getString(R.string.erro_peso)
            etPeso.requestFocus()
            return
        }

        if (etAltura.text.isEmpty()){
            etAltura.error = getString(R.string.erro_altura)
            etAltura.requestFocus()
            return
        }


        val vlPeso = etPeso.text.toString().toDouble()
        val vlAltura = etAltura.text.toString().toDouble()


        if  ( Locale.getDefault().language.equals( "en" )){
            val vlIMC = 703 * (vlPeso / vlAltura.pow(2))
            val nf = NumberFormat.getNumberInstance(Locale.US)
            tvResultado.text = nf.format( vlIMC )
        }
        else {
            val vlIMC = vlPeso / vlAltura.pow(2)
            val nf = NumberFormat.getNumberInstance(Locale.getDefault())
            tvResultado.text = nf.format( vlIMC )
        }
    }

    private fun btLimparOnClick() {
        etPeso.setText(getString(R.string.branco))
        etAltura.setText(getString(R.string.branco))
        tvResultado.text = getString(R.string.zeros)
        etPeso.requestFocus()
        Toast.makeText(this, getString(R.string.campos_apagados), Toast.LENGTH_LONG).show()

    }


}