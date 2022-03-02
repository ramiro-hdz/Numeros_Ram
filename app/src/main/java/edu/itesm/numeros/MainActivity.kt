package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val numeros = mutableListOf(0)
    var bandera = true
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI(){
        binding.promedio.setOnClickListener {
            binding.resultados.text = "${numeros.average()}"
        }
        binding.mayor.setOnClickListener {
            binding.resultados.text = "${numeros.maxOrNull()}"
        }
        binding.pares.setOnClickListener {
            var filteredList = numeros.filter { x -> x % 2 == 0 }
            binding.resultados.text = "${filteredList}"
        }
        binding.agregar.setOnClickListener {
            val nadd = binding.editTextNumberSigned.text.toString()
            val n2add = nadd.toIntOrNull()

            if (n2add != null){
                numeros.add(n2add)

                if(bandera){numeros.remove(0)}
                bandera = false
            }
            Toast.makeText(this,"${numeros}", Toast.LENGTH_LONG).show()
        }
    }
}